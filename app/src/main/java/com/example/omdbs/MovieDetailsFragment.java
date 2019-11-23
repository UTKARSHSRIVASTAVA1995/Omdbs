package com.example.omdbs;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.example.omdbs.models.SingleMovieDetail;

import java.util.logging.Logger;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MovieDetailsFragment extends AppCompatActivity {

    private TextView title, release, time, description;
    private ImageView poster;
    private MovieSearchList.Search movie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.fragment_movie_details);
        super.onCreate(savedInstanceState);
        initWidgets();
        Intent intent = getIntent();
        movie = (MovieSearchList.Search) intent.getExtras().getSerializable("test");
        Log.d("testttt", movie.getTitle());
        if(null!= movie.getImdbID()){
            getMovieDetails(movie.getImdbID());
        }

    }

    /**/
    public void initWidgets()
    {
        poster = findViewById(R.id.movie_poster);
        title = findViewById(R.id.movie_title);
        release = findViewById(R.id.movie_releaseDate);
        time = findViewById(R.id.movie_time);
        description = findViewById(R.id.movie_description);
    }

    /**/
    private  void setMovieDetails(final SingleMovieDetail singleMovieDetail){


        if(null == singleMovieDetail){
            Toast.makeText(MovieDetailsFragment.this, "Movie details not found", Toast.LENGTH_SHORT).show();
            finish();
        }

        /*Setting movie title*/
        if(null == singleMovieDetail.getTitle() || TextUtils.isEmpty(singleMovieDetail.getTitle())){

            title.setText("Title -");
        }else {
            title.setText("Title - "+singleMovieDetail.getTitle());
        }


        /*Setting movie Release*/
        if(null == singleMovieDetail.getReleased() || TextUtils.isEmpty(singleMovieDetail.getReleased())){

            release.setText("Release -");
        }else {
            release.setText("Release - "+singleMovieDetail.getReleased());
        }

        /*Setting movie poster*/
        if(null != singleMovieDetail.getPoster() && !TextUtils.isEmpty(singleMovieDetail.getPoster())){

            Glide.with(MovieDetailsFragment.this)
                    .load(singleMovieDetail.getPoster())
                    .into(poster);
        }

        /*Setting movie year*/
        if(null == singleMovieDetail.getYear() || TextUtils.isEmpty(singleMovieDetail.getYear())){

            time.setText("Year -");
        }else {
            time.setText("Year - "+singleMovieDetail.getYear());
        }


        /*Setting movie director name*/
        if(null == singleMovieDetail.getDirector() || TextUtils.isEmpty(singleMovieDetail.getDirector())){

            description.setText("Director -");
        }else {
            description.setText("Director - "+singleMovieDetail.getDirector());
        }


    }

    private void getMovieDetails(final String query) {

        ApiCall.Factory.getInstance().getMovie(ApiCall.API_KEY, query).enqueue(new Callback<SingleMovieDetail>() {

            @Override

            public void onResponse(Call<SingleMovieDetail> call, Response<SingleMovieDetail> response) {


                if (response.isSuccessful()) {

                    String apiResponse = response.body().toString();
                }

                if (response.body() instanceof SingleMovieDetail) {
                    SingleMovieDetail singleMovieDetail = response.body();
                    /*Log.d("apiResponsett", movieSearchList.toString());*/

                    if (singleMovieDetail.getResponse().equals("True")) {



                        setMovieDetails(singleMovieDetail);


                    } else {

                        Toast.makeText(MovieDetailsFragment.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<SingleMovieDetail> call, Throwable t) {
                Log.e("Failure", "Failure : " + t.getMessage());

            }
        });
    }
}


