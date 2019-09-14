package com.haerul.dicoding_made.data.api;

import com.haerul.dicoding_made.data.model.Movie;
import com.haerul.dicoding_made.data.model.TvShow;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("movie")
    Call<Movie> getMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language);

    @GET("tv")
    Call<TvShow> getTvShows(
            @Query("api_key") String apiKey,
            @Query("language") String language);
}
