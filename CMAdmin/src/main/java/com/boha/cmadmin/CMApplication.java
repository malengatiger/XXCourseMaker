package com.boha.cmadmin;

import com.boha.coursemaker.dto.TrainingClassDTO;
import com.boha.coursemaker.util.Constants;
import com.boha.coursemaker.util.SharedUtil;
import com.google.gson.Gson;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;

public class CMApplication extends Application {

	public CMApplication() {
	}
	
	@Override
	public void onCreate() {
		Log.e("CMApp", "### CMApplication starting ...");
		trainingClass = SharedUtil.getTrainingClass(getApplicationContext());
		if (trainingClass != null) {
			Log.i("CMApp", "Last Training class resumed: " 
					+ trainingClass.getTrainingClassName());
		}
	}

	private TrainingClassDTO trainingClass;
	private SharedPreferences sp;
	private Gson gson = new Gson();

	public TrainingClassDTO getTrainingClass() {
		return trainingClass;
	}

	public void setTrainingClass(TrainingClassDTO trainingClass) {
		sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		String json = gson.toJson(trainingClass);
		Editor ed = sp.edit();
		ed.putString(Constants.TRAINING_CLASS, json);
		ed.commit();
		
		this.trainingClass = trainingClass;
		
		Log.e("CMApp", "Training class has been set in CMApp: "
		+ trainingClass.getTrainingClassName());
	}
}
