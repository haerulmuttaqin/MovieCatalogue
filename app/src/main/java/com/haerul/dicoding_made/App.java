package com.haerul.dicoding_made;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;

import androidx.fragment.app.Fragment;

import com.facebook.stetho.Stetho;
import com.haerul.dicoding_made.di.component.AppComponent;
import com.haerul.dicoding_made.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasServiceInjector;
import dagger.android.support.HasSupportFragmentInjector;


public class App extends Application implements HasActivityInjector, HasSupportFragmentInjector, HasServiceInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Service> dispatchingAndroidInjectorService;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    AppComponent appComponent;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public void onCreate() {
        super.onCreate();
        createDaggerComponent().inject(this);
        Stetho.initializeWithDefaults(this);
    }

    public void clearComponent() {
        appComponent = null;
    }

    public AppComponent createDaggerComponent() {
        if (appComponent == null)
            appComponent = DaggerAppComponent.builder()
                    .application(this)
                    .build();
        return appComponent;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() {
        return dispatchingAndroidInjectorService;
    }

}