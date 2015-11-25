package com.example.ishant.moviereview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ishant.moviereview.models.MovieItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ishant on 07/11/15.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieItemClass> {


    private LayoutInflater inflater;
    private Context context;
    private List<MovieItem> list;
    private OnItemClickListener mItemclicklistener;

    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }
    public void setOnItemClickListener(final OnItemClickListener mItemclicklistener )
    {
        this.mItemclicklistener=mItemclicklistener;
    }
    public MovieAdapter(Context context,List<MovieItem> list){
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
        MovieItem movieItem = list.get(position);
        holder.name.setText(movieItem.getName());
        holder.description.setText(movieItem.getImdbRating());
        Picasso.with(context)
                .load(movieItem.getPoster())
                .into(holder.cinemaImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MovieItemClass extends RecyclerView.ViewHolder implements View.OnClickListener {


        private ImageView cinemaImage;
        private LinearLayout parentLinearLayout;
        private TextView name;
        private TextView description;
        private TextView isActive;

        public MovieItemClass(View itemView) {
            super(itemView);
            parentLinearLayout = (LinearLayout)itemView.findViewById(R.id.parent_linear_layout);
            cinemaImage = (ImageView) itemView.findViewById(R.id.cinema_chain_image);
            name =(TextView)itemView.findViewById(R.id.name);
            description =(TextView)itemView.findViewById(R.id.description);
            isActive = (TextView)itemView.findViewById(R.id.is_active);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            if(mItemclicklistener != null)
            {
                mItemclicklistener.onItemClick(v,getLayoutPosition());
            }
        }
    }
}
