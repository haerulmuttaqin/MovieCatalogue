package com.haerul.dicoding_made.utils;

import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.haerul.dicoding_made.BuildConfig;

public final class BindingAdapters {
    @BindingAdapter("setVoteAvg")
    public static void setVoteAvg(RatingBar ratingBar, float value) {
        ratingBar.setRating(value);
    }

    @BindingAdapter("setPosterImage")
    public static void setVoteAvg(ImageView imageView, String path) {
        Glide.with(imageView.getContext()).load(BuildConfig.BASE_URL_IMAGE + path).into(imageView);
    }
}
