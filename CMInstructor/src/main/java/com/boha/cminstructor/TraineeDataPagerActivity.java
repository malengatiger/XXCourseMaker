package com.boha.cminstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.volley.NetworkError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.boha.cminstructor.fragments.ClassListFragment;
import com.boha.cminstructor.fragments.CoursePageFragment;
import com.boha.cminstructor.fragments.CoursePageFragment.CoursePageFragmentListener;
import com.boha.cminstructor.fragments.DashboardFragment;
import com.boha.cmlibrary.listeners.RatingListener;
import com.boha.coursemaker.base.BaseVolley;
import com.boha.coursemaker.dto.CourseTraineeActivityDTO;
import com.boha.coursemaker.dto.HelpRequestDTO;
import com.boha.coursemaker.dto.InstructorClassDTO;
import com.boha.coursemaker.dto.RatingDTO;
import com.boha.coursemaker.dto.RequestDTO;
import com.boha.coursemaker.dto.ResponseDTO;
import com.boha.coursemaker.dto.TraineeDTO;
import com.boha.coursemaker.util.Statics;
import com.boha.coursemaker.util.ToastUtil;
import com.boha.volley.toolbox.BohaVolley;

public class TraineeDataPagerActivity extends FragmentActivity implements
		CoursePageFragmentListener, RatingListener {

	static final String LOG = "TraineePagerActivity";
	TextView txtPage, txtTip;
	ClassListFragment classListFragment;
	DashboardFragment dashboardFragment;
	List<RatingDTO> ratingList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ctx = getApplicationContext();
		setContentView(R.layout.activity_main_pager);
		mPager = (ViewPager) findViewById(R.id.pager);
		txtPage = (TextView) findViewById(R.id.PAGER_pageNumber);
		txtTip = (TextView) findViewById(R.id.PAGER_text);
		imageLoader = BohaVolley.getImageLoader(ctx);
		getData();
		setTitle(getResources().getString(R.string.trainee_eval));

	}

	HelpRequestDTO helpRequest;

	private void getData() {
		trainee = (TraineeDTO) getIntent().getExtras().getSerializable(
				"trainee");
		instructorClass = (InstructorClassDTO) getIntent().getExtras()
				.getSerializable("class");
		
	}

	@Override
	public void onResume() {
		Log.e(LOG, "---------------- onResume will get remote data... " + LOG);
		super.onResume();

		if (response == null) {
			setExistingFragments = false;
		} else {
			setExistingFragments = true;
		}
		
		getRemoteData();
	
	}

	@Override
	public void onSaveInstanceState(Bundle b) {
		Log.i(LOG, "onSaveInstanceState");
		
		super.onSaveInstanceState(b);
	}
	boolean setExistingFragments;

	private void setPages() {
		Log.i(LOG, "setting fragment pages from response received");
		// setRefreshActionButtonState(true);

		HashMap<String, String> map = new HashMap<String, String>();
		for (CourseTraineeActivityDTO dto : response
				.getCourseTraineeActivityList()) {
			if (!map.containsKey(dto.getCourseName())) {
				map.put(dto.getCourseName(), dto.getCourseName());
			}
		}
		Set<String> set = map.keySet();
		int index = 0;
		if (setExistingFragments) {
			Log.d(LOG, "setting lists to existing fragments ........");
			for (String key : set) {
				List<CourseTraineeActivityDTO> mList = new ArrayList<CourseTraineeActivityDTO>();
				for (CourseTraineeActivityDTO cta : response
						.getCourseTraineeActivityList()) {
					if (key.equalsIgnoreCase(cta.getCourseName())) {
						mList.add(cta);
					}
				}
				pageList.get(index).setCourseTraineeActivityList(mList);
				index++;
			}
			mAdapter.notifyDataSetChanged();
		} else {
			pageList = new ArrayList<CoursePageFragment>();
			for (String key : set) {
				List<CourseTraineeActivityDTO> mList = new ArrayList<CourseTraineeActivityDTO>();
				for (CourseTraineeActivityDTO cta : response
						.getCourseTraineeActivityList()) {
					if (key.equalsIgnoreCase(cta.getCourseName())) {
						mList.add(cta);
					}
				}
				// set mList to fragment in pager
				CoursePageFragment cpf = new CoursePageFragment();
				cpf.setCourseName(key);
				cpf.setCourseTraineeActivityList(mList);
				cpf.setRatingList(ratingList);
				cpf.setImageLoader(imageLoader);
				pageList.add(cpf);
				index++;
			}
			numberOfPages = pageList.size();
			txtPage.setText("Page 1 of " + numberOfPages);
			initializePager();
		}
	}

	public void initializePager() {
		mAdapter = new PagerAdapter(getSupportFragmentManager());
		mPager.setAdapter(mAdapter);
		mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				currentPage = arg0;
				txtPage.setText("Page " + (currentPage + 1) + " of "
						+ numberOfPages);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	@Override
	public void onPause() {
		Log.i(LOG, "-- onPause ---");
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
		super.onPause();
	}

	Menu mMenu;

	public void setRefreshActionButtonState(final boolean refreshing) {
		if (mMenu != null) {
			final MenuItem refreshItem = mMenu.findItem(R.id.menu_back);
			if (refreshItem != null) {
				if (refreshing) {
					refreshItem.setActionView(R.layout.action_bar_progess);
				} else {
					refreshItem.setActionView(null);
				}
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.trainee_pager, menu);
		mMenu = menu;
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.menu_calendar:
			Intent i = new Intent(this, CalendarActivity.class);
			startActivity(i);
			return true;
		case R.id.menu_back:
			onBackPressed();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onBackPressed() {
		
		finish();
		super.onBackPressed();
	}
	public void getRemoteData()  {	
		RequestDTO request = new RequestDTO();
		request.setRequestType(RequestDTO.GET_TRAINEE_ACTIVITY_LIST);
		request.setTraineeID(trainee.getTraineeID());
		request.setZippedResponse(true);
		
		if (!BaseVolley.checkNetworkOnDevice(ctx)) return;
		setRefreshActionButtonState(true);
		BaseVolley.getRemoteData(Statics.SERVLET_INSTRUCTOR, request, ctx, new BaseVolley.BohaVolleyListener() {
			
			@Override
			public void onVolleyError(VolleyError error) {
				setRefreshActionButtonState(false);
				Log.e(LOG, "Problem: " + error.getMessage());
				if (error instanceof NetworkError) {
					NetworkError ne = (NetworkError) error;
					if (ne.networkResponse != null) {
						Log.w(LOG, "volley http status code: "
								+ ne.networkResponse.statusCode);
					}
					ToastUtil.errorToast(
							ctx,
							ctx.getResources().getString(
									R.string.error_server_unavailable));
				} else {
					ToastUtil.errorToast(
							ctx,
							ctx.getResources().getString(
									R.string.error_server_comms));
				}
			}
			
			@Override
			public void onResponseReceived(ResponseDTO r) {
				setRefreshActionButtonState(false);
				response = r;
				Log.e(LOG, "...Yup! got a response from the server");
				if (r.getStatusCode() > 0) {
					ToastUtil.errorToast(ctx, r.getMessage());
					return;
				}
				setPages();
			}
		});

		
	}

	int currentPage;
	ResponseDTO response;
	TraineeDTO trainee;
	InstructorClassDTO instructorClass;

	private class PagerAdapter extends FragmentStatePagerAdapter {

		public PagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int i) {

			return (Fragment) pageList.get(i);
		}

		@Override
		public int getCount() {
			return pageList.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			CoursePageFragment cpf = pageList.get(position);
			return cpf.getCourseName();
		}
	}

	ViewPager mPager;
	static List<CoursePageFragment> pageList;
	static int numberOfPages;
	PagerAdapter mAdapter;
	Context ctx;
	ImageLoader imageLoader;

	@Override
	public void onRefreshRequested() {
		Log.e(LOG, "onRefreshRequested ... getting remote data");
		getRemoteData();
		

	}

	@Override
	public void onRatingCompleted(CourseTraineeActivityDTO courseTraineeActivity) {
		Log.w(LOG, "onRatingCompleted ...");
		
	}

	@Override
	public void onCancelRating() {
		Log.w(LOG, "onCancelRating");
		
	}
}
