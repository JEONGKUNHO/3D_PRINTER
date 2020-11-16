package com.example.joinproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CompanyMenu extends AppCompatActivity implements View.OnClickListener{
    private Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_menu);

        findViewById(R.id.intro).setOnClickListener(this);
        findViewById(R.id.gallery).setOnClickListener(this);
        findViewById(R.id.review).setOnClickListener(this);
        findViewById(R.id.chat).setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.intro:
                startActivity(new Intent(this,companyIntro.class));
                break;

            case R.id.gallery:
                startActivity(new Intent(this,companyGallery.class));
                break;

            case R.id.review:
                startActivity(new Intent(this,companyReview.class));
                break;


        }
    }
}

