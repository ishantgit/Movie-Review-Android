package com.example.ishant.moviereview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        inflater= LayoutInflater.from(context);
        this.context= context;
        this.list = list;
    }

    @Override
    public TweetItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.tweet_layout,parent,false);
        TweetItem tweetItem = new TweetItem(view);
        return tweetItem;
    }

    @Override
    public void onBindViewHolder(TweetItem holder, int position) {
        Tweet tweet = list.get(position);
        holder.tweetText.setText("Tweet : " +tweet.getText());
        holder.subjectivity.setText("Subjectivity :" + tweet.getSubjectivity());
        holder.polarity.setText("Polarity :" + tweet.getPolarity());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TweetItem extends RecyclerView.ViewHolder {


        private TextView tweetText;
        private TextView subjectivity;
        private TextView polarity;
        public TweetItem(View itemView) {

            super(itemView);
            tweetText = (TextView)itemView.findViewById(R.id.textView);
            subjectivity = (TextView)itemView.findViewById(R.id.subjectivity);
            polarity = (TextView)itemView.findViewById(R.id.polarity);
        }
    }
}
