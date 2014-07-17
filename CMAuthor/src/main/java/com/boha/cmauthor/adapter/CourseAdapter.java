package com.boha.cmauthor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.boha.cmauthor.R;
import com.boha.cmauthor.misc.RowColor;
import com.boha.coursemaker.dto.CourseDTO;
import com.boha.coursemaker.util.Statics;

import java.util.List;

public class CourseAdapter extends ArrayAdapter<CourseDTO> {

	private final LayoutInflater mInflater;
	private final int mLayoutRes;
	private List<CourseDTO> mList;
	private Context ctx;
	private CourseDTO course;

	public CourseAdapter(Context context, int textViewResourceId,
			List<CourseDTO> list) {
		super(context, textViewResourceId, list);
		this.mLayoutRes = textViewResourceId;
		mList = list;
		ctx = context;
		this.mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	View view;

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		view = mInflater.inflate(mLayoutRes, parent, false);

		if (convertView == null) {
			view = mInflater.inflate(mLayoutRes, parent, false);
		} else {
			view = convertView;
		}

		TextView name = (TextView) view.findViewById(R.id.CRSITEM_name);
		TextView desc = (TextView) view.findViewById(R.id.CRSITEM_desc);
		TextView cnt = (TextView) view.findViewById(R.id.CRSITEM_count);
		TextView pr = (TextView) view.findViewById(R.id.CRSITEM_priority);

		course = mList.get(position);

		name.setText(course.getCourseName());
		desc.setText(course.getDescription());
		Statics.setRobotoFontBold(ctx, name);
		Statics.setRobotoFontRegular(ctx, desc);
		if (course.getActivityList()
                != null) {
			if (course.getActivityList().size() < 10) {
				cnt.setText("0" + course.getActivityList().size());
			} else {
				cnt.setText("" + course.getActivityList().size());
			}
		}
		if (position > 9) {
			pr.setText("" + (position + 1));
		} else {
			pr.setText("0" + (position + 1));
		}

		RowColor.setColor(view, position);
		animateView(view);


		return (view);
	}

	public void animateView(final View view) {
		Animation a = AnimationUtils.loadAnimation(
				ctx, R.anim.grow_fade_in_center);
		a.setDuration(1000);
		view.startAnimation(a);
	}



}
