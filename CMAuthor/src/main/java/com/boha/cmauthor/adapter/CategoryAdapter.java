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
import com.boha.coursemaker.dto.CategoryDTO;
import com.boha.coursemaker.dto.CourseDTO;
import com.boha.coursemaker.util.Statics;

import java.util.List;

public class CategoryAdapter extends ArrayAdapter<CategoryDTO> {

	private final LayoutInflater mInflater;
	private final int mLayoutRes;
	private List<CategoryDTO> mList;
	private Context ctx;

	public CategoryAdapter(Context context, int textViewResourceId,
			List<CategoryDTO> list) {
		super(context, textViewResourceId, list);
		this.mLayoutRes = textViewResourceId;

		mList = list;
		ctx = context;
		this.mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = mInflater.inflate(mLayoutRes, parent, false);

		if (convertView == null) {
			view = mInflater.inflate(mLayoutRes, parent, false);
		} else {
			view = convertView;
		}
		TextView cat = (TextView) view
				.findViewById(R.id.CATITEM_categoryName);
		TextView cnt = (TextView) view
				.findViewById(R.id.CATITEM_count);
        TextView cntx = (TextView) view
                .findViewById(R.id.CATITEM_countx);
		final CategoryDTO p = mList.get(position);
		cat.setText(p.getCategoryName());
        int count = 0;
		if (p.getCourseList() != null) {
			if (p.getCourseList().size() < 10) {
				cnt.setText("0" + p.getCourseList().size());
			} else {
				cnt.setText("" + p.getCourseList().size());
			}
            for (CourseDTO d: p.getCourseList() ) {
                count += d.getActivityList().size();
            }
            cntx.setText("" + count);
		} else {
			cnt.setText("00");
            cntx.setText("00");
		}
		Statics.setRobotoFontRegular(ctx, cat);
		
		RowColor.setColor(view, position);
		animateView(view);


		return (view);
	}
	public void animateView(final View view) {
		Animation a = AnimationUtils.loadAnimation(
				ctx, R.anim.grow_fade_in_center);
		a.setDuration(500);			
		view.startAnimation(a);
	}
	
}
