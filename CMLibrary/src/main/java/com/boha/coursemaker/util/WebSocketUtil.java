package com.boha.coursemaker.util;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.boha.coursemaker.dto.RequestDTO;
import com.boha.coursemaker.dto.ResponseDTO;
import com.google.gson.Gson;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;

/**
 * Utility class to manage web socket communications for the application
 * Created by aubreyM on 2014/08/10.
 */
public class WebSocketUtil {
    public interface WebSocketListener {
        public void onMessage(ResponseDTO response);

        public void onClose();

        public void onError(String message);

        public void onSessionIDreceived(String sessionID);
    }

    static WebSocketListener webSocketListener;
    static RequestDTO request;
    static Context ctx;
    static long start, end;

    public static void sendRequest(Context c, String suffix, RequestDTO req, WebSocketListener listener)  {
        start = System.currentTimeMillis();
        webSocketListener = listener;
        request = req;
        ctx = c;
        try {
            if (mWebSocketClient == null) {
                connectWebSocket(suffix);
            } else {
                String json = gson.toJson(req);
                mWebSocketClient.send(json);
                Log.d(LOG, "########### web socket message sent\n" + json);
            }
        } catch (URISyntaxException e) {
            Log.e(LOG,"Problems with web socket", e);
            webSocketListener.onError("Problem starting server socket communications");
        }
    }



    private static void connectWebSocket(String socketSuffix) throws URISyntaxException {
        URI uri = new URI(Statics.WEBSOCKET_URL + socketSuffix);

        mWebSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                Log.w(LOG, "########## WEBSOCKET Opened: " + serverHandshake.getHttpStatusMessage());
                String json = gson.toJson(request);
                mWebSocketClient.send(json);
                Log.d(LOG, "########### web socket request sent after onOpen\n" + json);
            }

            @Override
            public void onMessage(String response) {
                end = System.currentTimeMillis();
                Log.i(LOG, "########## onMessage received, length: " + response.length() + " String: " + response);
                try {
                    ResponseDTO r = gson.fromJson(response, ResponseDTO.class);
                    if (r.getStatusCode() == 0) {
                        if (r.getSessionID() != null) {
                            SharedUtil.setSessionID(ctx, r.getSessionID());
                            webSocketListener.onSessionIDreceived(r.getSessionID());
                        } else {
                            webSocketListener.onMessage(r);
                        }
                    } else {
                        webSocketListener.onError(r.getMessage());
                    }
                } catch (Exception e) {
                    Log.e(LOG, "Failed to parse response from server", e);
                    webSocketListener.onError("Failed to parse response from server");
                }

            }

            @Override
            public void onMessage(ByteBuffer bb) {
                end = System.currentTimeMillis();
                Log.i(LOG, "########## onMessage ByteBuffer capacity: " + bb.capacity());
                File dir = Environment.getExternalStorageDirectory();
                File zip = new File(dir, "data.zip");
                File unZip = new File(dir, "data.json");
                BufferedOutputStream stream = null;
                String content = null;
                try {
                    FileOutputStream fos = new FileOutputStream(zip);
                    stream = new BufferedOutputStream(fos);
                } catch (FileNotFoundException e) {
                    Log.e(LOG, "Failed to get output file", e);
                    webSocketListener.onError("Failed to get output file for saving server response");
                    return;
                }
                try {
                    stream.write(bb.array());
                    stream.flush();
                    stream.close();
                    Log.d(LOG, "###### zip file: " + zip.getAbsolutePath() + " length: " + zip.length());
                    content = ZipUtil.unpack(zip, unZip);
                    Log.d(LOG, "################ unpacked length: " + unZip.length());
                    if (content != null) {
                        Log.w(LOG, "############# onMessage ByteBuffer content:\n" + content);
                        ResponseDTO response = gson.fromJson(content, ResponseDTO.class);
                        if (response.getStatusCode() == 0) {
                            webSocketListener.onMessage(response);
                        } else {
                            webSocketListener.onError(response.getMessage());
                        }
                    } else {
                        webSocketListener.onError("Content from server failed. Response is null");
                    }
                } catch (IOException e) {
                    Log.e(LOG, "onMessage Failed", e);
                    webSocketListener.onError("Failed to unpack server response");
                }
            }


            @Override
            public void onClose(final int i, String s, boolean b) {
                Log.e(LOG, "########## WEBSOCKET onClose, status code:  " + i);
                webSocketListener.onClose();
            }

            @Override
            public void onError(final Exception e) {
                Log.e(LOG, "onError ", e);
                webSocketListener.onError("Server communications failed. Please try again");


            }
        };

        Log.d(LOG, "------------- starting mWebSocketClient.connect ...");
        mWebSocketClient.connect();
    }

    static WebSocketClient mWebSocketClient;
    static final String LOG = WebSocketUtil.class.getName();
    static final Gson gson = new Gson();
}
