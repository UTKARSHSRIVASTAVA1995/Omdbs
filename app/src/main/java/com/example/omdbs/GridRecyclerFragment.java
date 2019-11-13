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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class GridRecyclerFragment extends Fragment {

    public RecyclerView movieGridRecycler;
    public GridRecyclerAdapter gridRecyclerAdapter;
    public TextView message;
    private ArrayList<MovieSearchList.Search> movies;
    private GridLayoutManager gridLayoutManager;
    private OnLoadMoreListener mOnLoadMoreListener;

    private boolean isLoading;
    private int visibleThreshold = 5;
    private int lastVisibleItem, totalItemCount;

    public GridRecyclerFragment() {
        // Required empty public constructor
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

        movieGridRecycler = (RecyclerView) view.findViewById(R.id.grid_recycler);
        message = (TextView) view.findViewById(R.id.message);
        if (movies != null) {
            gridLayoutManager = new GridLayoutManager(getContext(), 3);
            movieGridRecycler.setLayoutManager(gridLayoutManager);

            gridRecyclerAdapter = new GridRecyclerAdapter(getContext(), movies);
            movieGridRecycler.setAdapter(gridRecyclerAdapter);

            movieGridRecycler.setItemAnimator(new DefaultItemAnimator());
            movieGridRecycler.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(2), false));

            movieGridRecycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);

                    totalItemCount = gridLayoutManager.getItemCount();
                    lastVisibleItem = gridLayoutManager.findLastVisibleItemPosition();

                    if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        if (mOnLoadMoreListener != null) {
                            mOnLoadMoreListener.onLoadMore();
                        }
                        isLoading = true;
                    }
                }
            });

            movieGridRecycler.addOnItemTouchListener(new ItemTouchListener(movieGridRecycler) {

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
        movieGridRecycler.setVisibility(View.GONE);
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
