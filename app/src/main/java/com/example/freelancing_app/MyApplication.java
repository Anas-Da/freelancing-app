package com.example.freelancing_app;

import android.app.Application;
import android.content.Intent;

public class MyApplication extends Application {
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
}
