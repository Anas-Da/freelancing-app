package com.example.freelancing_app.ui;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancing_app.R;

public class CustomerProfile extends AppCompatActivity implements View.OnClickListener {

    ImageButton settings_b;
    ImageButton notification_b;
    ImageButton account_ib;
    ImageButton home_ib;
    ImageButton chat_ib;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_customer_profile_service_provider);
     settings_b = findViewById(R.id.settings_b);
     notification_b = findViewById(R.id.notification_b);
     account_ib = findViewById(R.id.account_ib);
     home_ib = findViewById(R.id.home_ib);
     chat_ib = findViewById(R.id.chat_ib);

     settings_b.setOnClickListener(this);
     notification_b.setOnClickListener(this);
     account_ib.setOnClickListener(this);
     home_ib.setOnClickListener(this);
     chat_ib.setOnClickListener(this);
 }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.settings_b){
            Intent intent=new Intent(CustomerProfile.this, AccountSettingsCustomer.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.notification_b){
            Intent intent=new Intent(CustomerProfile.this, Notifications.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.home_ib){
            Intent intent=new Intent(CustomerProfile.this,Home.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.chat_ib){
            Intent intent=new Intent(CustomerProfile.this,ChatList.class);
            startActivity(intent);
        }
    }
}

