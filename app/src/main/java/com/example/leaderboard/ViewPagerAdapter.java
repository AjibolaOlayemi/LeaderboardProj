package com.example.leaderboard;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> myFragments = new ArrayList<>();
    private final List<String > fragTitles =new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);

    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return myFragments.get(position);
    }

    @Override
    public int getCount() {
        return fragTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragTitles.get(position);
    }



    public void AddFragment (Fragment fragment, String title){
        myFragments.add(fragment);
        fragTitles.add(title);
    }
}
