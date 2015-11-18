package com.example.ishant.moviereview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ishant.moviereview.models.Tweet;

import java.util.List;

/**
 * Created by ishant on 19/11/15.
 */
public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.TweetItem> {

    private LayoutInflater inflater;
    private Context context;
    private List<Tweet> list;

    public TweetAdapter(Context context, List<Tweet> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public TweetItem onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(TweetItem holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TweetItem extends RecyclerView.ViewHolder {


        public TweetItem(View itemView) {
            super(itemView);
        }
    }
}
