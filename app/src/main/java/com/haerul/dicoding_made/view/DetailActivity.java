package com.haerul.dicoding_made.view;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.haerul.dicoding_made.R;
import com.haerul.dicoding_made.data.Data;

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
        setToolbar();

        txtTitle = findViewById(R.id.title);
        txtYear = findViewById(R.id.year);
        txtDescription = findViewById(R.id.description);
        imgBanner = findViewById(R.id.banner);
        rating = findViewById(R.id.ratingBar);

        if (getIntent().getParcelableExtra(MainFragment.ITEM_EXTRA) != null) {
            setItem(getIntent().getParcelableExtra(MainFragment.ITEM_EXTRA));
        }
    }

    private void setToolbar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    void setItem(Data data) {
        txtTitle.setText(data.getTitle());
        txtYear.setText(String.valueOf(data.getYear()));
        txtDescription.setText(data.getDescription());
        imgBanner.setImageResource(data.getBanner());
        rating.setRating(data.getRating());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
