package com.example.freelancing_app.models;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class SearchResults implements Serializable {

    @SerializedName("results")
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public static class User implements Serializable {

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

        public String getWorkGroup() {
            return workGroup;
        }

        public void setWorkGroup(String workGroup) {
            this.workGroup = workGroup;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive(boolean active) {
            this.active = active;
        }
    }
}
