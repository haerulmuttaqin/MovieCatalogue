package com.haerul.dicoding_made.di.module;

import com.haerul.dicoding_made.BuildConfig;
import com.haerul.dicoding_made.data.api.ApiInterface;
import com.haerul.dicoding_made.data.api.ConnectionServer;
import com.haerul.dicoding_made.utils.Constants;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    @Singleton
    ConnectionServer provideConnectionServer(ApiInterface apiInterface) {
        return new ConnectionServer(apiInterface);
    }

    @Provides
    @Singleton
    Interceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor localHttpLoggingInterceptor = new HttpLoggingInterceptor();
        localHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return localHttpLoggingInterceptor;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttp() {
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.MINUTES)
                .writeTimeout(30, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.MINUTES)
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request.Builder builder = chain.request().newBuilder();
                    builder.addHeader(Constants.CONTENT_TYPE, Constants.APP_JSON);
                    builder.method(original.method(), original.body());
                    return chain.proceed(builder.build());
                })
                .addNetworkInterceptor(provideLoggingInterceptor())
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofitClient() {
        return new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
                .client(provideOkHttp())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    ApiInterface provideApiInterface(Retrofit retrofit) {
        return retrofit.create(ApiInterface.class);
    }
}