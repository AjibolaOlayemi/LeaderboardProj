package com.example.leaderboard;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.os.Build;
import android.os.Bundle;
import android.service.autofill.CharSequenceTransformation;


public class MainActivity extends AppCompatActivity {

    FragmentPagerAdapter adapterViewPager;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        vpPager.getCurrentItem();
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter{
        private static int NUM_ITEMS= 2;

        public MyPagerAdapter(FragmentManager fragmentManager){
            super (fragmentManager);
        }

        @Override
        public int getCount(){
            return NUM_ITEMS;
        }

        @NonNull
        @Override
        public Fragment getItem(int position){
            switch (position){
                case 0:
                    return FragmentLearningLeaders.newInstance(0,"Learning Leaders");
                case 1:
                    return FragmentSkillIqLeaders.newInstance(1, "Skill IQ Leaders");

                default:
                    return null;
            }
        }

    }



}