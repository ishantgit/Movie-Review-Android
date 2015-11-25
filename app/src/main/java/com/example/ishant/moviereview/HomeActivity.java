package com.example.ishant.moviereview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.ishant.moviereview.models.MovieItem;
import com.example.ishant.moviereview.responses.MovieListResponse;
import com.example.ishant.moviereview.restApi.RestApiClient;
import com.example.ishant.moviereview.restApi.RestApiService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private List<MovieItem> movieItemList;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        recyclerView = (RecyclerView)findViewById(R.id.card_view);
        getMovieList();
    }



    private void getMovieList() {

        RestApiService apiInterface = RestApiClient.setUpService();

        Call<MovieListResponse> call = apiInterface.getDefaultMovieList();

        call.enqueue(new Callback<MovieListResponse>() {

            @Override
            public void onResponse(Response<MovieListResponse> response, Retrofit retrofit) {
                MovieListResponse movieListResponse = response.body();
                if (movieListResponse != null) {
                    if (movieListResponse.getMovies() != null) {
                        movieItemList = movieListResponse.getMovies();
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
    private void renderView(){
        MovieAdapter movieAdapter = new MovieAdapter(this,movieItemList);
        recyclerView.setAdapter(movieAdapter);
        movieAdapter.setOnItemClickListener(new MovieAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent();
                MovieItem movieItem = movieItemList.get(position);
                intent.putExtra("name", movieItem.getName());
                intent.setClass(getApplicationContext(), ShowTweetActivity.class);
                startActivity(intent);
            }
        });
    }
}
