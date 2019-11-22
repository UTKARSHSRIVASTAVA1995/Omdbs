package com.example.omdbs;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.MovieViewHolder> {

    private List<MovieSearchList.Search> moviesList;

    private Context context;

    public MovieRecyclerAdapter(Context context, List<MovieSearchList.Search> moviesList) {
        this.context = context;
        this.moviesList = moviesList;

    }

    @Override

    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies, parent, false);


        return new MovieViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        MovieSearchList.Search movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        Glide.with(context)
                .load(movie.getPoster())
                .into(holder.poster);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MovieDetailsFragment.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        return moviesList.size();

    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView poster;

        public MovieViewHolder(View view) {

            super(view);

            title = view.findViewById(R.id.title);
            poster = view.findViewById(R.id.poster);
        }
    }
}

