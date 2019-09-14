package com.haerul.dicoding_made;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.haerul.dicoding_made.data.Movie;

public class DetailActivity extends AppCompatActivity {

    private TextView txtTitle;
    private TextView txtYear;
    private TextView txtDescription;
    private ImageView imgBanner;
    private RatingBar rating;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtTitle = findViewById(R.id.title);
        txtYear = findViewById(R.id.year);
        txtDescription = findViewById(R.id.description);
        imgBanner = findViewById(R.id.banner);
        rating = findViewById(R.id.ratingBar);
        
        if (getIntent().getParcelableExtra(MainActivity.ITEM_EXTRA) != null) {
            setItem((Movie) getIntent().getParcelableExtra(MainActivity.ITEM_EXTRA));
        }
    }
    
    void setItem(Movie movie) {
        txtTitle.setText(movie.getTitle());
        txtYear.setText(String.valueOf(movie.getYear()));
        txtDescription.setText(movie.getDescription());
        imgBanner.setImageResource(movie.getBanner());
        rating.setRating(movie.getRating());
    }
}
