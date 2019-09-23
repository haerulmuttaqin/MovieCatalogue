package com.haerul.dicoding_made.data.model;

import com.haerul.dicoding_made.utils.Utils;

import java.io.Serializable;
import java.util.List;

public class Movie {
    
    public List<Result> results;
    
    public class Result implements Serializable {
        public int id;
        public String title;
        public String original_title;
        public String release_date;
        public String backdrop_path;
        public float vote_average;
        public String overview;
        public String poster_path;

        public String getReleaseDate() {
            return release_date == null ? "" : Utils.dateFormatter(release_date);
        }
    }
}
