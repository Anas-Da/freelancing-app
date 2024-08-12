package com.example.freelancing_app.models;


import com.google.gson.annotations.SerializedName;

public class CustomerResponse {
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

    @SerializedName("member_since")
    private String member_since;

    @SerializedName("img")
    private String img;
    @SerializedName("id")
    private int id;

    @SerializedName("username")
    private String username;

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


    public String getMember_since() {
        return member_since;
    }

    public void setMember_since(String member_since) {
        this.member_since = member_since;
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


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }













}



