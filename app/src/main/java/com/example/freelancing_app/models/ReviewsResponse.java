package com.example.freelancing_app.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewsResponse {
    @SerializedName("reviews")
    private List<ReviewList> reviews;

    public ReviewsResponse(List<ReviewList> res){this.reviews = res;}
    public List<ReviewList> getResult() {
        return reviews;
    }

}
