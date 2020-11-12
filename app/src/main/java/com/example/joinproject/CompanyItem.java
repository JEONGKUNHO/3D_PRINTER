package com.example.joinproject;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CompanyItem extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_item);

        findViewById(R.id.toCompany).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
    }
}

