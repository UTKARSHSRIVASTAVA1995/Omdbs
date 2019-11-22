package com.example.omdbs;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class MovieDetailsFragment extends AppCompatActivity {

    private TextView title, release, time, description;
    private ImageView poster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.fragment_movie_details);
        super.onCreate(savedInstanceState);
        poster = findViewById(R.id.movie_poster);
        title = findViewById(R.id.movie_title);
        release = findViewById(R.id.movie_releaseDate);
        time = findViewById(R.id.movie_time);
        description = findViewById(R.id.movie_description);
    }
}


