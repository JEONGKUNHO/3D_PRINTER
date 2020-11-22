package com.example.joinproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class companyIntro4 extends AppCompatActivity{

    ImageView image;
    TextView intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_intro4);


        image=(ImageView)findViewById(R.id.intro_image);
        intro=findViewById(R.id.intro_intro);
        image.setImageResource(R.drawable.companyimg4);



        intro.setText(getIntent().getStringExtra("comp_intro"));
        if(getIntent().getStringExtra("comp_intro")==null){
            intro.setText("'CLIP 기술'로 현재 3D 프린터의 원리인 레이어 바이 레이어 개념을 뒤바꾼 기술을 사용하여 기존보다 100배 빠르고 정교하며 층이 없습니다.");
        }

    }
}

