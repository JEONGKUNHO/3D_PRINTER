package com.example.joinproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

public class companyIntro extends AppCompatActivity{

    ImageView image;
    TextView intro;

    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_intro);

        image=(ImageView)findViewById(R.id.intro_image);
        intro=findViewById(R.id.intro_intro);
        image.setImageResource(R.drawable.company1);



        intro.setText(getIntent().getStringExtra("comp_intro"));
;
    }
}

