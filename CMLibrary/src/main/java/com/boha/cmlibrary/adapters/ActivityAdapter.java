package com.boha.cmlibrary.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.boha.cmlibrary.R;
import com.boha.coursemaker.dto.CourseTraineeActivityDTO;
import com.boha.coursemaker.dto.InstructorRatingDTO;
import com.boha.coursemaker.dto.TraineeRatingDTO;
import com.boha.coursemaker.util.Statics;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ActivityAdapter extends ArrayAdapter<CourseTraineeActivityDTO> {

    public interface HelpMeListener {
        public void onHelpRequested(CourseTraineeActivityDTO cta);
    }
	private final LayoutInflater mInflater;
	private final int mLayoutRes;
	private List<CourseTraineeActivityDTO> mList;
	private Context ctx;
	private boolean hideDescription;
    private HelpMeListener helpMeListener;

	public ActivityAdapter(Context context, int textViewResourceId,
			List<CourseTraineeActivityDTO> list, boolean hideDescription, HelpMeListener helpMeListener) {
		super(context, textViewResourceId, list);
		this.mLayoutRes = textViewResourceId;
		mList = list;
        this.helpMeListener = helpMeListener;
		ctx = context;
		this.hideDescription = hideDescription;
		this.mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

    //TODO - refactor to use viewHolder **************
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = mInflater.inflate(mLayoutRes, parent, false);

		if (convertView == null) {
			view = mInflater.inflate(mLayoutRes, parent, false);
		} else {
			view = convertView;
		}

		
		TextView name = (TextView) view.findViewById(R.id.AR_txtActName);
		TextView desc = (TextView) view.findViewById(R.id.AR_txtActDesc);
		TextView priority = (TextView) view.findViewById(R.id.AR_txtPriority);
		TextView cb = (TextView)view.findViewById(R.id.AR_completeMsg);
		TextView date = (TextView)view.findViewById(R.id.AR_completionDate);
		TextView traineeRating = (TextView)view.findViewById(R.id.AR_tRating);
		TextView insRating = (TextView)view.findViewById(R.id.AR_instructorRating);
        ImageView help = (ImageView)view.findViewById(R.id.AR_imageHelp);

		final CourseTraineeActivityDTO p = mList.get(position);

		name.setText(p.getActivity().getActivityName());
		if (hideDescription) {
			desc.setVisibility(View.GONE);
		} else {
			desc.setText(p.getActivity().getDescription());
			desc.setVisibility(View.VISIBLE);
		}
		if (p.getActivity().getDescription().isEmpty()) {
			desc.setText(ctx.getResources().getString(R.string.no_description));
		}
		if (p.getCompletedFlag() > 0) {
			cb.setText(ctx.getResources().getString(R.string.task_complete));
			cb.setTextColor(ctx.getResources().getColor(R.color.green));
			if (p.getCompletionDate() > 0) {
				Date d = new Date(p.getCompletionDate());
				date.setText(sdf.format(d));
				date.setVisibility(View.VISIBLE);
			} else {
				date.setVisibility(View.GONE);
			}
			Statics.setRobotoFontBold(ctx, cb);
		} else {
			cb.setText(ctx.getResources().getString(R.string.task_incomplete));
			cb.setTextColor(ctx.getResources().getColor(R.color.black));
			date.setVisibility(View.GONE);
			Statics.setRobotoItalic(ctx, cb);
		}
		traineeRating.setText(df2.format(getTraineeRatingAverage(p)) + "%");
		insRating.setText(df2.format(getInstructorRatingAverage(p)) + "%");
		
		Statics.setRobotoFontBold(ctx, name);
		Statics.setRobotoFontBold(ctx, priority);
		Statics.setRobotoFontRegular(ctx, desc);
		if (position > 9) {
			priority.setText("" + (position + 1));
		} else {
			priority.setText("0" + (position + 1));
		}

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helpMeListener.onHelpRequested(p);
            }
        });
		
		animateView(view);
		return (view);
	}

	private double getInstructorRatingAverage(CourseTraineeActivityDTO p) {
		int totalInstructorTotal = 0;
		if (p.getInstructorRatingList() == null || p.getInstructorRatingList().isEmpty()) {
			return 0;
		}
		for (InstructorRatingDTO tr : p.getInstructorRatingList()) {
			totalInstructorTotal += tr.getRating().getRatingNumber();
		}
		
		Double d = Double.valueOf(totalInstructorTotal);
		Double t = Double.valueOf(p.getInstructorRatingList().size());
		Double avg = (d/t);
		
		return avg.doubleValue();
	}
	private double getTraineeRatingAverage(CourseTraineeActivityDTO p) {
		int totalTraineeTotal = 0;
		if (p.getTraineeRatingList() == null || p.getTraineeRatingList().isEmpty()) {
			return 0;
		}
        for (TraineeRatingDTO tr : p.getTraineeRatingList()) {
			totalTraineeTotal += tr.getRating().getRatingNumber();
		}
		Double d = Double.valueOf(totalTraineeTotal);
		Double t = Double.valueOf(p.getTraineeRatingList().size());
		Double avg = (d/t);
		
		return avg.doubleValue();
	}
	public void animateView(final View view) {
		Animation a  = AnimationUtils.loadAnimation(
				ctx, R.anim.grow_fade_in);
		a.setDuration(500);		
		view.startAnimation(a);
	}

	static final DecimalFormat df1 = new DecimalFormat("###,###,###,###");
	static final DecimalFormat df2 = new DecimalFormat("###,###,###.0");
	private static final Locale locale = Locale.getDefault();
	private static final SimpleDateFormat sdf = new  SimpleDateFormat("dd MMM yyyy HH:mm", locale);
	
}
