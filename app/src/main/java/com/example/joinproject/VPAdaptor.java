package com.example.joinproject;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VPAdaptor extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext = new ArrayList<String>();


    public VPAdaptor(@NonNull FragmentManager fm) {
        super(fm);
        items=new ArrayList<Fragment>();
        items.add(new company1());
        items.add(new company2());
        items.add(new company3());
        items.add(new company4());

        itext.add("기업소개");
        itext.add("리뷰");
        itext.add("갤러리");
        itext.add("채팅");

    }
    public CharSequence getPageTitle(int position) {
        return itext.get(position);
    }

    public VPAdaptor(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
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

