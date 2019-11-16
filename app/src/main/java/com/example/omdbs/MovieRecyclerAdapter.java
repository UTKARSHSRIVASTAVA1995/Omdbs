package com.example.omdbs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class MovieRecyclerAdapter extends RecyclerView.Adapter<MovieRecyclerAdapter.MovieViewHolder> {

    private List<MovieSearchList.Search> moviesList;

    private Context context;

    public MovieRecyclerAdapter(Context context, List<MovieSearchList.Search> moviesList) {
        this.context=context;
        this.moviesList = moviesList;

    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies, parent, false);

        return new MovieViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        MovieSearchList.Search movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        //Picasso.with(context).load(movie.getPoster()).fit().into(holder.poster);
        Glide.with(context)
                .load(movie.getPoster())
                .into(holder.poster);

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

