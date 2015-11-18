package com.example.ishant.moviereview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ishant.moviereview.models.Movie;

import java.util.List;

/**
 * Created by ishant on 07/11/15.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieItemClass> {


    private LayoutInflater inflater;
    private Context context;
    private List<Movie> list;

    public MovieAdapter(Context context,List<Movie> list){
        inflater= LayoutInflater.from(context);
        this.context= context;
        this.list = list;
    }
    @Override
    public MovieItemClass onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.movie_item_layout,parent,false);
        MovieItemClass movieItem = new MovieItemClass(view);
        return movieItem;
    }

    @Override
    public void onBindViewHolder(MovieItemClass holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MovieItemClass extends RecyclerView.ViewHolder {

        public MovieItemClass(View itemView) {
            super(itemView);
        }
    }
}
