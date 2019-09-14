package com.haerul.dicoding_made.di.component;

import com.haerul.dicoding_made.App;
import com.haerul.dicoding_made.di.builder.ActivityBuilder;
import com.haerul.dicoding_made.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(App app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App app);

        AppComponent build();
    }


}
