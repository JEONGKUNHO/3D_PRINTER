package com.example.joinproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ReviewDetail extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_detail);
        getIncomingIntent();
    }

    private void getIncomingIntent() {
//괄호안에 name 은 Adpater에 있는 것과 동일하게 작성해야됨
        if (getIntent().hasExtra("review_title")) {
            String reviewTitle = getIntent().getStringExtra("review_title");
            String reviewDate = getIntent().getStringExtra("review_date");
            String reviewContent = getIntent().getStringExtra("review_content");
            String reviewImage = getIntent().getStringExtra("review_image");

            setIntent(reviewTitle, reviewContent,reviewDate, reviewImage);
        }
    }

    private void setIntent(String reviewTitle, String reviewContent, String reviewDate, String reviewImage) {
        //R.id.    은 Detail 안에 있는 값으로 해야됨
        TextView title = findViewById(R.id.review_title);
        TextView content = findViewById(R.id.review_content);
        TextView date = findViewById(R.id.review_date);
        ImageView image=findViewById(R.id.review_image);
        title.setText(reviewTitle);
        content.setText(reviewContent);
        date.setText(reviewDate);
        Glide.with(this)
                .asBitmap()
                .load(reviewImage)
                .into(image);
    }
}
