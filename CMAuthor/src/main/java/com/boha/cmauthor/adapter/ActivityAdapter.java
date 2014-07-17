package com.boha.cmauthor.adapter;

import java.util.List;

import android.content.Context;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.boha.cmauthor.R;
import com.boha.cmauthor.interfaces.UpDownArrrowListener;
import com.boha.cmauthor.misc.RowColor;
import com.boha.coursemaker.dto.ActivityDTO;
import com.boha.coursemaker.util.Statics;

public class ActivityAdapter extends ArrayAdapter<ActivityDTO> {

	private final LayoutInflater mInflater;
	private final int mLayoutRes;
	private List<ActivityDTO> mList;
	private UpDownArrrowListener listener;
	private Vibrator vb;
	private Context ctx;
	private boolean hideDescription;

	public ActivityAdapter(Context context, int textViewResourceId,
			List<ActivityDTO> list, UpDownArrrowListener listener, boolean hideDescription) {
		super(context, textViewResourceId, list);
		this.mLayoutRes = textViewResourceId;
		mList = list;
		ctx = context;
		this.hideDescription = hideDescription;
		this.listener = listener;
		vb = (Vibrator) ctx.getSystemService(Context.VIBRATOR_SERVICE);
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

		TextView btnDown = (TextView) view.findViewById(R.id.CRSITEM_btnDown);
		TextView btnUp = (TextView) view.findViewById(R.id.CRSITEM_btnUo);
		TextView name = (TextView) view.findViewById(R.id.CRSITEM_name);
		TextView desc = (TextView) view.findViewById(R.id.CRSITEM_desc);
		TextView priority = (TextView) view.findViewById(R.id.CRSITEM_priority);

		final int index = position;
		final ActivityDTO p = mList.get(position);

		name.setText(p.getActivityName());
		if (hideDescription) {
			desc.setVisibility(View.GONE);
		} else {
			desc.setText(p.getDescription());
			desc.setVisibility(View.VISIBLE);
		}
		Statics.setRobotoFontBold(ctx, name);
		Statics.setRobotoFontBold(ctx, priority);
		Statics.setRobotoFontRegular(ctx, desc);
		if (position > 9) {
			priority.setText("" + (position + 1));
		} else {
			priority.setText("0" + (position + 1));
		}

		btnDown.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				vb.vibrate(30);
				listener.onDownArrowTapped(index);
			}
		});
		btnUp.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				vb.vibrate(30);
				listener.onUpArrowTapped(index);
			}
		});
		RowColor.setColor(view, position);
		animateView(view);
		return (view);
	}

	public void animateView(final View view) {
		Animation a  = AnimationUtils.loadAnimation(
				ctx, R.anim.grow_fade_in_center);
		a.setDuration(500);
			
		view.startAnimation(a);
	}

	public static final int SLIDE_IN_LEFT = 1, SLIDE_OUT_RIGHT = 2,
			PUSH_UP = 3, PUSH_DOWN = 4;
}
