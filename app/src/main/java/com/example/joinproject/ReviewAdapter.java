package com.example.joinproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, final int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getImageUrl())
                .into(holder.image);
        holder.title.setText(arrayList.get(position).getTitle());
        holder.content.setText(arrayList.get(position).getContent());
        holder.date.setText(arrayList.get(position).getDate());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),ReviewDetail.class);
                intent.putExtra("review_title", arrayList.get(position).getTitle());
                intent.putExtra("review_content", arrayList.get(position).getContent());
                intent.putExtra("review_date", arrayList.get(position).getDate());
                intent.putExtra("review_image", arrayList.get(position).getImageUrl());
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return (arrayList!=null ? arrayList.size() : 0);
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        Button button;
        ImageView image;
        TextView title;
        TextView content;
        TextView date;
        LinearLayout linearLayout;
        public ReviewViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.image=itemView.findViewById(R.id.Review_image);
            this.title=itemView.findViewById(R.id.Review_title);
            this.content=itemView.findViewById(R.id.Review_content);
            this.date=itemView.findViewById(R.id.Review_date);
            this.button=itemView.findViewById(R.id.plusReview);
            this.linearLayout=itemView.findViewById(R.id.toReviewDetail);

        }
    }
}