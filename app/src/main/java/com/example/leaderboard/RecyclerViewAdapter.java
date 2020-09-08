package com.example.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideOption;
import com.bumptech.glide.request.RequestOptions;

import java.time.Instant;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<LearnerLeaderboard> mLearnerLeaderboardList;
    private Context mContext;



    public RecyclerViewAdapter(List<LearnerLeaderboard> learnerLeaderboardList, Context context) {

        this.mLearnerLeaderboardList = learnerLeaderboardList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.item_learner_leaderboard,parent,false);
        MyViewHolder viewHolder= new MyViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_name.setText(mLearnerLeaderboardList.get(position).getName());
        holder.tv_hours.setText(new StringBuilder().append(mLearnerLeaderboardList.get(position)
                .getHours()).append(" learning hours,"));
        holder.tv_country.setText(mLearnerLeaderboardList.get(position).getCountry());
        Glide.with(mContext).load(mLearnerLeaderboardList.get(position).getBadgeUrl())
                .apply(RequestOptions.centerCropTransform()).into(holder.img);





    }

    @Override
    public int getItemCount() {
        return mLearnerLeaderboardList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_name;
        private TextView tv_hours;
        private TextView tv_country;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.learner_name);
            tv_hours= itemView.findViewById(R.id.learner_hours);
            tv_country= itemView.findViewById(R.id.learner_country);
            img= itemView.findViewById(R.id.learner_badge);
        }
    }
}
