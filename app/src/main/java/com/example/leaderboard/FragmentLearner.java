package com.example.leaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentLearner extends Fragment {

    View v ;
    private RecyclerView mRecyclerView;
    private List<LearnerLeaderboard> mLearnerLeaderboardList;

    public FragmentLearner(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v =  inflater.inflate(R.layout.learner_leaderboard_fragment, container, false);
        mRecyclerView= v.findViewById(R.id.learner_leaderboard_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mLearnerLeaderboardList, getContext());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLearnerLeaderboardList = new ArrayList<>();
//        mLearnerLeaderboardList.add(new LearnerLeaderboard("Ajibola O",72,"Nigeria",""));
//        mLearnerLeaderboardList.add(new LearnerLeaderboard("Ajibola O",72,"Nigeria",""));
//        mLearnerLeaderboardList.add(new LearnerLeaderboard("Ajibola O",72,"Nigeria",""));

    }
}
