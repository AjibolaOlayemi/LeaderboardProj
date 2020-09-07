package com.example.leaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FragmentSkillIqLeaders extends Fragment {

    private String title;
    private int page;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup parent,
                             Bundle savedInstanceState){

        return inflater.inflate(R.layout.fragment_skills_iq_leaders, parent, false);

    }

    public static FragmentSkillIqLeaders newInstance(int page, String title){
        FragmentSkillIqLeaders fragmentSecond = new FragmentSkillIqLeaders();
        Bundle args = new Bundle();
        args.putInt("0", page);
        args.putString("Learning Leaders", title);
        fragmentSecond.setArguments(args);
        return fragmentSecond;

    }
}
