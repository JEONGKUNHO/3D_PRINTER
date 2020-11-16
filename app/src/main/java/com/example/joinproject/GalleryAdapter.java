package com.example.joinproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    private ArrayList<Gallery> arrayList;
    private Context context;

    public GalleryAdapter(ArrayList<Gallery> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item,parent,false);
        GalleryViewHolder holder=new GalleryViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getImage())
                .into(holder.image);
        holder.title.setText(arrayList.get(position).getTitle());
        holder.content.setText(arrayList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return (arrayList!=null ? arrayList.size() : 0);
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView content;


        public GalleryViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.image=itemView.findViewById(R.id.Gallery_image);
            this.title=itemView.findViewById(R.id.Gallery_title);
            this.content=itemView.findViewById(R.id.Gallery_content);
        }
    }
}