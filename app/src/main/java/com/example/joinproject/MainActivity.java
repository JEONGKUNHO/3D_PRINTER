package com.example.joinproject;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    page_1 fragment1;
    page_2 fragment2;
    page_3 fragment3;
    page_4 fragment4;
    page_5 fragment5;
    PagerAdapter adapter;
    ViewPager viewPager;
    OnBackPressedListener listener;
    private BottomNavigationView mBottomNV;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPager=findViewById(R.id.viewpager);
        fragment1=new page_1();
        fragment2=new page_2();
        fragment3=new page_3();
        fragment4=new page_4();
        fragment5=new page_5();

        adapter=new VPAdaptor(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ((VPAdaptor) adapter).addItem(fragment1);
        ((VPAdaptor) adapter).addItem(fragment2);
        ((VPAdaptor) adapter).addItem(fragment3);
        ((VPAdaptor) adapter).addItem(fragment4);
        ((VPAdaptor) adapter).addItem(fragment5);
        setContentView(R.layout.activity_main2);
        mBottomNV = findViewById(R.id.bottomNavi);
        mBottomNV.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() { //NavigationItemSelecte
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                BottomNavigate(menuItem.getItemId());


                return true;
            }
        });
        mBottomNV.setSelectedItemId(R.id.action_home);
    }
    private void BottomNavigate(int id) {  //BottomNavigation 페이지 변경
        String tag = String.valueOf(id);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Fragment currentFragment = fragmentManager.getPrimaryNavigationFragment();
        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment);
        }

        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment == null) {
            if (id == R.id.action_home) {
                fragment = new page_1();

            } else if (id == R.id.action_chat){

                fragment = new page_2();
            } else if (id == R.id.action_add){

                fragment = new page_3();
            } else if (id == R.id.action_list){

                fragment = new page_4();
            }
            else {
                fragment = new page_5();
            }

            fragmentTransaction.add(R.id.content_layout, fragment, tag);
        } else {
            fragmentTransaction.show(fragment);
        }

        fragmentTransaction.setPrimaryNavigationFragment(fragment);
        fragmentTransaction.setReorderingAllowed(true);
        fragmentTransaction.commitNow();


    }

    public void setOnBackPressedListener(OnBackPressedListener listener){
        this.listener=listener;
    }

    @Override
    public void onBackPressed(){
        if(listener!=null){
            listener.onBackPressed();
        }else{
            super.onBackPressed();
        }
    }

    public void setCurrentItem(){
        viewPager.setCurrentItem(1);
    }
}

