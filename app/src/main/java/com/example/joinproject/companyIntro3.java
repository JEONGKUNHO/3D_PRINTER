package com.example.joinproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class companyIntro3 extends AppCompatActivity{

    ImageView image;
    TextView intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_intro3);


        image=(ImageView)findViewById(R.id.intro_image);
        intro=findViewById(R.id.intro_intro);
        image.setImageResource(R.drawable.company3);



        intro.setText(getIntent().getStringExtra("comp_intro"));


    }
}
