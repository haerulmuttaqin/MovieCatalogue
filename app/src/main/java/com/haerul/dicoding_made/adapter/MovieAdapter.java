package com.haerul.dicoding_made.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.haerul.dicoding_made.R;
import com.haerul.dicoding_made.data.Movie;

import java.util.List;

public class MovieAdapter extends BaseAdapter {
    
    private final Context context;
    private List<Movie> movies;
    
    public MovieAdapter(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Movie getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Movie movie = getItem(i);
        viewHolder.bind(movie);
        return view;
    }

    private class ViewHolder {
        private TextView txtTitle;
        private TextView txtYear;
        private ImageView imgBanner;
        private RatingBar rating;

        ViewHolder(View view) {
            txtTitle = view.findViewById(R.id.title);
            txtYear = view.findViewById(R.id.year);
            imgBanner = view.findViewById(R.id.banner);
            rating = view.findViewById(R.id.ratingBar);
        }

        void bind(Movie movie) {
            txtTitle.setText(movie.getTitle());
            txtYear.setText(String.valueOf(movie.getYear()));
            imgBanner.setImageResource(movie.getBanner());
            rating.setRating(movie.getRating());
        }
    }
}
