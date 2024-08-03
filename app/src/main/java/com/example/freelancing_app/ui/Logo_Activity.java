package com.example.freelancing_app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancing_app.R;


public class Logo_Activity extends AppCompatActivity {

    private Intent tokenRefreshServiceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo1);

        // Delay for 5 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the SignInActivity
                Intent intent = new Intent(Logo_Activity.this, SignInActivity.class);
                startActivity(intent);
                finish(); // Close the splash activity
            }
        }, 1000); // 1000 milliseconds = 4 seconds
       /*
          // Start TokenRefreshService
          TODO MAke sure everything is ok
         tokenRefreshServiceIntent = new Intent(this, TokenRefreshService.class);
        startService(tokenRefreshServiceIntent);
        */

    }
    /*
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

     */
}
