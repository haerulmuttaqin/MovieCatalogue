package com.haerul.dicoding_made.view;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;
import com.haerul.dicoding_made.R;
import com.haerul.dicoding_made.adapter.ViewPagerAdapter;
import com.haerul.dicoding_made.base.BaseActivity;
import com.haerul.dicoding_made.databinding.ActivityMainBinding;
import com.haerul.dicoding_made.utils.Constants;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    private ActivityMainBinding mBinding;

    @Override
    public int getBindingVariable() {
        return com.haerul.dicoding_made.BR._all;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getViewDataBinding();
        setSupportActionBar(mBinding.toolbar);
        setViewPagerTab();
    }

    public void setViewPagerTab() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(MainFragment.newInstance(Constants.TYPE_MOVIE), getResources().getString(R.string.movies));
        adapter.addFragment(MainFragment.newInstance(Constants.TYPE_TV_SHOW), getResources().getString(R.string.tv_shows));
        mBinding.viewPager.setAdapter(adapter);
        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager);
        mBinding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mBinding.tabLayout));
        mBinding.viewPager.setCurrentItem(0);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_change_settings) {
            startActivity(new Intent(Settings.ACTION_LOCALE_SETTINGS));
        }
        return super.onOptionsItemSelected(item);
    }
}
