package com.haerul.dicoding_made.view;

import android.os.Bundle;

import com.haerul.dicoding_made.R;
import com.haerul.dicoding_made.base.BaseActivity;
import com.haerul.dicoding_made.data.model.Movie;
import com.haerul.dicoding_made.data.model.TvShow;
import com.haerul.dicoding_made.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity<ActivityDetailBinding, MainViewModel> {

    private ActivityDetailBinding mBinding;

    @Override
    public int getBindingVariable() {
        return com.haerul.dicoding_made.BR._all;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail;
    }

    @Override
    public MainViewModel getViewModel() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getViewDataBinding();
        setToolbar();
        if (getIntent().getSerializableExtra(MainFragment.ITEM_MOVIE) != null) {
            mBinding.setMovie((Movie.Result) getIntent().getSerializableExtra(MainFragment.ITEM_MOVIE));
        } else if (getIntent().getSerializableExtra(MainFragment.ITEM_TV) != null) {
            mBinding.setTv((TvShow.Result) getIntent().getSerializableExtra(MainFragment.ITEM_TV));
        }
    }

    private void setToolbar() {
        setSupportActionBar(mBinding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        supportFinishAfterTransition();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
