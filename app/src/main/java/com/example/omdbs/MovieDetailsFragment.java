package com.example.omdbs;

import android.app.Dialog;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.squareup.picasso.Picasso;

public class MovieDetailsFragment extends BottomSheetDialogFragment {

    private TextView title, release, time, description;
    private ImageView poster;

    public MovieDetailsFragment() {

    }

    @Override
    public void setupDialog(final Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.fragment_movie_details, null);

        poster = contentView.findViewById(R.id.sheet_poster);
        title =  contentView.findViewById(R.id.sheet_title);
        release =  contentView.findViewById(R.id.sheet_release);
        time =  contentView.findViewById(R.id.sheet_time);
        description =  contentView.findViewById(R.id.sheet_description);

        Picasso.with(getContext()).load(getArguments().getString("poster")).fit().into(poster);
        title.setText(getArguments().getString("title"));
        release.setText(getArguments().getString("release"));
        time.setText(getArguments().getString("time"));
        description.setText(getArguments().getString("description"));
        dialog.setContentView(contentView);
    }
}

