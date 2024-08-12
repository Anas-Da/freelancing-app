package com.example.freelancing_app.models;


import com.google.gson.annotations.SerializedName;

public class ProfileSellerResponse {
    @SerializedName("seller_username")
    private String seller_username;

    @SerializedName("first_name")
    private String first_name;
    @SerializedName("second_name")
    private String second_name;

    @SerializedName("country")
    private String country;

    @SerializedName("bdate")
    private String bdate;

    @SerializedName("email")
    private String email;

    @SerializedName("phone_number")
    private String phone_number;

    @SerializedName("syriatel_cash")
    private Boolean syriatel_cash;

    @SerializedName("usdt")
    private Boolean usdt;

    @SerializedName("al_haram")
    private Boolean al_haram;

    @SerializedName("id_picture")
    private String id_picture;

    @SerializedName("profile_id")
    private int profile_id;

    @SerializedName("work_group")
    private String work_group;

    @SerializedName("bio")
    private String bio;

    @SerializedName("provided_services")
    private int provided_services;

    @SerializedName("member_since")
    private String member_since;

    @SerializedName("is_active")
    private Boolean is_active;

    @SerializedName("rate")
    private Double rate;

    public ProfileSellerResponse() {
    }

    public String getSeller_username() {
        return seller_username;
    }

    public void setSeller_username(String seller_username) {
        this.seller_username = seller_username;
    }
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Boolean getSyriatel_cash() {
        return syriatel_cash;
    }

    public void setSyriatel_cash(Boolean syriatel_cash) {
        this.syriatel_cash = syriatel_cash;
    }

    public Boolean getUsdt() {
        return usdt;
    }

    public void setUsdt(Boolean usdt) {
        this.usdt = usdt;
    }

    public Boolean getAl_haram() {
        return al_haram;
    }

    public void setAl_haram(Boolean al_haram) {
        this.al_haram = al_haram;
    }

    public String getId_picture() {
        return id_picture;
    }

    public void setAId_picture(String id_picture) {
        this.id_picture = id_picture;
    }

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
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

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }













}



