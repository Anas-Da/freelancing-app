package com.example.freelancing_app;

import android.app.Application;
import android.content.Intent;

public class GlobalVariables extends Application {
    private boolean IsCustomer;
    private int Job;

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
}
