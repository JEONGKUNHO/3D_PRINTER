package com.example.joinproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;

public class BoardDetail extends AppCompatActivity {

    private FirebaseAuth mauth=FirebaseAuth.getInstance();

    Button delete;
    Button modify;
    Button complete;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.board_detail);
        getIncomingIntent();
        delete=findViewById(R.id.delete);
        modify=findViewById(R.id.modify);
        complete=findViewById(R.id.complete);
        if(mauth.getUid().equals(getIntent().getStringExtra("board_writer"))){
            delete.setVisibility(View.VISIBLE);
            modify.setVisibility(View.VISIBLE);
            complete.setVisibility(View.VISIBLE);
        }
    }

    private void getIncomingIntent() {
//괄호안에 name 은 Adpater에 있는 것과 동일하게 작성해야됨
        if (getIntent().hasExtra("board_title")) {
            String boardTitle = getIntent().getStringExtra("board_title");
            String boardDate = getIntent().getStringExtra("board_date");
            String boardContent = getIntent().getStringExtra("board_content");
            String boardImage = getIntent().getStringExtra("board_image");

            setIntent(boardTitle, boardContent,boardDate, boardImage);
        }
    }

    private void setIntent(String boardTitle, String boardContent, String boardDate, String boardImage) {
        //R.id.    은 Detail 안에 있는 값으로 해야됨
        TextView title = findViewById(R.id.board_title);
        TextView content = findViewById(R.id.board_content);
        TextView date = findViewById(R.id.board_date);
        ImageView image=findViewById(R.id.board_image);
        title.setText(boardTitle);
        content.setText(boardContent);
        date.setText(boardDate);
        Glide.with(this)
                .asBitmap()
                .load(boardImage)
                .into(image);
    }
}