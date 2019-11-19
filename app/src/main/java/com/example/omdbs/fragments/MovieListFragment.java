package com.example.omdbs.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.omdbs.ApiCall;
import com.example.omdbs.MovieRecyclerAdapter;
import com.example.omdbs.MovieSearchList;
import com.example.omdbs.R;
import com.example.omdbs.utilities.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListFragment extends Fragment {

    private RecyclerView rvList1, rvList2, rvList3, rvList4, rvList5, rvList6, rvList7, rvList8, rvList9, rvList10, rvList11, rvList12, rvList13, rvList14, rvList15, rvList16, rvList17, rvList18, rvList19, rvList20;
    private TextView title1, title2, title3, title4, title5, title6, title7, title8, title9, title10;
    private MovieRecyclerAdapter movieRecyclerAdapter1, movieRecyclerAdapter2, movieRecyclerAdapter3, movieRecyclerAdapter4, movieRecyclerAdapter5, movieRecyclerAdapter6, movieRecyclerAdapter7, movieRecyclerAdapter8, movieRecyclerAdapter9, movieRecyclerAdapter10, movieRecyclerAdapter11, movieRecyclerAdapter12, movieRecyclerAdapter13, movieRecyclerAdapter14, movieRecyclerAdapter15, movieRecyclerAdapter16, movieRecyclerAdapter17, movieRecyclerAdapter18, movieRecyclerAdapter19, movieRecyclerAdapter20;

    private List<MovieSearchList.Search> movies1 = new ArrayList<>();
    private List<MovieSearchList.Search> movies2 = new ArrayList<>();
    private List<MovieSearchList.Search> movies3 = new ArrayList<>();
    private List<MovieSearchList.Search> movies4 = new ArrayList<>();
    private List<MovieSearchList.Search> movies5 = new ArrayList<>();
    private List<MovieSearchList.Search> movies6 = new ArrayList<>();
    private List<MovieSearchList.Search> movies7 = new ArrayList<>();
    private List<MovieSearchList.Search> movies8 = new ArrayList<>();
    private List<MovieSearchList.Search> movies9 = new ArrayList<>();
    private List<MovieSearchList.Search> movies10 = new ArrayList<>();
    private List<MovieSearchList.Search> movies11 = new ArrayList<>();
    private List<MovieSearchList.Search> movies12 = new ArrayList<>();
    private List<MovieSearchList.Search> movies13 = new ArrayList<>();
    private List<MovieSearchList.Search> movies14 = new ArrayList<>();
    private List<MovieSearchList.Search> movies15 = new ArrayList<>();
    private List<MovieSearchList.Search> movies16 = new ArrayList<>();
    private List<MovieSearchList.Search> movies17 = new ArrayList<>();
    private List<MovieSearchList.Search> movies18 = new ArrayList<>();
    private List<MovieSearchList.Search> movies19 = new ArrayList<>();
    private List<MovieSearchList.Search> movies20 = new ArrayList<>();
    private Integer movieApiCount = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

    }

    private void initViews(View view) {

        rvList1 = view.findViewById(R.id.rvList1);
        rvList2 = view.findViewById(R.id.rvList2);
        rvList3 = view.findViewById(R.id.rvList3);
        rvList4 = view.findViewById(R.id.rvList4);
        rvList5 = view.findViewById(R.id.rvList5);
        rvList6 = view.findViewById(R.id.rvList6);
        rvList7 = view.findViewById(R.id.rvList7);
        rvList8 = view.findViewById(R.id.rvList8);
        rvList9 = view.findViewById(R.id.rvList9);
        rvList10 = view.findViewById(R.id.rvList10);
        rvList11 = view.findViewById(R.id.rvList11);
        rvList12 = view.findViewById(R.id.rvList12);
        rvList13 = view.findViewById(R.id.rvList13);
        rvList14 = view.findViewById(R.id.rvList14);
        rvList15 = view.findViewById(R.id.rvList15);
        rvList16 = view.findViewById(R.id.rvList16);
        rvList17 = view.findViewById(R.id.rvList17);
        rvList18 = view.findViewById(R.id.rvList18);
        rvList19 = view.findViewById(R.id.rvList19);
        rvList20 = view.findViewById(R.id.rvList20);

        title1 = view.findViewById(R.id.title1);
        title2 = view.findViewById(R.id.title2);
        title3 = view.findViewById(R.id.title3);
        title4 = view.findViewById(R.id.title4);
        title5 = view.findViewById(R.id.title5);
        title6 = view.findViewById(R.id.title6);
        title7 = view.findViewById(R.id.title7);
        title8 = view.findViewById(R.id.title8);
        title9 = view.findViewById(R.id.title9);
        title10 = view.findViewById(R.id.title10);

        getMovieList(1, "game of thrones");
        getMovieList(2, "race");
        getMovieList(3, "romantic");
        getMovieList(4, "housefull");
        getMovieList(5, "batman");
        getMovieList(6, "superman");
        getMovieList(7, "aquaman");
        getMovieList(8, "deadpool");
        getMovieList(9, "king");
        getMovieList(10, "fast and furious");
        getMovieList(11, "Harry Potter");
        getMovieList(12, "twilight");
        getMovieList(13, "mission impossible");
        getMovieList(14, "Die Hard");
        getMovieList(15, "Saw");
        getMovieList(16, "Star Wars");
        getMovieList(17, "Grudge");
        getMovieList(18, "Jurassic Park");
        getMovieList(19, "Indiana Jones");
        getMovieList(20, "Ice Age");
    }


    private void getMovieList(final int movieApiCount, final String query) {

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

                        int count = movieApiCount;

                        if (count == 1) {
                            setMovie1(movieSearchList.getSearch());
                        } else if (count == 2) {
                            setMovie2(movieSearchList.getSearch());
                        } else if (count == 3) {
                            setMovie3(movieSearchList.getSearch());
                        } else if (count == 4) {
                            setMovie4(movieSearchList.getSearch());
                        } else if (count == 5) {
                            setMovie5(movieSearchList.getSearch());
                        } else if (count == 6) {
                            setMovie6(movieSearchList.getSearch());
                        } else if (count == 7) {
                            setMovie7(movieSearchList.getSearch());
                        } else if (count == 8) {
                            setMovie8(movieSearchList.getSearch());
                        } else if (count == 9) {
                            setMovie9(movieSearchList.getSearch());
                        } else if (count == 10) {
                            setMovie10(movieSearchList.getSearch());
                        } else if (count == 11) {
                            setMovie11(movieSearchList.getSearch());
                        } else if (count == 12) {
                            setMovie12(movieSearchList.getSearch());
                        } else if (count == 13) {
                            setMovie13(movieSearchList.getSearch());
                        } else if (count == 14) {
                            setMovie14(movieSearchList.getSearch());
                        } else if (count == 15) {
                            setMovie15(movieSearchList.getSearch());
                        } else if (count == 16) {
                            setMovie16(movieSearchList.getSearch());
                        } else if (count == 17) {
                            setMovie17(movieSearchList.getSearch());
                        } else if (count == 18) {
                            setMovie18(movieSearchList.getSearch());
                        } else if (count == 19) {
                            setMovie19(movieSearchList.getSearch());
                        } else if (count == 20) {
                            setMovie20(movieSearchList.getSearch());
                        }

                    } else {

                        Toast.makeText(getActivity(), "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieSearchList> call, Throwable t) {
                Log.e("Failure", "Failure : " + t.getMessage());

            }
        });

    }

    private void setMovie1(List<MovieSearchList.Search> movieSearchList) {

        movies1.clear();
        movies1 = movieSearchList;
        final LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList1.setLayoutManager(linearLayoutManager1);
        rvList1.addItemDecoration(new SpacesItemDecoration(1));
        movieRecyclerAdapter1 = new MovieRecyclerAdapter(getActivity(), movies1);
        rvList1.setAdapter(movieRecyclerAdapter1);
        movieRecyclerAdapter1.notifyDataSetChanged();
    }


    private void setMovie2(List<MovieSearchList.Search> movieSearchList) {

        movies2.clear();
        movies2 = movieSearchList;
        final LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList2.setLayoutManager(linearLayoutManager2);
        movieRecyclerAdapter2 = new MovieRecyclerAdapter(getActivity(), movies2);
        rvList2.setAdapter(movieRecyclerAdapter2);
        movieRecyclerAdapter2.notifyDataSetChanged();


    }


    private void setMovie3(List<MovieSearchList.Search> movieSearchList) {

        movies3.clear();
        movies3 = movieSearchList;
        final LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList3.setLayoutManager(linearLayoutManager3);
        movieRecyclerAdapter3 = new MovieRecyclerAdapter(getActivity(), movies3);
        rvList3.setAdapter(movieRecyclerAdapter3);
        movieRecyclerAdapter3.notifyDataSetChanged();

    }


    private void setMovie4(List<MovieSearchList.Search> movieSearchList) {

        movies4.clear();
        movies4 = movieSearchList;
        final LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList4.setLayoutManager(linearLayoutManager4);
        movieRecyclerAdapter4 = new MovieRecyclerAdapter(getActivity(), movies4);
        rvList4.setAdapter(movieRecyclerAdapter4);
        movieRecyclerAdapter4.notifyDataSetChanged();

    }


    private void setMovie5(List<MovieSearchList.Search> movieSearchList) {

        movies5.clear();
        movies5 = movieSearchList;
        final LinearLayoutManager linearLayoutManager5 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList5.setLayoutManager(linearLayoutManager5);
        movieRecyclerAdapter5 = new MovieRecyclerAdapter(getActivity(), movies5);
        rvList5.setAdapter(movieRecyclerAdapter5);
        movieRecyclerAdapter5.notifyDataSetChanged();
        title5.setText("Deadpool Movies (" + (movies5.size()) + ")");
    }

    private void setMovie6(List<MovieSearchList.Search> movieSearchList) {

        movies6.clear();
        movies6 = movieSearchList;
        final LinearLayoutManager linearLayoutManager6 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList6.setLayoutManager(linearLayoutManager6);
        movieRecyclerAdapter6 = new MovieRecyclerAdapter(getActivity(), movies6);
        rvList6.setAdapter(movieRecyclerAdapter6);
        movieRecyclerAdapter6.notifyDataSetChanged();

    }

    private void setMovie7(List<MovieSearchList.Search> movieSearchList) {

        movies7.clear();
        movies7 = movieSearchList;
        final LinearLayoutManager linearLayoutManager7 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList7.setLayoutManager(linearLayoutManager7);
        movieRecyclerAdapter7 = new MovieRecyclerAdapter(getActivity(), movies7);
        rvList7.setAdapter(movieRecyclerAdapter7);
        movieRecyclerAdapter7.notifyDataSetChanged();

    }

    private void setMovie8(List<MovieSearchList.Search> movieSearchList) {

        movies8.clear();
        movies8 = movieSearchList;
        final LinearLayoutManager linearLayoutManager8 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList8.setLayoutManager(linearLayoutManager8);
        movieRecyclerAdapter8 = new MovieRecyclerAdapter(getActivity(), movies8);
        rvList8.setAdapter(movieRecyclerAdapter8);
        movieRecyclerAdapter8.notifyDataSetChanged();

    }

    private void setMovie9(List<MovieSearchList.Search> movieSearchList) {

        movies9.clear();
        movies9 = movieSearchList;
        final LinearLayoutManager linearLayoutManager9 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList9.setLayoutManager(linearLayoutManager9);
        movieRecyclerAdapter9 = new MovieRecyclerAdapter(getActivity(), movies9);
        rvList9.setAdapter(movieRecyclerAdapter9);
        movieRecyclerAdapter9.notifyDataSetChanged();

    }

    private void setMovie10(List<MovieSearchList.Search> movieSearchList) {

        movies10.clear();
        movies10 = movieSearchList;
        final LinearLayoutManager linearLayoutManager10 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList10.setLayoutManager(linearLayoutManager10);
        movieRecyclerAdapter10 = new MovieRecyclerAdapter(getActivity(), movies10);
        rvList10.setAdapter(movieRecyclerAdapter10);
        movieRecyclerAdapter10.notifyDataSetChanged();
    }

    private void setMovie11(List<MovieSearchList.Search> movieSearchList) {

        movies11.clear();
        movies11 = movieSearchList;
        final LinearLayoutManager linearLayoutManager11 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList11.setLayoutManager(linearLayoutManager11);
        movieRecyclerAdapter11 = new MovieRecyclerAdapter(getActivity(), movies11);
        rvList11.setAdapter(movieRecyclerAdapter11);
        movieRecyclerAdapter11.notifyDataSetChanged();
    }

    private void setMovie12(List<MovieSearchList.Search> movieSearchList) {

        movies12.clear();
        movies12 = movieSearchList;
        final LinearLayoutManager linearLayoutManager12 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList12.setLayoutManager(linearLayoutManager12);
        movieRecyclerAdapter12 = new MovieRecyclerAdapter(getActivity(), movies12);
        rvList12.setAdapter(movieRecyclerAdapter12);
        movieRecyclerAdapter12.notifyDataSetChanged();

    }

    private void setMovie13(List<MovieSearchList.Search> movieSearchList) {

        movies13.clear();
        movies13 = movieSearchList;
        final LinearLayoutManager linearLayoutManager13 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList13.setLayoutManager(linearLayoutManager13);
        movieRecyclerAdapter13 = new MovieRecyclerAdapter(getActivity(), movies13);
        rvList13.setAdapter(movieRecyclerAdapter13);
        movieRecyclerAdapter13.notifyDataSetChanged();

    }

    private void setMovie14(List<MovieSearchList.Search> movieSearchList) {

        movies14.clear();
        movies14 = movieSearchList;
        final LinearLayoutManager linearLayoutManager14 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList14.setLayoutManager(linearLayoutManager14);
        movieRecyclerAdapter14 = new MovieRecyclerAdapter(getActivity(), movies14);
        rvList14.setAdapter(movieRecyclerAdapter14);
        movieRecyclerAdapter14.notifyDataSetChanged();

    }

    private void setMovie15(List<MovieSearchList.Search> movieSearchList) {

        movies15.clear();
        movies15 = movieSearchList;
        final LinearLayoutManager linearLayoutManager15 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList15.setLayoutManager(linearLayoutManager15);
        movieRecyclerAdapter15 = new MovieRecyclerAdapter(getActivity(), movies15);
        rvList15.setAdapter(movieRecyclerAdapter15);
        movieRecyclerAdapter15.notifyDataSetChanged();

    }

    private void setMovie16(List<MovieSearchList.Search> movieSearchList) {

        movies16.clear();
        movies16 = movieSearchList;
        final LinearLayoutManager linearLayoutManager16 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList16.setLayoutManager(linearLayoutManager16);
        movieRecyclerAdapter16 = new MovieRecyclerAdapter(getActivity(), movies16);
        rvList16.setAdapter(movieRecyclerAdapter16);
        movieRecyclerAdapter16.notifyDataSetChanged();

    }

    private void setMovie17(List<MovieSearchList.Search> movieSearchList) {

        movies17.clear();
        movies17 = movieSearchList;
        final LinearLayoutManager linearLayoutManager17 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList17.setLayoutManager(linearLayoutManager17);
        movieRecyclerAdapter17 = new MovieRecyclerAdapter(getActivity(), movies17);
        rvList17.setAdapter(movieRecyclerAdapter17);
        movieRecyclerAdapter17.notifyDataSetChanged();

    }

    private void setMovie18(List<MovieSearchList.Search> movieSearchList) {

        movies18.clear();
        movies18 = movieSearchList;
        final LinearLayoutManager linearLayoutManager18 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList18.setLayoutManager(linearLayoutManager18);
        movieRecyclerAdapter18 = new MovieRecyclerAdapter(getActivity(), movies18);
        rvList18.setAdapter(movieRecyclerAdapter18);
        movieRecyclerAdapter18.notifyDataSetChanged();


    }

    private void setMovie19(List<MovieSearchList.Search> movieSearchList) {

        movies19.clear();
        movies19 = movieSearchList;
        final LinearLayoutManager linearLayoutManager19 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList19.setLayoutManager(linearLayoutManager19);
        movieRecyclerAdapter19 = new MovieRecyclerAdapter(getActivity(), movies19);
        rvList19.setAdapter(movieRecyclerAdapter19);
        movieRecyclerAdapter19.notifyDataSetChanged();

    }

    private void setMovie20(List<MovieSearchList.Search> movieSearchList) {

        movies20.clear();
        movies20 = movieSearchList;
        final LinearLayoutManager linearLayoutManager20 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        rvList20.setLayoutManager(linearLayoutManager20);
        movieRecyclerAdapter20 = new MovieRecyclerAdapter(getActivity(), movies20);
        rvList20.setAdapter(movieRecyclerAdapter20);
        movieRecyclerAdapter20.notifyDataSetChanged();
    }
}