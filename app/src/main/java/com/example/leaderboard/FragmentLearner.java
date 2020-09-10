package com.example.leaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    TextView learner_name;
    TextView learner_hours;
    TextView learner_country;
    ImageView learner_badge;

    public FragmentLearner(){}



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



//        mRecyclerView= v.findViewById(R.id.learner_leaderboard_recyclerview);
//        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mLearnerLeaderboardList, getContext());
//
//        mLayoutManager = new LinearLayoutManager(getActivity());
//
//        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setAdapter(recyclerViewAdapter);
//
        mLearnerLeaderboardList = new ArrayList<>();
//        mLearnerLeaderboardList.add(new LearnerLeaderboard("Ajibola O",72,"Nigeria",""));
//        mLearnerLeaderboardList.add(new LearnerLeaderboard("Ajibola O",72,"Nigeria",""));
//        mLearnerLeaderboardList.add(new LearnerLeaderboard("Ajibola O",72,"Nigeria",""));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        v =  inflater.inflate(R.layout.item_learner_leaderboard, container, false);

        mRecyclerView= v.findViewById(R.id.learner_leaderboard_recyclerview);
//
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(mLearnerLeaderboardList, getContext());

        mRecyclerView.setAdapter(recyclerViewAdapter);

       // mRecyclerView.setLayoutManager(mLayoutManager);

        return v;
    }


}
