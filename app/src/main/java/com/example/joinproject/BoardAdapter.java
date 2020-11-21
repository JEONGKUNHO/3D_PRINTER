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

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {

    private ArrayList<Board> arrayList;
    private Context context;
    private int a;
    public BoardAdapter(ArrayList<Board> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.board_item,parent,false);
        BoardViewHolder holder=new BoardViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BoardViewHolder holder, final int position) {
        Glide.with(holder.itemView)
                .load(arrayList.get(position).getImageUrl())
                .into(holder.image);
        holder.title.setText(arrayList.get(position).getTitle());
        holder.content.setText(arrayList.get(position).getContent());
        holder.writer.setText(arrayList.get(position).getWriter());
        holder.date.setText(arrayList.get(position).getDate());
        a=arrayList.get(position).getComplete();

        if(a==1){
            holder.complete12();
        }
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),BoardDetail.class);
                intent.putExtra("board_title", arrayList.get(position).getTitle());
                intent.putExtra("board_content", arrayList.get(position).getContent());
                intent.putExtra("board_date", arrayList.get(position).getDate());
                intent.putExtra("board_writer", arrayList.get(position).getWriter());
                intent.putExtra("board_image", arrayList.get(position).getImageUrl());
                intent.putExtra("board_complete",arrayList.get(position).getComplete());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (arrayList!=null ? arrayList.size() : 0);
    }

    public class BoardViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        TextView content;
        TextView date;
        TextView writer;
        Button complete;
        Button delete;
        Button modify;
        LinearLayout linearLayout;
        TextView num;


        public BoardViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.Board_image);
            this.title = itemView.findViewById(R.id.Board_title);
            this.date = itemView.findViewById(R.id.Board_date);
            this.content = itemView.findViewById(R.id.Board_content);
            this.writer = itemView.findViewById(R.id.Board_writer);
            this.linearLayout = itemView.findViewById(R.id.toBoardDetail);
            this.delete = itemView.findViewById(R.id.delete);
            this.modify = itemView.findViewById(R.id.modify);
            this.complete = itemView.findViewById(R.id.complete);
            this.num = itemView.findViewById(R.id.Board_complete);
        }
        final public void complete12(){
            num.setVisibility(View.VISIBLE);
        }
    }
}