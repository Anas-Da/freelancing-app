package com.example.freelancing_app.models;

import com.google.gson.annotations.SerializedName;

public class ReviewList {
    @SerializedName("review_id")
   private int review_id;
    @SerializedName("seller_username")
   private String seller_username;
    @SerializedName("profile_id")
   private int profile_id;
    @SerializedName("customer_id")
    private String customer_username;
    @SerializedName("rate")
    private int rate;
    @SerializedName("comment")
    private String comment;

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public String getSeller_username() {
        return seller_username;
    }

    public void setSeller_username(String seller_username) {
        this.seller_username = seller_username;
    }

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public String getCustomer_username() {
        return customer_username;
    }

    public void setCustomer_username(String customer_id) {
        this.customer_username = customer_id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
