package com.example.joinproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CompanyAdapter extends RecyclerView.Adapter<CompanyAdapter.CompanyViewHolder> {

    private ArrayList<Company> arrayList;
    private Context context;

    public CompanyAdapter(ArrayList<Company> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CompanyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.company_item,parent,false);
        CompanyViewHolder holder=new CompanyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getComp_image())
                .into(holder.comp_image);
        holder.comp_name.setText(arrayList.get(position).getComp_name());
        holder.comp_star.setText(String.valueOf(arrayList.get(position).getComp_star()));
    }

    @Override
    public int getItemCount() {
        return (arrayList!=null ? arrayList.size() : 0);
    }

    public class CompanyViewHolder extends RecyclerView.ViewHolder {
        ImageView comp_image;
        TextView comp_name;
        TextView comp_star;


        public CompanyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.comp_image=itemView.findViewById(R.id.comp_image);
            this.comp_name=itemView.findViewById(R.id.comp_name);
            this.comp_star=itemView.findViewById(R.id.comp_star);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    {
                        Intent intent=new Intent(v.getContext(), CompanyMain.class);
                        v.getContext().startActivity(intent);
                    }
                }
            });
        }
    }
}
