package com.example.freelancing_app;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class SignInActivity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page2_1);
        Intent intent = getIntent();
        boolean IsCustomer = intent.getBooleanExtra("isCustomer",false);
        if(IsCustomer){
            Toast.makeText(SignInActivity_2.this,
                    "Customer", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(SignInActivity_2.this,
                    "Service Provider", Toast.LENGTH_SHORT).show();
        }
    }

}
