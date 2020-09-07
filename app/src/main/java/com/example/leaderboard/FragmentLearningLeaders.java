package com.example.leaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class FragmentLearningLeaders extends Fragment {

    private String title;
    private int page;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup parent,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_learning_leaders, parent, false);
    }

    public static FragmentLearningLeaders newInstance(int page, String title){
        FragmentLearningLeaders fragmentFirst = new FragmentLearningLeaders();
        Bundle args = new Bundle();
        args.putInt("0", page);
        args.putString("Learning Leaders", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;

    }

}
