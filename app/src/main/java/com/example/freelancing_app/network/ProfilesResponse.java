package com.example.freelancing_app.network;

import com.example.freelancing_app.models.Profile;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ProfilesResponse {

    @SerializedName("profiles")
    private List<Profile> profiles;

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }
}
