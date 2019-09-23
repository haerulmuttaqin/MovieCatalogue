package com.haerul.dicoding_made.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.haerul.dicoding_made.R;
import com.haerul.dicoding_made.adapter.MovieAdapter;
import com.haerul.dicoding_made.adapter.TvShowAdapter;
import com.haerul.dicoding_made.base.BaseFragment;
import com.haerul.dicoding_made.data.api.ConnectionServer;
import com.haerul.dicoding_made.data.model.Movie;
import com.haerul.dicoding_made.data.model.TvShow;
import com.haerul.dicoding_made.databinding.FragmentMainBinding;
import com.haerul.dicoding_made.utils.Constants;

import javax.inject.Inject;

public class MainFragment extends BaseFragment<FragmentMainBinding, MainViewModel> implements MainViewModel.MainNavigator {

    @Inject
    ConnectionServer connectionServer;

    private FragmentMainBinding mBinding;
    private MainViewModel mViewModel;
    private static final String KEY_DATA = "com.haerul.dicoding_made.data";
    static final String ITEM_TV = "com.haerul.dicoding_made.item_tv";
    static final String ITEM_MOVIE = "com.haerul.dicoding_made.item_movie";

    @Override
    public int getBindingVariable() {
        return com.haerul.dicoding_made.BR._all;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return mViewModel;
    }

    static MainFragment newInstance(String typeOfList) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(KEY_DATA, typeOfList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.w("TAG", "on view created");
        mBinding = getViewDataBinding();
        mViewModel = ViewModelProviders.of(getBaseActivity(), new MainViewModel.ModelFactory(connectionServer)).get(MainViewModel.class);
        mViewModel.setNavigator(this);
        mBinding.setViewModel(mViewModel);

        if (getArguments() != null) {
            String typeOfList = getArguments().getString(KEY_DATA);
            if (typeOfList != null && typeOfList.equals(Constants.TYPE_MOVIE)) {
                mViewModel.getMovieResult();
                mBinding.swipeRefresh.setOnRefreshListener(() -> mViewModel.getMovieResult());
                mBinding.retry.setOnClickListener(v -> {
                    mBinding.emptyView.setVisibility(View.GONE);
                    mViewModel.getMovieResult();
                });
                mViewModel.movieData.observe(this, movies -> {
                    if (movies.results.size() > 0) {
                        mBinding.recyclerView.setAdapter(new MovieAdapter(movies.results, mViewModel));
                        mBinding.emptyView.setVisibility(View.GONE);
                    } else {
                        mBinding.emptyView.setVisibility(View.VISIBLE);
                    }
                });
            } else {
                mViewModel.getTvShowResult();
                mBinding.swipeRefresh.setOnRefreshListener(() -> mViewModel.getTvShowResult());
                mBinding.retry.setOnClickListener(v -> {
                    mBinding.emptyView.setVisibility(View.GONE);
                    mViewModel.getTvShowResult();
                });
                mViewModel.tvShowData.observe(this, tvShow -> {
                    if (tvShow.results.size() > 0) {
                        mBinding.recyclerView.setAdapter(new TvShowAdapter(tvShow.results, mViewModel));
                        mBinding.emptyView.setVisibility(View.GONE);
                    } else {
                        mBinding.emptyView.setVisibility(View.VISIBLE);
                    }
                });
            }
        }
    }

    @Override
    public void result(boolean isSuccess, String message) {
        if (!isSuccess) {
            mBinding.errorMessage.setText(message);
            mBinding.shimmerViewContainer.stopShimmer();
        }
    }

    @Override
    public void onMovieClick(Movie.Result obj) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(ITEM_MOVIE, obj);
        startActivity(intent);
    }

    @Override
    public void onTvShowClick(TvShow.Result obj) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(ITEM_TV, obj);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        mBinding.shimmerViewContainer.startShimmer();
    }

    @Override
    public void onStop() {
        super.onStop();
        mBinding.shimmerViewContainer.stopShimmer();
    }
}
