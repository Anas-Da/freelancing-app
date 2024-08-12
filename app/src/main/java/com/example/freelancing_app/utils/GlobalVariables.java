package com.example.freelancing_app.utils;

import android.app.Application;
import android.content.Intent;

import com.example.freelancing_app.models.AccountSellerResponse;
import com.example.freelancing_app.models.Customer_json;
import com.example.freelancing_app.models.ProfileSellerResponse;
import com.example.freelancing_app.models.Provider_json;
import com.example.freelancing_app.models.SignUpRequest;
import com.example.freelancing_app.models.UserProfile;
import com.example.freelancing_app.service.TokenRefreshService;

import java.util.Date;

public class GlobalVariables extends Application {




    private int profileid;





    private ProfileSellerResponse profileSellerResponse;

    private SignUpRequest signUpRequest;
    private Provider_json providerJson;
    private Customer_json customerJson;
    private AccountSellerResponse Seller;


    private  String whereAmI;
    private String  bio;
    private String bio_tv;

    private String token;
    private boolean IsCustomer;
    private int Job;
    private int sellerid;
    private int WorkGroup;
    private String sellerhandle;
    private String ChatWith="";
    private String fullname;
    private String username;
    private String email;
    private String password;
    private String cpassword;
    private String country;
    private String phone;
    private Date dateofbirth;

    private UserProfile Profile;

    public UserProfile getProfile() {
        return Profile;
    }

    public void setProfile(UserProfile profile) {
        Profile = profile;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        // Start TokenRefreshService
        Intent tokenRefreshServiceIntent = new Intent(this, TokenRefreshService.class);
        startService(tokenRefreshServiceIntent);
        signUpRequest = new SignUpRequest();
        providerJson = new Provider_json();
        customerJson = new Customer_json();
        Profile = new UserProfile();
        Seller = new AccountSellerResponse();
        profileSellerResponse = new ProfileSellerResponse();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        // Stop TokenRefreshService when the application terminates
        Intent tokenRefreshServiceIntent = new Intent(this, TokenRefreshService.class);
        stopService(tokenRefreshServiceIntent);
    }
    public int getJob() {
        return Job;
    }
    public void setJob(int job) {
        Job = job;
    }
    public int getSellerid() {
        return sellerid;
    }
    public void setSellerid(int sellerid) {
        this.sellerid = sellerid;
    }
    public String getSellerhandle() {
        return sellerhandle;
    }
    public void setSellerhandle(String sellerhandle) {
        this.sellerhandle = sellerhandle;
    }
    public int getWorkGroup() {
        return WorkGroup;
    }
    public void setWorkGroup(int workGroup) {
        WorkGroup = workGroup;
    }
    public String getChatWith() {
        return ChatWith;
    }
    public void setChatWith(String chatWith) {
        ChatWith = chatWith;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCpassword() {
        return cpassword;
    }
    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public Date getDateofbirth() {
        return dateofbirth;
    }
    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public Provider_json getProvider() {
        return providerJson;
    }

    public void setProvider(Provider_json providerJson) {
        this.providerJson = providerJson;
    }

    public Customer_json getCustomer() {
        return customerJson;
    }

    public void setCustomer(Customer_json customerJson) {
        this.customerJson = customerJson;
    }

    public void setCustomer(boolean customer) {
        IsCustomer = customer;
    }
    public boolean isCustomer() {
        return IsCustomer;
    }

    public SignUpRequest getSignUpRequest() {
        return signUpRequest;
    }

    public void setSignUpRequest(SignUpRequest signUpRequest) {
        this.signUpRequest = signUpRequest;
    }

    public Provider_json getProviderJson() {
        return providerJson;
    }

    public void setProviderJson(Provider_json providerJson) {
        this.providerJson = providerJson;
    }

    public Customer_json getCustomerJson() {
        return customerJson;
    }

    public void setCustomerJson(Customer_json customerJson) {
        this.customerJson = customerJson;
    }
    public int getProfileid() {
        return profileid;
    }

    public void setProfileid(int profileid) {
        this.profileid = profileid;
    }
    public AccountSellerResponse getSeller() {
        return Seller;
    }

    public void setSeller(AccountSellerResponse seller) {
        Seller = seller;
    }

    public String getWhereAmI() {
        return whereAmI;
    }

    public void setWhereAmI(String whereAmI) {
        this.whereAmI = whereAmI;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBio_tv() {
        return bio_tv;
    }

    public void setBio_tv(String bio_tv) {
        this.bio_tv = bio_tv;
    }


    public ProfileSellerResponse getProfileSellerResponse() {
        return profileSellerResponse;
    }
    public void setProfileSellerResponse(ProfileSellerResponse profileSellerResponse) {
        this.profileSellerResponse = profileSellerResponse;
    }
}
