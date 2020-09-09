package com.example.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SkillAdapter extends RecyclerView.Adapter<SkillAdapter.ViewHolder> {

    LayoutInflater inflater;
    List<SkillIqLeaderboard> skillIqLeaderboard;


    public SkillAdapter(Context ctx,List<SkillIqLeaderboard>skillIqLeaderboard){
        this.inflater = LayoutInflater.from(ctx);
        this.skillIqLeaderboard=skillIqLeaderboard;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custome_skill_iq_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.iq_leader_name.setText(skillIqLeaderboard.get(position).getName());
        holder.skill_IQ_score.setText(skillIqLeaderboard.get(position).getScore());
        Picasso.get().load(skillIqLeaderboard.get(position).getBadgeUrl()).into(holder.Skill_Iq_badge);


    }

    @Override
    public int getItemCount() {
        return skillIqLeaderboard.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView iq_leader_name, skill_IQ_score;
        ImageView Skill_Iq_badge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iq_leader_name= itemView.findViewById(R.id.iq_leader_name);
            skill_IQ_score= itemView.findViewById(R.id.skill_IQ_Score);
            Skill_Iq_badge= itemView.findViewById(R.id.Skill_Iq_badge);
        }
    }


}
