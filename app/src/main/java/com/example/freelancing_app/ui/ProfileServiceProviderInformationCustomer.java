package com.example.freelancing_app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.freelancing_app.R;

//ToDO Backkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
public class ProfileServiceProviderInformationCustomer extends AppCompatActivity  implements View.OnClickListener {
    private ImageView back_b;
    private RelativeLayout chat_b;
    private Button  about_b;
    private Button  Rating_b;
    private  ImageButton account_ib;
    private  ImageButton home_ib;
    private  ImageButton chat_ib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_service_provider_information_customer);

        back_b=findViewById(R.id.back_b);
        chat_b=findViewById(R.id.chat_b);
        about_b=findViewById(R.id.about_b);
        Rating_b=findViewById(R.id.Rating_b);
        account_ib=findViewById(R.id.account_ib);
        home_ib =findViewById(R.id.home_ib);
        chat_ib=findViewById(R.id.chat_ib);

        back_b.setOnClickListener(this);
        chat_b.setOnClickListener(this);
        about_b.setOnClickListener(this);
        Rating_b.setOnClickListener(this);
        account_ib.setOnClickListener(this);
        home_ib.setOnClickListener(this);
        chat_ib.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.back_b)
        {
            destroyInterface();
        }
        else if(v.getId()==R.id.chat_b)
        {
            Intent i=new Intent(ProfileServiceProviderInformationCustomer.this, ProfileServiceProviderInformation.class);
            //TODO chat_service_provider
            startActivity(i);
        }
        else if(v.getId()==R.id.about_b)
        {
            Intent i=new Intent(ProfileServiceProviderInformationCustomer.this, ProfileServiceProviderAboutCustomer.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.Rating_b)
        {
            // todo
            Intent i=new Intent(ProfileServiceProviderInformationCustomer.this,ProfileServiceProviderRatingCustomer.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.account_ib)
        {
            // todo
            Intent i=new Intent(ProfileServiceProviderInformationCustomer.this,AccountCustomer.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.home_ib)
        {
            Intent i=new Intent(ProfileServiceProviderInformationCustomer.this,Home.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.chat_ib)
        {
            Intent i=new Intent(ProfileServiceProviderInformationCustomer.this,ChatList.class);
            startActivity(i);
        }

    }
    private void destroyInterface() {
        finish();
    }
}