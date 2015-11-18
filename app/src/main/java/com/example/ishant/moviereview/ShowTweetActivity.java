package com.example.ishant.moviereview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.ishant.moviereview.models.Tweet;
import com.example.ishant.moviereview.responses.TweetResponse;
import com.example.ishant.moviereview.restApi.RestApiClient;
import com.example.ishant.moviereview.restApi.RestApiService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class ShowTweetActivity extends AppCompatActivity {

    private List<Tweet> tweetList;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tweet_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView)findViewById(R.id.card_view);
        int id =1;
        getTweetList(id);
    }

    private void getTweetList(int id) {
        RestApiService apiInterface = RestApiClient.setUpService();

        Call<TweetResponse> call = apiInterface.getTweetList(id);

        call.enqueue(new Callback<TweetResponse>() {

            @Override
            public void onResponse(Response<TweetResponse> response, Retrofit retrofit) {
                TweetResponse tweetResponse = response.body();
                if (tweetResponse != null) {
                    if (tweetResponse.getTweetArrayList() != null) {
                        tweetList = tweetResponse.getTweetArrayList();
                        renderView();
                    } else {
                        //this case handles server error
                    }
                } else {
                    //this case handles all errors for status codes: 404, 500, 401, 422 etc
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // Log error here since request failed i.e. network connection lost
                renderView();
            }
        });
    }

    private void renderView() {
        TweetAdapter tweetAdapter= new TweetAdapter(this,tweetList);
        recyclerView.setAdapter(tweetAdapter);
    }

}
