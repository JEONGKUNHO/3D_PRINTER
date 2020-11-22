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
        image.setImageResource(R.drawable.companyimg3);



        intro.setText(getIntent().getStringExtra("comp_intro"));

        if(getIntent().getStringExtra("comp_intro")==null){
            intro.setText("평내에 위치한 3D프린터 전문 회사입니다.");
        }
    }
}

