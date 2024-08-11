package com.example.freelancing_app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancing_app.R;


public class AccountCustomer extends AppCompatActivity implements View.OnClickListener {

    ImageButton settings_b;
    ImageButton notification_b;
    ImageButton account_ib;
    ImageButton home_ib;
    ImageButton chat_ib;
    //TODO get these information from back
    private ImageView photo_iv;
    private TextView name_tv;
    private TextView location_tv;
    private TextView member_since_tv;
    private TextView language_tv;
    private TextView date_of_birth_tv;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_customer_profile_service_provider);
     settings_b = findViewById(R.id.settings_b);
     notification_b = findViewById(R.id.notification_b);
     account_ib = findViewById(R.id.account_ib);
     home_ib = findViewById(R.id.home_ib);
     chat_ib = findViewById(R.id.chat_ib);
     photo_iv = findViewById(R.id.photo_iv);
     name_tv = findViewById(R.id.fullname_tv);
     location_tv = findViewById(R.id.location_tv);
     member_since_tv = findViewById(R.id.member_since_tv);
     language_tv = findViewById(R.id.language_tv);
     date_of_birth_tv = findViewById(R.id.date_of_birth_tv);

     settings_b.setOnClickListener(this);
     notification_b.setOnClickListener(this);
     account_ib.setOnClickListener(this);
     home_ib.setOnClickListener(this);
     chat_ib.setOnClickListener(this);
 }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.settings_b){
            Intent intent=new Intent(AccountCustomer.this, AccountSettingsCustomer.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.notification_b){
            Intent intent=new Intent(AccountCustomer.this, NotificationsServiceProvider.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.home_ib){
            Intent intent=new Intent(AccountCustomer.this,Home.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.chat_ib){
            Intent intent=new Intent(AccountCustomer.this,ChatList.class);
            startActivity(intent);
        }


    }
}

