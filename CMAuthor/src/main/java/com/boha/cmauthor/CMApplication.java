package com.boha.cmauthor;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;
import com.boha.coursemaker.dto.ActivityDTO;
import com.boha.coursemaker.dto.ResponseDTO;
import com.boha.coursemaker.util.Constants;
import com.boha.coursemaker.util.Statics;
import com.google.gson.Gson;
import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.annotation.ReportsCrashes;

import java.util.List;

@ReportsCrashes(
        formKey = "",
        formUri = Statics.CRASH_REPORTS_URL,
        customReportContent = {ReportField.APP_VERSION_NAME, ReportField.APP_VERSION_CODE,
                ReportField.ANDROID_VERSION, ReportField.PHONE_MODEL, ReportField.BRAND, ReportField.STACK_TRACE,
                ReportField.PACKAGE_NAME,
                ReportField.CUSTOM_DATA,
                ReportField.LOGCAT},
        socketTimeout = 3000
)

public class CMApplication extends Application {

	public CMApplication() {
	}
	
	@Override
	public void onCreate() {
		Log.e("CMApp", "########################## CMApplication starting ...");
        ACRA.init(this);
        Log.e(LOG, "###### ACRA Crash Reporting has been initiated");
	}
    static final String LOG = "CMApplication";
	private boolean activitiesShuffled;
	private List<ActivityDTO> activityList;
	Integer lastCourseViewed;
	private ResponseDTO response;
	 SharedPreferences sp;
	 Gson gson = new Gson();
	public boolean isActivitiesShuffled() {
		return activitiesShuffled;
	}

	public void setActivitiesShuffled(boolean activitiesShuffled) {
		this.activitiesShuffled = activitiesShuffled;
		if (this.activitiesShuffled) {
			Log.i("CMAPP", "Activities have been shuffled around");
			//refresh from server ...
		}
	}

	public ResponseDTO getResponse() {
		return response;
	}

	public void setResponse(ResponseDTO response) {
		this.response = response;
	}

	public Integer getLastCourseViewed() {
		return lastCourseViewed;
	}

	public void setLastCourseViewed(Integer courseID) {
		this.lastCourseViewed = courseID;
		sp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		Editor ed = sp.edit();
		ed.putInt(Constants.LAST_COURSE_ID, courseID);
		ed.commit();
	}

	public List<ActivityDTO> getActivityList() {
		return activityList;
	}

	public void setActivityList(List<ActivityDTO> activityList) {
		this.activityList = activityList;
	}

	
	
}
