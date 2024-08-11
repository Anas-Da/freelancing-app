package com.example.freelancing_app.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AccountSellerResponse {
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
    private boolean syriatel_cash;
    @SerializedName("usdt")
    private boolean usdt;
    @SerializedName("al_haram")
    private boolean al_haram;
    @SerializedName("id_picture")
    private String id_picture;
    @SerializedName("id_picture2")
    private String id_picture2;
    @SerializedName("img")
    private String img;
    @SerializedName("profiles")
    List<ProfileResponse>profiles;

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

    public boolean isSyriatel_cash() {
        return syriatel_cash;
    }

    public void setSyriatel_cash(boolean syriatel_cash) {
        this.syriatel_cash = syriatel_cash;
    }

    public boolean isUsdt() {
        return usdt;
    }

    public void setUsdt(boolean usdt) {
        this.usdt = usdt;
    }

    public boolean isAl_haram() {
        return al_haram;
    }

    public void setAl_haram(boolean al_haram) {
        this.al_haram = al_haram;
    }

    public String getId_picture() {
        return id_picture;
    }

    public void setId_picture(String id_picture) {
        this.id_picture = id_picture;
    }

    public String getId_picture2() {
        return id_picture2;
    }

    public void setId_picture2(String id_picture2) {
        this.id_picture2 = id_picture2;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<ProfileResponse> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ProfileResponse> profiles) {
        this.profiles = profiles;
    }
}
