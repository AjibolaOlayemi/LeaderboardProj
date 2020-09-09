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
import android.util.Log;
import android.view.View;
import android.widget.Adapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
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
    private RecyclerView.LayoutManager mLayoutManager;


    // this is for content  of the skill fragment
    private List<LearnerLeaderboard> mLearnerLeaderboardList;
    private List<SkillIqLeaderboard> skillIqLeaderboard;
    private static String JSON_URL="https://gads.api.herokuapp.com/api/skilliq";
    SkillAdapter skillAdapter;
    RecyclerView skillRV;



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

       // mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mLearnerLeaderboardList= new ArrayList<>();
        loadRecyclerViewData();

        //this section is to display the Skills fragment content
        skillRV=findViewById(R.id.skill_leaders);
        skillIqLeaderboard=new ArrayList<>();

        extractSkillLeadersScore();
//        skillRV.setLayoutManager(new LinearLayoutManager(this));
//        skillAdapter= new SkillAdapter(this, skillIqLeaderboard);
//        skillRV.setAdapter(skillAdapter);


    }

    private void extractSkillLeadersScore() {

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject skillLeadersObject = response.getJSONObject(i);

                        SkillIqLeaderboard iqLeaderboard = new SkillIqLeaderboard();
                        iqLeaderboard.setName(skillLeadersObject.getString("name").toString());
                        iqLeaderboard.setScore(skillLeadersObject.getInt("score"));
                        iqLeaderboard.setBadgeUrl(skillLeadersObject.getString("badgeUrl"));

                        skillIqLeaderboard.add(iqLeaderboard);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                skillRV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                skillAdapter= new SkillAdapter(getApplicationContext(), skillIqLeaderboard);
                skillRV.setAdapter(skillAdapter);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("tag", "onErrorResponse " + error.getMessage());
            }
        });

        queue.add(jsonArrayRequest);

    }


    // this displays content in the learning leaders fragment
    private void loadRecyclerViewData() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading Data...");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                progressDialog.dismiss();

                try {
                    JSONObject jsonObject = new JSONObject("https://gadsapi.herokuapp.com/api/hours");
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

    public void openSubmitActivity(View view){
        setContentView(R.layout.activity_submit);
    }

    }

