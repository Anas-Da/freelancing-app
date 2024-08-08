package com.example.freelancing_app.models;

import com.google.gson.annotations.SerializedName;

public class Provider_json {
    @SerializedName("seller_username")
    private String sellerUsername;

    @SerializedName("first_name")
    private String firstname;

    @SerializedName("second_name")
    private String secondname;

    @SerializedName("country")
    private String country;

    @SerializedName("bdate")
    private String birthDate;

    @SerializedName("email")
    private String email;

    @SerializedName("phone_number")
    private String phoneNumber;

    @SerializedName("syriatel_cash")
    private boolean syriatelCash;

    @SerializedName("usdt")
    private boolean usdt;

    @SerializedName("al_haram")
    private boolean alHaram;

    @SerializedName("id_picture")
    private String idPicture;

    @SerializedName("img")
    private String img;

    @SerializedName("id")
    private int id;

    @SerializedName("error")
    private String error;

    @SerializedName("refresh")
    private String RefreshToken;
    @SerializedName("access")
    private String accessToken;

    // Getters and Setters
    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSyriatelCash() {
        return syriatelCash;
    }

    public void setSyriatelCash(boolean syriatelCash) {
        this.syriatelCash = syriatelCash;
    }

    public boolean isUsdt() {
        return usdt;
    }

    public void setUsdt(boolean usdt) {
        this.usdt = usdt;
    }

    public boolean isAlHaram() {
        return alHaram;
    }

    public void setAlHaram(boolean alHaram) {
        this.alHaram = alHaram;
    }

    public String getIdPicture() {
        return idPicture;
    }

    public void setIdPicture(String idPicture) {
        this.idPicture = idPicture;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getRefreshToken() {
        return RefreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        RefreshToken = refreshToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }
}