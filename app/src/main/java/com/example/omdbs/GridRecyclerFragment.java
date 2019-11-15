package com.example.omdbs;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class GridRecyclerFragment extends Fragment {

    public RecyclerView movieGridRecycler1;
    public RecyclerView movieGridRecycler2;
    public RecyclerView movieGridRecycler3;

    public GridRecyclerAdapter gridRecyclerAdapter;
    public TextView message;
    private ArrayList<MovieSearchList.Search> movies;

    private OnLoadMoreListener mOnLoadMoreListener;

    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;

    public GridRecyclerFragment() {

    }

    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.mOnLoadMoreListener = mOnLoadMoreListener;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        movies = Start_Activity.movies;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_recycler_grid, container, false);
    }

    @Override

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        movieGridRecycler1 = view.findViewById(R.id.grid_recycler);
        movieGridRecycler2 = view.findViewById(R.id.grid_recycler1);
        movieGridRecycler3 = view.findViewById(R.id.grid_recycler2);


        message = view.findViewById(R.id.message);


        if (movies != null) {

            final LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

            movieGridRecycler1.setLayoutManager(linearLayoutManager1);
            gridRecyclerAdapter = new GridRecyclerAdapter(getContext(), movies);
            movieGridRecycler1.setAdapter(gridRecyclerAdapter);
            movieGridRecycler1.setItemAnimator(new DefaultItemAnimator());
            movieGridRecycler1.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(2), false));
            movieGridRecycler1.addOnScrollListener(new RecyclerView.OnScrollListener() {

                @Override

                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    totalItemCount = linearLayoutManager1.getItemCount();
                    lastVisibleItem = linearLayoutManager1.findLastVisibleItemPosition();

                    if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        if (mOnLoadMoreListener != null) {
                            mOnLoadMoreListener.onLoadMore();
                        }

                        isLoading = true;
                    }
                }
            });

            final LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

            movieGridRecycler2.setLayoutManager(linearLayoutManager2);
            gridRecyclerAdapter = new GridRecyclerAdapter(getContext(), movies);
            movieGridRecycler2.setAdapter(gridRecyclerAdapter);
            movieGridRecycler2.setItemAnimator(new DefaultItemAnimator());
            movieGridRecycler2.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(2), false));
            movieGridRecycler2.addOnScrollListener(new RecyclerView.OnScrollListener() {

                @Override

                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    totalItemCount = linearLayoutManager2.getItemCount();
                    lastVisibleItem = linearLayoutManager2.findLastVisibleItemPosition();

                    if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        if (mOnLoadMoreListener != null) {
                            mOnLoadMoreListener.onLoadMore();
                        }

                        isLoading = true;
                    }
                }
            });

            final LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
            movieGridRecycler3.setLayoutManager(linearLayoutManager3);
            gridRecyclerAdapter = new GridRecyclerAdapter(getContext(), movies);
            movieGridRecycler3.setAdapter(gridRecyclerAdapter);
            movieGridRecycler3.setItemAnimator(new DefaultItemAnimator());
            movieGridRecycler3.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(2), false));
            movieGridRecycler3.addOnScrollListener(new RecyclerView.OnScrollListener() {

                @Override

                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    totalItemCount = linearLayoutManager3.getItemCount();
                    lastVisibleItem = linearLayoutManager3.findLastVisibleItemPosition();

                    if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        if (mOnLoadMoreListener != null) {
                            mOnLoadMoreListener.onLoadMore();

                        }

                        isLoading = true;
                    }
                }
            });

            movieGridRecycler1.addOnItemTouchListener(new ItemTouchListener(movieGridRecycler1) {

                @Override
                public boolean onClick(RecyclerView parent, View view, int position, long id) {
                    BottomSheetDialogFragment bottomSheetDialogFragment = new MovieDetailsFragment();
                    Bundle bundle = new Bundle();
                    MovieSearchList.Search movie = movies.get(position);
                    bundle.putString("title", movie.getTitle());
                    bundle.putString("release", movie.getType());
                    bundle.putString("time", movie.getYear());
                    bundle.putString("description", movie.getYear());
                    bundle.putString("poster", movie.getPoster());
                    bottomSheetDialogFragment.setArguments(bundle);
                    bottomSheetDialogFragment.show(getActivity().getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
                    return true;

                }

                @Override
                public boolean onLongClick(RecyclerView parent, View view, int position, long id) {
                    return false;
                }

                @Override
                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

                }
            });

            movieGridRecycler2.addOnItemTouchListener(new ItemTouchListener(movieGridRecycler2) {

                @Override
                public boolean onClick(RecyclerView parent, View view, int position, long id) {
                    BottomSheetDialogFragment bottomSheetDialogFragment = new MovieDetailsFragment();
                    Bundle bundle = new Bundle();
                    MovieSearchList.Search movie = movies.get(position);
                    bundle.putString("title", movie.getTitle());
                    bundle.putString("release", movie.getType());
                    bundle.putString("time", movie.getYear());
                    bundle.putString("description", movie.getYear());
                    bundle.putString("poster", movie.getPoster());
                    bottomSheetDialogFragment.setArguments(bundle);
                    bottomSheetDialogFragment.show(getActivity().getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
                    return true;
                }

                @Override
                public boolean onLongClick(RecyclerView parent, View view, int position, long id) {
                    return false;
                }

                @Override
                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

                }
            });

            movieGridRecycler3.addOnItemTouchListener(new ItemTouchListener(movieGridRecycler3) {
                @Override
                public boolean onClick(RecyclerView parent, View view, int position, long id) {
                    BottomSheetDialogFragment bottomSheetDialogFragment = new MovieDetailsFragment();
                    Bundle bundle = new Bundle();
                    MovieSearchList.Search movie = movies.get(position);
                    bundle.putString("title", movie.getTitle());
                    bundle.putString("release", movie.getType());
                    bundle.putString("time", movie.getYear());
                    bundle.putString("description", movie.getYear());
                    bundle.putString("poster", movie.getPoster());
                    bottomSheetDialogFragment.setArguments(bundle);
                    bottomSheetDialogFragment.show(getActivity().getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
                    return true;
                }

                @Override
                public boolean onLongClick(RecyclerView parent, View view, int position, long id) {
                    return false;
                }

                @Override
                public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

                }
            });

        }

        movieGridRecycler1.setVisibility(View.GONE);
        movieGridRecycler2.setVisibility(View.GONE);
        movieGridRecycler3.setVisibility(View.GONE);
        message.setVisibility(View.VISIBLE);
    }

    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public void setLoaded() {
        isLoading = false;
    }

}
