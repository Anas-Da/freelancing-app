package com.example.freelancing_app.models;


import android.graphics.Bitmap;

import java.io.Serializable;

public class UserProfile implements Serializable {



    private int profile_id;
    private String name;
    private String profession;
    private Bitmap profilePicture;
    private boolean isChecked;


    public UserProfile() {

    }

    public UserProfile(String name, String profession, Bitmap profilePicture, boolean isChecked) {
        this.name = name;
        this.profession = profession;
        this.profilePicture = profilePicture;
        this.isChecked = isChecked;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }

    public Bitmap getProfilePicture() {
        return profilePicture;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }
}