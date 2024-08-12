package com.example.freelancing_app.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.UserProfile;
import com.example.freelancing_app.ui.ProfileServiceProviderAbout;

import java.util.List;

public class UserProfileAdapter extends RecyclerView.Adapter<UserProfileAdapter.ProfileViewHolder> {

    private List<UserProfile> profileList;
    private Context context;
    private OnItemClickListener onItemClickListener1;
    private int position;

    public UserProfileAdapter(Context context,List<UserProfile> profileList, OnItemClickListener onItemClickListener1) {
        this.context=context;
        this.profileList = profileList;
        this.onItemClickListener1=onItemClickListener1;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profiles_item, parent, false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder holder, int position) {
        UserProfile profile = profileList.get(position);
        holder.itemView.setOnClickListener(v -> {
            // Handle item view click
            onItemClickListener1.onItemViewClick(position);
        });

        // Set up click listener for the checkbox
        holder.checkboxImageView.setOnClickListener(v -> {
            // Handle checkbox click
            onItemClickListener1.onCheckBoxClick(position);
        });
        holder.bind(profile);
    }



    @Override
    public int getItemCount() {
        return profileList.size();
    }



    public static class ProfileViewHolder extends RecyclerView.ViewHolder {

        private ImageView profilePicture;
        private TextView nameTextView;
        private TextView professionTextView;
        private ImageView checkboxImageView;

        public ProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            profilePicture = itemView.findViewById(R.id.profilePicture);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            professionTextView = itemView.findViewById(R.id.professionTextView);
            checkboxImageView = itemView.findViewById(R.id.checkboxImageView);
        }

        public void bind(UserProfile profile) {

            profilePicture.setImageBitmap(profile.getProfilePicture());
            nameTextView.setText(profile.getName());
            professionTextView.setText(profile.getProfession());
            checkboxImageView.setImageResource(profile.isChecked() ? R.drawable.on_img : R.drawable.off_img);
        }
    }
    public interface OnItemClickListener {
        public void onCheckBoxClick(int position);

        public void onItemViewClick(int position);
    }
}