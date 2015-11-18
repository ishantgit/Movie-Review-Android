package com.example.ishant.moviereview.restApi;

import com.example.ishant.moviereview.constants.URIConstants;
import com.example.ishant.moviereview.responses.MovieListResponse;
import com.example.ishant.moviereview.responses.TweetResponse;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by arpitjain on 16/10/15.
 */
public interface RestApiService {

    @GET(URIConstants.MOVIE_LIST)
    Call<MovieListResponse> getDefaultMovieList();

    @GET(URIConstants.Tweet_List)
    Call<TweetResponse> getTweetList(@Query("movie") int id);
}