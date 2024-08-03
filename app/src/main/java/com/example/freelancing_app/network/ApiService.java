package com.example.freelancing_app.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("homepage")
    Call<ProfilesResponse> getProfiles();

    @GET("chats")
    Call<ChatsResponse> getChats();
}
