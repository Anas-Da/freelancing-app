package com.example.freelancing_app.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancing_app.utils.GlobalVariables;
import com.example.freelancing_app.R;

public class SignUp_P1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page1both);
        GlobalVariables globalVariables = (GlobalVariables) getApplicationContext();
        //TODO take the iscustomer from GlobalVariables
        Intent i=new Intent(SignUp_P1.this, ChoosingWorkgroup.class);
        startActivity(i);
    }
}
