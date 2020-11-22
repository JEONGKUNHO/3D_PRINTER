package com.example.joinproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CompanyMenu3 extends AppCompatActivity implements View.OnClickListener {
    private Button button1, button2, button3, button4;
    TextView companyName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_menu3);
        companyName = findViewById(R.id.companyName);
        companyName.setText("WhiteClouds");
        findViewById(R.id.intro).setOnClickListener(this);
        findViewById(R.id.gallery).setOnClickListener(this);
        findViewById(R.id.review).setOnClickListener(this);
        findViewById(R.id.chat).setOnClickListener(this);
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.intro:
                Intent intent = new Intent(this, companyIntro3.class);
                intent.putExtra("comp_intro", getIntent().getStringExtra("comp_intro"));
                intent.putExtra("comp_image", getIntent().getStringExtra("comp_image"));
                startActivity(intent);
                break;

            case R.id.gallery:

                Intent intent1 = new Intent(this, companyGallery3.class);
                intent1.putExtra("comp_intro", getIntent().getStringExtra("comp_intro"));
                intent1.putExtra("comp_image", getIntent().getStringExtra("comp_image"));
                intent1.putExtra("comp_name", getIntent().getStringExtra("comp_name"));
                intent1.putExtra("comp_bossId", getIntent().getStringExtra("comp_bossId"));
                startActivity(intent1);
                break;


            case R.id.review:
                Intent intent3 = new Intent(this, companyReview3.class);
                intent3.putExtra("comp_intro", getIntent().getStringExtra("comp_intro"));
                intent3.putExtra("comp_image", getIntent().getStringExtra("comp_image"));
                intent3.putExtra("comp_name", getIntent().getStringExtra("comp_name"));
                startActivity(intent3);
                break;

            case R.id.chat:

                startActivity(new Intent(this, MainActivity3.class));
                break;



        }


    }
}