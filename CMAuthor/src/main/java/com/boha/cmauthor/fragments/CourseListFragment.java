package com.boha.cmauthor.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.*;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.VolleyError;
import com.boha.cmauthor.R;
import com.boha.cmauthor.adapter.CourseAdapter;
import com.boha.cmauthor.interfaces.CourseListener;
import com.boha.coursemaker.base.BaseVolley;
import com.boha.coursemaker.dto.CategoryDTO;
import com.boha.coursemaker.dto.CourseDTO;
import com.boha.coursemaker.dto.RequestDTO;
import com.boha.coursemaker.dto.ResponseDTO;
import com.boha.coursemaker.util.SharedUtil;
import com.boha.coursemaker.util.Statics;
import com.boha.coursemaker.util.ToastUtil;

import java.util.List;

public class CourseListFragment extends AbstractBuilder {

	TextView txtCount;

	private CourseListener courseListener;

	@Override
	public void onAttach(Activity a) {
		if (a instanceof CourseListener) {
			courseListener = (CourseListener) a;
		} else {
			throw new UnsupportedOperationException("Host "
					+ a.getLocalClassName() + " must implement CourseListener");
		}
		Log.i(LOG,
				"onAttach ---- Fragment called and hosted by "
						+ a.getLocalClassName());
		super.onAttach(a);
	}

	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle saved) {
		ctx = getActivity();
		inflater = getActivity().getLayoutInflater();
		view = inflater
				.inflate(R.layout.fragment_course_list, container, false);
		company = SharedUtil.getCompany(ctx);
		if (saved != null) {
			Log.i(LOG, "onCreateView - getting saved response");
			response = (ResponseDTO) saved.getSerializable("response");
		}
		setFields();

		return view;
	}

	FragmentManager fragmentManager;

	public void setFragmentManager(FragmentManager fm) {
		fragmentManager = fm;
	}

	public void showDialog() {
		FragmentManager fm = fragmentManager;
		ContentDialog cd = new ContentDialog();
		cd.setHeader(category.getCategoryName());
		cd.setLabel(ctx.getResources().getString(R.string.category));
		cd.setTitle(ctx.getResources().getString(R.string.course_editor));
		cd.setAddLabel(ctx.getResources().getString(R.string.add_course));

		if (isUpdate) {
			cd.setName(course.getCourseName());
			cd.setDesc(course.getDescription());
		}
		cd.setListener(new ContentDialog.ContentListener() {

			@Override
			public void onSaveButtonClicked(String name, String desc) {
				Log.i(LOG, "onSaveButtonClicked ...");
				if (course == null)
					course = new CourseDTO();
				course.setCourseName(name);
				course.setDescription(desc);
				sendCourseData(name, desc);
			}
		});
		cd.show(fm, "fragment_edit_name");
	}

	public void refreshCourse(ResponseDTO resp, int courseID) {
//		if (resp.getLessonList() != null) {
//			course.setLessonList(resp.getLessonList());
//			setList();
//			return;
//		}
//
//		for (CourseDTO c : resp.getCourseList()) {
//			if (c.getCourseID() == courseID) {
//				c.setLessonList(resp.getLessonList());
//			}
//		}
		setList();
	}

	public void setCourses(CategoryDTO category) {
		this.category = category;
		courseList = category.getCourseList();
		catName.setText(category.getCategoryName());
		setList();

	}

	@Override
	public void onResume() {
		Log.e(LOG, "############### onResume");
		if (response != null) {
			setList();
		}
		super.onResume();

	}

	@Override
	public void onSaveInstanceState(Bundle state) {
		Log.i(LOG, "##### onSaveInstanceState  fired ....");
		if (response != null) {
			state.putSerializable("response", response);
		}
		super.onSaveInstanceState(state);
	}

	class Container {
		List<CourseDTO> list;

	}

	@Override
	public void onLocalDataTaskDone() {

	}

	TextView catName;

	@Override
	public void setFields() {
		catName = (TextView) view.findViewById(R.id.CRS_category);
		txtHdrLabel = (TextView) view.findViewById(R.id.LH_label);
		txtHdrLabel.setText(getResources().getString(R.string.course_list));
		author = SharedUtil.getAuthor(ctx);
		listView = (ListView) view.findViewById(R.id.CRS_listView);
		
		txtCount = (TextView) view.findViewById(R.id.LH_count);

		txtCount.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(
						ctx,
						response.getCourseList().size()
								+ " : "
								+ ctx.getResources().getString(
										R.string.items_in_list),
						Toast.LENGTH_SHORT).show();

			}
		});

	}

	private void sendCourseData(String name, String desc) {


		if (isUpdate) {
			course.setCourseName(name);
			course.setDescription(desc);
			type = RequestDTO.UPDATE_COURSE;

		} else {
			course = new CourseDTO();
			course.setCategoryID(category.getCategoryID());
			course.setCourseName(name);
			course.setCompanyID(company.getCompanyID());
			course.setDescription(desc);
			type = RequestDTO.REGISTER_COURSE;
		}
		courseListener.setBusy();
		closeAddLayout();
		RequestDTO req = new RequestDTO();
		req.setCompanyID(company.getCompanyID());
		req.setAuthorID(author.getAuthorID());
		req.setRequestType(type);
		req.setZippedResponse(true);
		req.setCourse(course);
		BaseVolley.getRemoteData(Statics.SERVLET_AUTHOR, req, ctx,
				new BaseVolley.BohaVolleyListener() {

					@Override
					public void onVolleyError(VolleyError error) {
						ToastUtil.errorToast(
								ctx,
								ctx.getResources().getString(
										R.string.error_server_comms));
					}

					@Override
					public void onResponseReceived(ResponseDTO response) {
						courseListener.setNotBusy();

						if (response.getStatusCode() > 0) {
							ToastUtil.errorToast(ctx, response.getMessage());
							return;
						}
						courseList = response.getCourseList();
						int i = 0;
						for (CourseDTO c : courseList) {
							if (course.getCourseName().equalsIgnoreCase(
									c.getCourseName())) {
								break;
							}
							i++;
						}

						Log.w(LOG,
								"telling courseListener about added course. Courses returned - "
										+ courseList.size());
						setList();
						listView.setSelection(i);
						courseListener.onCourseAdded(courseList.get(i));

					}
				});
	}

	int priority;
	CourseAdapter adapter;

	@Override
	public void setList() {

		if (courseList == null || courseList.size() == 0) {
			showDialog();
			return;
		}
		adapter = new CourseAdapter(getActivity(), R.layout.course_item,
				courseList);

		listView.setAdapter(adapter);
		registerForContextMenu(listView);
		listView.setDividerHeight(5);
		txtCount.setText("" + courseList.size());
		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				course = category.getCourseList().get(arg2);
				courseListener.onCoursePicked(course);
			}
		});
		listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				course = category.getCourseList().get(arg2);
				return false;
			}
		});
		Animation a = AnimationUtils.loadAnimation(ctx, R.anim.xblink);
		a.setDuration(500);
		txtHdrLabel.startAnimation(a);
	}


	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);

		MenuInflater inflater = getActivity().getMenuInflater();
		inflater.inflate(R.menu.course_context, menu);
		menu.setHeaderIcon(android.R.drawable.ic_menu_preferences);
		if (course != null) {
			menu.setHeaderTitle(course.getCourseName());
		} else {
			menu.setHeaderTitle("Course Actions");
		}

	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
				.getMenuInfo();
		course = response.getCourseList().get(info.position);
		switch (item.getItemId()) {
		case R.id.menu_objectives:
			underConstruction();
			return true;
		case R.id.menu_delete:
			type = RequestDTO.DELETE_COURSE;
			underConstruction();
			// getRemoteData(type, Statics.SERVLET_AUTHOR, false);
			return true;
		case R.id.menu_update:
			isUpdate = true;
			editName.setText(course.getCourseName());
			editDescription.setText(course.getDescription());
			openAddLayout();
			return true;
		default:
			return super.onContextItemSelected(item);
		}
	}

	static final String LOG = "CourseListFragment";

	private void underConstruction() {
		ToastUtil.toast(ctx,
				"Feature is under construction! \n\nWatch this space!");
	}

	@Override
	public void networkCallDone(boolean isOK) {
		courseListener.setNotBusy();

	}
	TextView txtHdrLabel;
}
