package com.boha.cmauthor;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.VolleyError;
import com.boha.cmauthor.fragments.CourseOverViewFragment;
import com.boha.coursemaker.base.BaseVolley;
import com.boha.coursemaker.dto.CategoryDTO;
import com.boha.coursemaker.dto.CourseDTO;
import com.boha.coursemaker.dto.RequestDTO;
import com.boha.coursemaker.dto.ResponseDTO;
import com.boha.coursemaker.listeners.PageInterface;
import com.boha.coursemaker.util.Statics;
import com.boha.coursemaker.util.ToastUtil;

public class CourseOverviewPagerActivity extends FragmentActivity {

	public CourseOverviewPagerActivity() {
	}

	CategoryDTO category;
	ViewPager mPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.course_pager);

		mPager = (ViewPager) findViewById(R.id.pager);
		category = (CategoryDTO) getIntent().getSerializableExtra("category");
		setTitle(category.getCategoryName());
		buildMasterPages();

	}


	@Override
	public void onBackPressed() {

		finish();
		super.onBackPressed();

	}

	static final String LOG = "CourseOverviewPagerActivity";

	@Override
	public void onPause() {
		overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
		super.onPause();
	}

	public void setRefreshActionButtonState(final boolean refreshing) {
		if (menu != null) {
			final MenuItem refreshItem = menu.findItem(R.id.menu_refresh);
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
		getMenuInflater().inflate(R.menu.course_pager, menu);
		this.menu = menu;
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.menu_refresh:
			return true;

		case android.R.id.home:
			Intent intent = new Intent(this, CategoryActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;

		case R.id.menu_back:
			onBackPressed();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void initializePager() {
		mAdapter = new MyAdapter(getSupportFragmentManager(), numberOfPages,
				this);

		mPager.setAdapter(mAdapter);
		mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				currentPage = arg0;
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	int currentPage;

	public void buildMasterPages() {
		pageList = new ArrayList<PageInterface>();
		for (CourseDTO c : category.getCourseList()) {
			CourseOverViewFragment cof = new CourseOverViewFragment();
			Bundle b = new Bundle();
			b.putSerializable("course", c);
			cof.setArguments(b);
			pageList.add(cof);
		}

		numberOfPages = pageList.size();
		initializePager();

	}

	private Menu menu;

	public static class MyAdapter extends FragmentStatePagerAdapter {
		CourseOverviewPagerActivity pager;

		public MyAdapter(FragmentManager fm, int pages,
				CourseOverviewPagerActivity pager) {
			super(fm);
			numberOfPages = pages;
			this.pager = pager;
		}

		@Override
		public int getCount() {
			return numberOfPages;
		}

		@Override
		public Fragment getItem(int position) {
			return (Fragment) pageList.get(position);

		}

		@Override
		public CharSequence getPageTitle(int position) {
			String title = "Title";
			CourseOverViewFragment cof = (CourseOverViewFragment) pageList
					.get(position);
			if (cof != null) {
				if (cof.getCourse() != null) {
					title = cof.getCourse().getCourseName();
				}
			}
			return title;
		}
	}

	static List<PageInterface> pageList;
	static int numberOfPages;
	MyAdapter mAdapter;
	List<CourseDTO> courseList;

}
