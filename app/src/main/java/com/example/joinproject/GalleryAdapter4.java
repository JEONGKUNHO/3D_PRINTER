package com.example.joinproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GalleryAdapter4 extends RecyclerView.Adapter<GalleryAdapter4.GalleryViewHolder> {

    private ArrayList<Gallery4> arrayList;
    private Context context;

    public GalleryAdapter4(ArrayList<Gallery4> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item4,parent,false);
        GalleryViewHolder holder=new GalleryViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, final int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getImage())
                .into(holder.image);
        holder.title.setText(arrayList.get(position).getTitle());
        holder.content.setText(arrayList.get(position).getContent());
        holder.company_name.setText(arrayList.get(position).getCompany_name());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),GalleryDetail.class);
                intent.putExtra("gallery_title", arrayList.get(position).getTitle());
                intent.putExtra("gallery_content", arrayList.get(position).getContent());
                intent.putExtra("gallery_image", arrayList.get(position).getImage());
                intent.putExtra("gallery_comp_name", arrayList.get(position).getCompany_name());
                v.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return (arrayList!=null ? arrayList.size() : 0);
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView content;
        TextView company_name;
        LinearLayout linearLayout;

        public GalleryViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.image=itemView.findViewById(R.id.Gallery_image);
            this.title=itemView.findViewById(R.id.Gallery_title);
            this.content=itemView.findViewById(R.id.Gallery_content);
            this.company_name=itemView.findViewById(R.id.Gallery_comp_name);
            this.linearLayout=itemView.findViewById(R.id.toGallery);
        }
    }
}