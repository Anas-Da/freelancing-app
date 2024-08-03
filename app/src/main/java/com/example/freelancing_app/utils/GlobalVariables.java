package com.example.freelancing_app.utils;

import android.app.Application;
import android.content.Intent;
import android.provider.ContactsContract;

import java.util.Date;

public class GlobalVariables extends Application {
    private boolean IsCustomer;
    private int Job;
    private int sellerid;

    private int WorkGroup;
    private String sellerhandle;
    private String ChatWith;
    private String fullname;
    private String username;
    private String email;
    private String password;
    private String cpassword;
    private String country;

    private String phone;
    private Date dateofbirth;
    @Override
    public void onCreate() {
        super.onCreate();

        // Start TokenRefreshService
        Intent tokenRefreshServiceIntent = new Intent(this, TokenRefreshService.class);
        startService(tokenRefreshServiceIntent);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        // Stop TokenRefreshService when the application terminates
        Intent tokenRefreshServiceIntent = new Intent(this, TokenRefreshService.class);
        stopService(tokenRefreshServiceIntent);
    }
    public boolean isCustomer() {
        return IsCustomer;
    }

    public void setCustomer(boolean customer) {
        IsCustomer = customer;
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
}
