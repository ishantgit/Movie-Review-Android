package com.example.ishant.moviereview.responses;

import com.example.ishant.moviereview.models.MovieItem;
import com.example.ishant.moviereview.models.Tweet;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ishant on 19/11/15.
 */
public class TweetResponse {
    @SerializedName("tweets")
    private ArrayList<Tweet> tweetArrayList;

    public ArrayList<Tweet> getTweetArrayList() {
        return tweetArrayList;
    }

    public void setTweetArrayList(ArrayList<MovieItem> properties) {
        this.tweetArrayList = tweetArrayList;
    }
}
