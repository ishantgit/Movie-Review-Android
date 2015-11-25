package com.example.ishant.moviereview.responses;

import com.example.ishant.moviereview.models.MovieItem;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ishant on 18/11/15.
 */
public class MovieListResponse {
    @SerializedName("movies")
    private ArrayList<MovieItem> movies;

    public ArrayList<MovieItem> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<MovieItem> properties) {
        this.movies = movies;
    }
}
