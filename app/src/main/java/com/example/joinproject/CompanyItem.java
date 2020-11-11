package com.example.joinproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CompanyItem extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_item);

        Button movecompanymain=(Button)findViewById(R.id.movecompanymain);
        movecompanymain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CompanyItem.this,CompanyMain.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
