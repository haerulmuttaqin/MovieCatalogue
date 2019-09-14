package com.haerul.dicoding_made.data;

import android.content.Context;
import android.content.res.TypedArray;

import com.haerul.dicoding_made.R;

import java.util.ArrayList;
import java.util.List;

public class DataRepository {
    
    private static DataRepository dataRepository;
    private static String[] movieTitles;
    private static String[] movieDescriptions;
    private static TypedArray movieBanners;
    private static int[] movieYears;
    private static TypedArray movieRattings;
    private static String[] tvShowTitles;
    private static String[] tvShowDescriptions;
    private static TypedArray tvShowBanners;
    private static int[] tvShowYears;
    private static TypedArray tvShowRattings;

    private DataRepository() {}

    public static synchronized DataRepository getInstance(Context context) {
        if (dataRepository == null) {
            dataRepository = new DataRepository();
            /*PREPARING DATA*/
            movieTitles = context.getResources().getStringArray(R.array.movie_title);
            movieDescriptions = context.getResources().getStringArray(R.array.movie_description);
            movieBanners = context.getResources().obtainTypedArray(R.array.movie_banner);
            movieYears = context.getResources().getIntArray(R.array.movie_year);
            movieRattings = context.getResources().obtainTypedArray(R.array.movie_ratting);
            tvShowTitles = context.getResources().getStringArray(R.array.tv_shows_title);
            tvShowDescriptions = context.getResources().getStringArray(R.array.tv_shows_description);
            tvShowBanners = context.getResources().obtainTypedArray(R.array.tv_shows_banner);
            tvShowYears = context.getResources().getIntArray(R.array.tv_shows_year);
            tvShowRattings = context.getResources().obtainTypedArray(R.array.tv_shows_ratting);
        }
        return dataRepository;
    }

    public List<Data> getMovieData() {
        List<Data> data = new ArrayList<>();
        for (int i = 0; i < movieTitles.length; i++) {
            data.add(new Data(
                    movieTitles[i],
                    movieDescriptions[i],
                    movieBanners.getResourceId(i, 0),
                    movieYears[i],
                    movieRattings.getFloat(i, 0f)));
        }
        return data;
    }
    
    public List<Data> getTvShowData() {
        List<Data> data = new ArrayList<>();
        for (int i = 0; i < tvShowTitles.length; i++) {
            data.add(new Data(
                    tvShowTitles[i],
                    tvShowDescriptions[i],
                    tvShowBanners.getResourceId(i, 0),
                    tvShowYears[i],
                    tvShowRattings.getFloat(i, 0f)));
        }
        return data;
    }
    
}
