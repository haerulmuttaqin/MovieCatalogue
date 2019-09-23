package com.haerul.dicoding_made.data.model;

import com.haerul.dicoding_made.utils.Utils;

import java.io.Serializable;
import java.util.List;

public class TvShow {
    
    public List<Result> results;

    public class Result implements Serializable {
        public int id;
        public String name;
        public String original_name;
        public String first_air_date;
        public String backdrop_path;
        public float vote_average;
        public String overview;
        public String poster_path;

        public String getFirstAirDate() {
            return first_air_date == null ? "" : Utils.dateFormatter(first_air_date);
        }
    }
}
