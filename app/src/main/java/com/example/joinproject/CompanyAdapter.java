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
    public void onBindViewHolder(@NonNull CompanyViewHolder holder, final int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getComp_image())
                .into(holder.comp_image);
        holder.comp_name.setText(arrayList.get(position).getComp_name());
        holder.comp_star.setText(String.valueOf(arrayList.get(position).getComp_star()));
        holder.comp_bossId.setText(arrayList.get(position).getComp_bossId());
        holder.comp_intro.setText(arrayList.get(position).getComp_intro());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(arrayList.get(position).getComp_num()==1) {
                    Intent intent = new Intent(v.getContext(), CompanyMenu.class);
                    intent.putExtra("comp_bossId", arrayList.get(position).getComp_bossId());
                    intent.putExtra("comp_name", arrayList.get(position).getComp_name());
                    intent.putExtra("comp_intro", arrayList.get(position).getComp_intro());
                    intent.putExtra("comp_image", arrayList.get(position).getComp_image());
                    v.getContext().startActivity(intent);
                }
                else if(arrayList.get(position).getComp_num()==2) {
                    Intent intent = new Intent(v.getContext(), CompanyMenu2.class);
                    intent.putExtra("comp_bossId", arrayList.get(position).getComp_bossId());
                    intent.putExtra("comp_name", arrayList.get(position).getComp_name());
                    intent.putExtra("comp_intro", arrayList.get(position).getComp_intro());
                    intent.putExtra("comp_image", arrayList.get(position).getComp_image());
                    v.getContext().startActivity(intent);
                }
                else if(arrayList.get(position).getComp_num()==3) {
                    Intent intent = new Intent(v.getContext(), CompanyMenu3.class);
                    intent.putExtra("comp_bossId", arrayList.get(position).getComp_bossId());
                    intent.putExtra("comp_name", arrayList.get(position).getComp_name());
                    intent.putExtra("comp_intro", arrayList.get(position).getComp_intro());
                    intent.putExtra("comp_image", arrayList.get(position).getComp_image());
                    v.getContext().startActivity(intent);
                }
                else if(arrayList.get(position).getComp_num()==4) {
                    Intent intent = new Intent(v.getContext(), CompanyMenu4.class);
                    intent.putExtra("comp_bossId", arrayList.get(position).getComp_bossId());
                    intent.putExtra("comp_name", arrayList.get(position).getComp_name());
                    intent.putExtra("comp_intro", arrayList.get(position).getComp_intro());
                    intent.putExtra("comp_image", arrayList.get(position).getComp_image());
                    v.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (arrayList!=null ? arrayList.size() : 0);
    }

    public class CompanyViewHolder extends RecyclerView.ViewHolder {
        ImageView comp_image;
        TextView comp_name;
        TextView comp_star;
        TextView comp_bossId;
        TextView comp_intro;
        LinearLayout linearLayout;
        public CompanyViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.comp_image=itemView.findViewById(R.id.comp_image);
            this.comp_name=itemView.findViewById(R.id.comp_name);
            this.comp_star=itemView.findViewById(R.id.comp_star);
            this.comp_bossId=itemView.findViewById(R.id.comp_bossid);
            this.comp_intro=itemView.findViewById(R.id.comp_intro);
            this.linearLayout=itemView.findViewById(R.id.toCompany);

        }
    }
}