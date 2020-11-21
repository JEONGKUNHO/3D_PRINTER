package com.example.joinproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VPAdaptor extends FragmentPagerAdapter {
    private ArrayList<Fragment> items=new ArrayList<>();

    public VPAdaptor(@NonNull FragmentManager fm, int behavior){
        super(fm,behavior);
    }
    public void addItem(Fragment item){
        items.add(item);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }
}

