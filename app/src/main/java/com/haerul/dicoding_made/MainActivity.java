package com.haerul.dicoding_made;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.haerul.dicoding_made.adapter.MovieAdapter;
import com.haerul.dicoding_made.data.Movie;
import com.haerul.dicoding_made.data.MovieRepository;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String ITEM_EXTRA = "com.haerul.dicoding_made.item_movie";
    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        movies = MovieRepository.getInstance().getMovieData();
        
        ListView listView = findViewById(R.id.list_item);
        MovieAdapter adapter = new MovieAdapter(this, movies);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(ITEM_EXTRA, movies.get(position));
                startActivity(intent);
            }
        });
    }
}
