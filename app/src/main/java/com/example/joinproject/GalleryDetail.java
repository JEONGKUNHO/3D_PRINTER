package com.example.joinproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class GalleryDetail extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_gallery_detail);
        getIncomingIntent();
    }

    private void getIncomingIntent() {
//괄호안에 name 은 Adpater에 있는 것과 동일하게 작성해야됨
        if (getIntent().hasExtra("gallery_title")) {
            String galleryTitle = getIntent().getStringExtra("gallery_title");
            String galleryContent = getIntent().getStringExtra("gallery_content");
            String galleryImage = getIntent().getStringExtra("gallery_image");

            setIntent(galleryTitle, galleryContent, galleryImage);
        }
    }

    private void setIntent(String galleryTitle, String galleryContent, String galleryImage) {
        //R.id.    은 Detail 안에 있는 값으로 해야됨
        TextView title = findViewById(R.id.gallery_title);
        TextView content = findViewById(R.id.gallery_content);
        ImageView image=findViewById(R.id.gallery_image);
        title.setText(galleryTitle);
        content.setText(galleryContent);
        Glide.with(this)
                .asBitmap()
                .load(galleryImage)
                .into(image);
    }
}
