package com.example.freelancing_app.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SearchResults {

    @SerializedName("results")
    private List<User> users;


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public static class User {
        @SerializedName("username")
        private String username;

        @SerializedName("first_name")
        private String firstName;

        @SerializedName("second_name")
        private String secondName;

        @SerializedName("work_group")
        private String workGroup;

        @SerializedName("rate")
        private String rate;

        @SerializedName("active")
        private boolean active;

        // Getters and Setters
    }
}
