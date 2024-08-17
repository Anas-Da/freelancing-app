package com.example.freelancing_app.network;

import com.example.freelancing_app.models.AccountSellerResponse;
import com.example.freelancing_app.models.CustomerResponse;
import com.example.freelancing_app.models.Customer_json;
import com.example.freelancing_app.models.Error_res;
import com.example.freelancing_app.models.LoginRequest;
import com.example.freelancing_app.models.Message;
import com.example.freelancing_app.models.MessageResponse;
import com.example.freelancing_app.models.Profile;
import com.example.freelancing_app.models.ProfileResponse;
import com.example.freelancing_app.models.ProfileSellerResponse;
import com.example.freelancing_app.models.Provider_json;
import com.example.freelancing_app.models.ReviewsResponse;
import com.example.freelancing_app.models.SearchResults;
import com.example.freelancing_app.models.SignUpRequest;
import com.example.freelancing_app.models.WorkGroupsResponse;
import com.example.freelancing_app.utils.GlobalVariables;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

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

    @GET("account/seller")
    Call<AccountSellerResponse>getSellerAccount(@Header("Authorization") String authToken);

    @GET ("profiles/available")
    Call <WorkGroupsResponse> getWorkGroups(@Header("Authorization") String authToken);
    @GET("account/customer")
    Call<CustomerResponse>getCustomerResponse(@Header("Authorization") String authToken);

    @GET ("review/explore/{seller_account_username}/{profileId}")
    Call<ReviewsResponse> getReviews(@Path("seller_account_username") String seller_account_username, @Path("profileId") String profileId);
    @GET("account/seller/profile/{username}/{profile_id}")
    Call<ProfileSellerResponse>getProfileSellerResponse(@Header("Authorization") String authToken,@Path("username") String username,@Path("profile_id")int profile_id);

    @POST("update/seller/profile/{profileId}")
    Call <Provider_json> updateprofile(@Query("bio")String bio  , @Header("Authorization") String authToken, @Path("profileId") int profileId) ;

    @POST("search")
    Call<SearchResults> searchUsers(@Body Map<String, String> filters);
    @GET("pause/seller/profile/{profileId}")
    Call <Error_res> pauseProfile(@Header("Authorization") String authToken, @Path("profileId") String profileId) ;
    @GET("resume/seller/profile/{profileId}")
    Call <Error_res> resumeProfile(@Header("Authorization") String authToken, @Path("profileId") String profileId) ;
    @POST("chat/send/{username}")
    Call<Error_res> sendMessage(@Header("Authorization") String authToken, @Path("username") String username,@Body String message);
    @POST("create/seller/profile")
    Call<ProfileResponse> CreateProfile(@Header("Authorization") String authToken, @Body String work_group);
}

