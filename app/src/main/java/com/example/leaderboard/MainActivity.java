package com.example.leaderboard;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.LauncherActivity;
import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {


    private static final String URL_DATA= "https://gadsapi.herokuapp.com/api/hours";

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    private List<LearnerLeaderboard> mLearnerLeaderboardList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout= findViewById(R.id.tabLayout);
        viewPager= findViewById(R.id.viewPager);
        adapter= new ViewPagerAdapter(getSupportFragmentManager());
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Fragment will be added here

        adapter.AddFragment(new FragmentLearner(), " Learning Leaders");
        adapter.AddFragment(new FragmentSkillIq(),"Skill IQ Leaders");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        mRecyclerView= findViewById(R.id.learner_leaderboard_recyclerview);
       // mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        mLearnerLeaderboardList= new ArrayList<>();
        loadRecyclerViewData();

    }

    private void loadRecyclerViewData() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                progressDialog.dismiss();

                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray jsonArray = new JSONArray("");

                    for (int i = 0; i<jsonArray.length();i++){
                        JSONObject o = jsonArray.getJSONObject(i);
                        LearnerLeaderboard item = new LearnerLeaderboard(
                                o.getString("name"),
                                o.getInt("hours"),
                                o.getString("country"),
                                o.getString("badgeURL")
                        );
                        mLearnerLeaderboardList.add(item);
                    }

                    mRecyclerViewAdapter = new RecyclerViewAdapter(mLearnerLeaderboardList,getApplicationContext());
                    mRecyclerView.setAdapter(mRecyclerViewAdapter);
                }

                catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        },
        new Response.ErrorListener(){
          @Override
          public void onErrorResponse(VolleyError volleyError){

          }
        });

        RequestQueue requestQueue = new Volley().newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    }

