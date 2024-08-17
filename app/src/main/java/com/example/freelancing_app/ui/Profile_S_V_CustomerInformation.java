package com.example.freelancing_app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.freelancing_app.R;

//TODO backkkkkkkkkkkkkkkkkkk
public class Profile_S_V_CustomerInformation extends AppCompatActivity implements View.OnClickListener{

    private ImageView back_b;

    private Button about_b;
    private Button  Rating_b;
    private  ImageButton account_ib;
    private  ImageButton home_ib;
    private  ImageButton chat_ib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_s_v_customer_information);
        back_b=findViewById(R.id.back_b);
        about_b=findViewById(R.id.about_b);
        Rating_b=findViewById(R.id.Rating_b);
        account_ib=findViewById(R.id.account_ib);
        home_ib=findViewById(R.id.home_ib);
        chat_ib=findViewById(R.id.chat_ib);

        back_b.setOnClickListener(this);
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
        else if(v.getId()==R.id.about_b)
        {
            Intent i=new Intent(Profile_S_V_CustomerInformation.this,Profile_S_V_CustomerAbout.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.Rating_b)
        {
            Intent i=new Intent(Profile_S_V_CustomerInformation.this,Profile_S_V_CustomerRating.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.account_ib)
        {
            Intent i=new Intent(Profile_S_V_CustomerInformation.this,AccountServiceProvider.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.home_ib)
        {
            Intent i=new Intent(Profile_S_V_CustomerInformation.this,Home.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.chat_ib)
        {
            Intent i=new Intent(Profile_S_V_CustomerInformation.this,ChatList.class);
            startActivity(i);
        }


    }
    private void destroyInterface() {
        finish();
    }

}