package com.boha.cminstructor.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.boha.cminstructor.R;
import com.boha.coursemaker.dto.TrainingClassCourseDTO;
import com.boha.coursemaker.util.Statics;

import java.util.List;

public class CourseAdapter extends ArrayAdapter<TrainingClassCourseDTO> {

	private final LayoutInflater mInflater;
	private final int mLayoutRes;
	private List<TrainingClassCourseDTO> mList;
	private Context ctx;
	private TrainingClassCourseDTO course;

	public CourseAdapter(Context context, int textViewResourceId,
			List<TrainingClassCourseDTO> list) {
		super(context, textViewResourceId, list);
		this.mLayoutRes = textViewResourceId;
		mList = list;
		ctx = context;
		this.mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	View view;
    //TODO - refactor to ViewHolder pattern

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
		cnt.setText("" + course.getNumberOfActivities());
		Statics.setRobotoFontBold(ctx, name);
		Statics.setRobotoFontRegular(ctx, desc);


			if (course.getPriorityFlag() > 9) {
				pr.setText("" + (course.getPriorityFlag()));
			} else {
				pr.setText("0" + (course.getPriorityFlag()));
			}


		//RowColor.setColor(view, position);
		animateView(view);

		return (view);
	}

	public void animateView(final View view) {
		Animation a = AnimationUtils.loadAnimation(ctx,
				R.anim.grow_fade_in);
		a.setDuration(500);
		view.startAnimation(a);
	}

}
