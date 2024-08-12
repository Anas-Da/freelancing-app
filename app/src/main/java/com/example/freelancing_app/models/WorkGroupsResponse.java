package com.example.freelancing_app.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WorkGroupsResponse {

    @SerializedName("result")
    private List<String> res;

    public WorkGroupsResponse(List<String> res) {
        this.res = res;
    }

    public List<String> getResult() {
        return res;
    }
}
