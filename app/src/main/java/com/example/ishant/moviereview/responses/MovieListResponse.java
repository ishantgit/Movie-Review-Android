package com.example.ishant.moviereview.responses;

import com.example.ishant.moviereview.models.Movie;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ishant on 18/11/15.
 */
public class MovieListResponse {
    @SerializedName("movies")
    private ArrayList<Movie> movies;

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> properties) {
        this.movies = movies;
    }
}
