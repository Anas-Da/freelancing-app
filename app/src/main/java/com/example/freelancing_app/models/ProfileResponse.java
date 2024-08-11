package com.example.freelancing_app.models;

import com.google.gson.annotations.SerializedName;

public class ProfileResponse {
    @SerializedName("profile_id")
    private int profile_id;
    @SerializedName("language")
    private String language;

    @SerializedName("work_group")
    private String work_group;

    @SerializedName("bio")
    private String bio;

    @SerializedName("provided_services")
    private int provided_services;

    @SerializedName("member_since")
    private String member_since;

    @SerializedName("rate")
    private int rate;

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getWork_group() {
        return work_group;
    }

    public void setWork_group(String work_group) {
        this.work_group = work_group;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getProvided_services() {
        return provided_services;
    }

    public void setProvided_services(int provided_services) {
        this.provided_services = provided_services;
    }

    public String getMember_since() {
        return member_since;
    }

    public void setMember_since(String member_since) {
        this.member_since = member_since;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
