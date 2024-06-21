package com.example.freelancing_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



public class Logo_Activity extends AppCompatActivity {

    private Intent tokenRefreshServiceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        // Start TokenRefreshService
        tokenRefreshServiceIntent = new Intent(this, TokenRefreshService.class);
        startService(tokenRefreshServiceIntent);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        // Stop TokenRefreshService
        if (tokenRefreshServiceIntent != null) {
            stopService(tokenRefreshServiceIntent);
        }
    }

    // Method to handle navigation to Sign In activity
    public void goToSignInLayout() {
        startActivity(new Intent(Logo_Activity.this, SignInActivity.class));
        finish(); // Optional: finish current activity after starting new activity
    }

    private void showToast(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
