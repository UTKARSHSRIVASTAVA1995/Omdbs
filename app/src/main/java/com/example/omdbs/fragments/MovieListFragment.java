package com.example.omdbs.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omdbs.ApiCall;
import com.example.omdbs.MovieRecyclerAdapter;
import com.example.omdbs.MovieSearchList;
import com.example.omdbs.R;
import com.example.omdbs.dashboard.DashboardActivity;
import com.example.omdbs.utilities.SpacesItemDecoration;
import com.ss.bottomnavigation.BottomNavigation;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListFragment extends Fragment {

    private RecyclerView rvList1, rvList2, rvList3, rvList4,rvList5;
    private TextView title1, title2, title3, title4, title5;
    private MovieRecyclerAdapter movieRecyclerAdapter1, movieRecyclerAdapter2,movieRecyclerAdapter3, movieRecyclerAdapter4
            ,movieRecyclerAdapter5;

    private List<MovieSearchList.Search> movies1 = new ArrayList<>();
    private List<MovieSearchList.Search> movies2= new ArrayList<>();
    private List<MovieSearchList.Search>  movies3= new ArrayList<>();
    private List<MovieSearchList.Search> movies4= new ArrayList<>();
    private List<MovieSearchList.Search>movies5= new ArrayList<>();
    private Integer movieApiCount = 1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

    }

    /*Inizialize Views*/
    private void initViews(View view){

        rvList1 =  view.findViewById(R.id.rvList1);
        rvList2 =  view.findViewById(R.id.rvList2);
        rvList3 =  view.findViewById(R.id.rvList3);
        rvList4 =  view.findViewById(R.id.rvList4);
        rvList5 =  view.findViewById(R.id.rvList5);


        title1 =  view.findViewById(R.id.title1);
        title2 =  view.findViewById(R.id.title2);
        title3 =  view.findViewById(R.id.title3);
        title4 =  view.findViewById(R.id.title4);
        title5 =  view.findViewById(R.id.title5);

        getMovieList(1,"batman");
        getMovieList(2,"superman");
        getMovieList(3,"king");
        getMovieList(4,"aquaman");
        getMovieList(5,"deadpool");
    }

    /*Getting movie data 1*/
    private void getMovieList(final int movieApiCount, final String query){

        ApiCall.Factory.getInstance().searchMovie("a4f7d196", query, "1").enqueue(new Callback<MovieSearchList>() {
            @Override
            public void onResponse(Call<MovieSearchList> call, Response<MovieSearchList> response) {


                if (response.isSuccessful()) {


                    Log.d("movieearchRequestUrl", String.valueOf(call.request()));
                    Log.d("MovieSearchResponsecode", String.valueOf(response.code()));

                    String apiResponse = response.body().toString();
                    Log.d("apiResponse", apiResponse);
                }
                if (response.body() instanceof MovieSearchList) {
                    MovieSearchList movieSearchList = response.body();
                    if (movieSearchList.getResponse().equals("True")) {
                        //setMovie1(movieSearchList.getSearch());
                        int count = movieApiCount;
                        if(count == 1){
                            setMovie1(movieSearchList.getSearch());
                        }else if(count == 2){
                            setMovie2(movieSearchList.getSearch());
                        }else if(count == 3){
                            setMovie3(movieSearchList.getSearch());
                        }else if(count == 4){
                            setMovie4(movieSearchList.getSearch());
                        }if(count == 5){
                            setMovie5(movieSearchList.getSearch());
                        }
                        // progressDialog.dismiss();

                    } else {
                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieSearchList> call, Throwable t) {
                Log.e("Failure", "Failure : " + t.getMessage());
                //  progressDialog.dismiss();

            }
        });
        //   }
    }

    /*setting movie list1*/
    private void setMovie1(List<MovieSearchList.Search> movieSearchList){
        movies1.clear();
        movies1 = movieSearchList;
        final LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList1.setLayoutManager(linearLayoutManager1);
        // rvList1.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(0), true));
        rvList1.addItemDecoration(new SpacesItemDecoration(1));
        movieRecyclerAdapter1 = new MovieRecyclerAdapter(getActivity(), movies1);
        rvList1.setAdapter(movieRecyclerAdapter1);
        movieRecyclerAdapter1.notifyDataSetChanged();
        title1.setText("Batman Movies ("+(movies1.size())+")");
    }


    /*setting movie list2*/
    private void setMovie2(List<MovieSearchList.Search> movieSearchList){
        movies2.clear();
        movies2 = movieSearchList;
        final LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList2.setLayoutManager(linearLayoutManager2);
        movieRecyclerAdapter2 = new MovieRecyclerAdapter(getActivity(), movies2);
        rvList2.setAdapter(movieRecyclerAdapter2);
        movieRecyclerAdapter2.notifyDataSetChanged();
        title2.setText("SuperMan Movies ("+(movies2.size())+")");

    }


    /*setting movie list3*/
    private void setMovie3(List<MovieSearchList.Search> movieSearchList){
        movies3.clear();
        movies3 = movieSearchList;
        final LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList3.setLayoutManager(linearLayoutManager3);
        movieRecyclerAdapter3 = new MovieRecyclerAdapter(getActivity(), movies3);
        rvList3.setAdapter(movieRecyclerAdapter3);
        movieRecyclerAdapter3.notifyDataSetChanged();
        title3.setText("King Movies ("+(movies3.size())+")");
    }

    /*setting movie list4*/
    private void setMovie4(List<MovieSearchList.Search> movieSearchList){
        movies4.clear();
        movies4 = movieSearchList;
        final LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList4.setLayoutManager(linearLayoutManager4);
        movieRecyclerAdapter4 = new MovieRecyclerAdapter(getActivity(), movies4);
        rvList4.setAdapter(movieRecyclerAdapter4);
        movieRecyclerAdapter4.notifyDataSetChanged();
        title4.setText("Aquaman Movies ("+(movies4.size())+")");
    }

    /*setting movie list5*/
    private void setMovie5(List<MovieSearchList.Search> movieSearchList){
        movies5.clear();
        movies5 = movieSearchList;
        final LinearLayoutManager linearLayoutManager5 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList5.setLayoutManager(linearLayoutManager5);
        movieRecyclerAdapter5 = new MovieRecyclerAdapter(getActivity(), movies5);
        rvList5.setAdapter(movieRecyclerAdapter5);
        movieRecyclerAdapter5.notifyDataSetChanged();
        title5.setText("Deadpool Movies ("+(movies5.size())+")");
    }
}