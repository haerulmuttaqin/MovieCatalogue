package com.haerul.dicoding_made.data.model;

import com.haerul.dicoding_made.utils.Utils;

import java.io.Serializable;
import java.util.List;

public class Movie {
    public int page;
    public int total_results;
    public int total_pages;
    public List<Result> results;

    public class Result implements Serializable {
        public int id;
        public String title;
        public String original_title;
        public String release_date;
        public List<Integer> genre_ids;
        public float popularity;
        public int vote_count;
        public boolean video;
        public boolean adult;
        public String backdrop_path;
        public String original_language;
        public float vote_average;
        public String overview;
        public String poster_path;

        public String getReleaseDate() {
            return release_date == null ? "" : Utils.dateFormatter(release_date);
        }
    }
}
