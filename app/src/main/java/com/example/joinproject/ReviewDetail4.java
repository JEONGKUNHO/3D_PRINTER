package com.example.joinproject;

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

public class ReviewDetail4 extends AppCompatActivity {

    private FirebaseAuth mauth=FirebaseAuth.getInstance();
    Button delete;
    Button modify;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_detail);
        getIncomingIntent();

        delete=findViewById(R.id.delete);
        modify=findViewById(R.id.modify);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference ref= FirebaseDatabase.getInstance().getReference();
                Query contentFind=ref.child("Review4").orderByChild("content").equalTo(getIntent().getStringExtra("review_content"));

                contentFind.addListenerForSingleValueEvent(new ValueEventListener(){

                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot contentFind:snapshot.getChildren()){
                            contentFind.getRef().removeValue();
                        }
                        Toast.makeText(ReviewDetail4.this, "삭제가 완료되었습니다.", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });


        if(mauth.getUid().equals(getIntent().getStringExtra("review_writer"))){
            delete.setVisibility(View.VISIBLE);
            modify.setVisibility(View.VISIBLE);
        }
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