package com.example.freelancing_app.utils;

import android.app.Application;
import android.content.Intent;

public class GlobalVariables extends Application {
    private boolean IsCustomer;
    private int Job;
    private int sellerid;
    private String sellerhandle;
    private int WorkGroup;
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
}
