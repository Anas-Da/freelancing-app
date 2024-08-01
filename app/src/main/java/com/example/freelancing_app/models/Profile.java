package com.example.freelancing_app.models;

import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("profile_id")
    private int profileId;

    @SerializedName("username")
    private String username;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String secondName;

    @SerializedName("img")
    private String img;

    @SerializedName("language")
    private String language;

    @SerializedName("work_group")
    private String workGroup;

    @SerializedName("bio")
    private String bio;

    @SerializedName("provided_services")
    private int providedServices;

    @SerializedName("member_since")
    private String memberSince;

    @SerializedName("rate")
    private double rate;

    @SerializedName("is_active")
    private boolean isActive;

    // Getters and Setters

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getWorkGroup() {
        return workGroup;
    }

    public void setWorkGroup(String workGroup) {
        this.workGroup = workGroup;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getProvidedServices() {
        return providedServices;
    }

    public void setProvidedServices(int providedServices) {
        this.providedServices = providedServices;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
