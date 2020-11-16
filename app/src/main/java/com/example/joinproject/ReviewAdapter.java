package com.example.joinproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {

    private ArrayList<Review> arrayList;
    private Context context;

    public ReviewAdapter(ArrayList<Review> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.review_item,parent,false);
        ReviewViewHolder holder=new ReviewViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getImage())
                .into(holder.image);
        holder.title.setText(arrayList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return (arrayList!=null ? arrayList.size() : 0);
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        Button button;
        ImageView image;
        TextView title;


        public ReviewViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.image=itemView.findViewById(R.id.Review_image);
            this.title=itemView.findViewById(R.id.Review_title);
            this.button=itemView.findViewById(R.id.plusReview);
        }
    }
}