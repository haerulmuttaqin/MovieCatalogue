package com.haerul.dicoding_made.di.builder;

import com.haerul.dicoding_made.view.DetailActivity;
import com.haerul.dicoding_made.view.MainActivity;
import com.haerul.dicoding_made.view.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector
    abstract MainFragment mainFragment();

    @ContributesAndroidInjector
    abstract DetailActivity detailActivity();
}
