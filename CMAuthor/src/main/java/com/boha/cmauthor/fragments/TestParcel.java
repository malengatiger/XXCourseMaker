package com.boha.cmauthor.fragments;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by aubreyM on 2014/08/05.
 */
public class TestParcel implements Parcelable {
    private int id;
    private String name, email;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.name);
        dest.writeString(this.email);
    }

    public TestParcel() {
    }

    private TestParcel(Parcel in) {
        this.id = in.readInt();
        this.name = in.readString();
        this.email = in.readString();
    }

    public static final Parcelable.Creator<TestParcel> CREATOR = new Parcelable.Creator<TestParcel>() {
        public TestParcel createFromParcel(Parcel source) {
            return new TestParcel(source);
        }

        public TestParcel[] newArray(int size) {
            return new TestParcel[size];
        }
    };
}
