package com.example.joinproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class GalleryDetail3 extends AppCompatActivity {
    private FirebaseAuth mauth=FirebaseAuth.getInstance();
    Button delete;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_gallery_detail);
        getIncomingIntent();

        delete=findViewById(R.id.delete);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference ref= FirebaseDatabase.getInstance().getReference();
                Query contentFind=ref.child("Gallery3").orderByChild("content").equalTo(getIntent().getStringExtra("gallery_content"));

                contentFind.addListenerForSingleValueEvent(new ValueEventListener(){

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot contentFind:snapshot.getChildren()){
                            contentFind.getRef().removeValue();
                        }
                        Toast.makeText(GalleryDetail3.this, "삭제가 완료되었습니다.", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(GalleryDetail3.this,MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                        startActivity(new Intent(GalleryDetail3.this,CompanyMenu3.class));
                        startActivity(new Intent(GalleryDetail3.this,companyGallery3.class));

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });


        if(mauth.getUid().equals(getIntent().getStringExtra("gallery_bossId"))){
            delete.setVisibility(View.VISIBLE);
        }
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
