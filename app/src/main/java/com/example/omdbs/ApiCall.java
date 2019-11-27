package com.example.omdbs;

import com.example.omdbs.models.SingleMovieDetail;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiCall {
    String BASE_URL = "http://www.omdbapi.com/?";
    String API_KEY = "a4f7d196";

    @GET("/")
    Call<MovieSearchList> search(@Query("apikey") String apikey, @Query("t") String query, @Query("type") String type, @Query("page") int page);

    @Headers("Content-Type: application/json")

    @GET("/")
    Call<MovieSearchList> searchMovie(@Query("apikey") String apikey, @Query("s") String query, @Query("page") String page);

    @GET("/")
    Call<SingleMovieDetail> getMovie(@Query("apikey") String apikey, @Query("i") String omdbId);

    class Factory {

        public static ApiCall service;

        public static ApiCall getInstance() {
            if (service == null) {

                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient client = new OkHttpClient.Builder()
                        .addInterceptor(interceptor).build();


                Retrofit retrofit = new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .baseUrl(BASE_URL).build();
                service = retrofit.create(ApiCall.class);
                return service;
            } else {
                return service;
            }
        }
    }
}
