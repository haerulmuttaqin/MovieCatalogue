package com.haerul.dicoding_made.data.api;

import com.haerul.dicoding_made.BuildConfig;
import com.haerul.dicoding_made.data.model.Movie;
import com.haerul.dicoding_made.data.model.TvShow;

import javax.inject.Inject;

import retrofit2.Call;

public class ConnectionServer {

    @Inject
    ApiInterface apiInterface;

    public ConnectionServer(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    public Call<Movie> getMovies() {
        return apiInterface.getMovies(BuildConfig.API_KEY, "en-US");
    }

    public Call<TvShow> getTvShows() {
        return apiInterface.getTvShows(BuildConfig.API_KEY, "en-US");
    }
}
