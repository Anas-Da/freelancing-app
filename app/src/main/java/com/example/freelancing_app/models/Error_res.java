package com.example.freelancing_app.models;

import com.google.gson.annotations.SerializedName;

public class Error_res {
    @SerializedName("error")
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
