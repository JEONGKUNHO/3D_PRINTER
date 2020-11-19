package com.example.joinproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class CompanyMain extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_main);

        ViewPager vp = findViewById(R.id.viewpager);
        VPAdaptor adaptor = new VPAdaptor(getSupportFragmentManager());
        vp.setAdapter(adaptor);

        TabLayout tab = findViewById(R.id.tab);
        tab.setupWithViewPager(vp);


    }

}