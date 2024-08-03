package com.example.freelancing_app.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancing_app.R;

public class SignUpServiceProvider2  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page2service_provider);


    }
    @Override
    public void onBackPressed() {
        // TODO delete super
        // Navigate to the previous activity without finishing the current one
        super.onBackPressed();
        Intent intent = new Intent(this, SignUpBase1.class);
        startActivity(intent);
    }

}
