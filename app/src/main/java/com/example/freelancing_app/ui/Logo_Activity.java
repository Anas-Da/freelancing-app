package com.example.freelancing_app.ui;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.freelancing_app.R;
import com.example.freelancing_app.utils.TokenRefreshService;
import android.content.pm.PackageManager;


public class Logo_Activity extends AppCompatActivity {
    private static final int STORAGE_PERMISSION_CODE = 100;

    private Intent tokenRefreshServiceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo1);


        // Delay for 5 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goToSignInLayout();
                // Start the SignInActivity

                /*
                Intent intent = new Intent(Logo_Activity.this, AccountServiceProvider.class);
                startActivity(intent);
                finish(); // Close the splash activity
                */

            }
        }, 1000); // 1000 milliseconds = 4 seconds

          // Start TokenRefreshService
       //   TODO MAke sure everything is ok
      //   tokenRefreshServiceIntent = new Intent(this, TokenRefreshService.class);
       // startService(tokenRefreshServiceIntent);

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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
                Toast.makeText(this, "Storage Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                // Permission denied
                Toast.makeText(this, "Storage Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
