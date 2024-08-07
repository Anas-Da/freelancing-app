package com.example.freelancing_app.network;

import com.example.freelancing_app.models.Customer_json;
import com.example.freelancing_app.models.LoginRequest;
import com.example.freelancing_app.models.Message;
import com.example.freelancing_app.models.MessageResponse;
import com.example.freelancing_app.models.Provider_json;
import com.example.freelancing_app.models.SignUpRequest;
import com.example.freelancing_app.utils.GlobalVariables;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("homepage")
    Call<ProfilesResponse> getProfiles();
    @GET("chats")
    Call<ChatsResponse> getChats(@Header("Authorization") String authToken);
    @POST("signin/customer")
    Call<Customer_json> logincustomer(@Body LoginRequest loginRequest);
    @POST("signin/seller")
    Call<Provider_json> loginprovider(@Body LoginRequest loginRequest);
    @POST("signup/seller")
    Call<Provider_json> signupprovider(@Body SignUpRequest signUpRequest);
    @POST("signup/customer")
    Call<Customer_json> signupcustomer( @Body SignUpRequest signUpRequest);

    @GET("chat/{chatId}")
    Call<MessageResponse> getMessages(@Path("chatId") String chatId, @Header("Authorization") String authToken);
   /* //TODO check these from our back please
   @GET("search")
    Call<Search_Results> searchUsers(@Query("firstName" String firstname, @Query("secondName" String secondname,@Query("username") String username,
            @Query("rating") String rating,
            @Query("workgroup") String workgroup,
            @Query("isActive") boolean isActive
    );*/

}
