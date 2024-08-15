package com.example.freelancing_app.ui;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.freelancing_app.models.ProfileSellerResponse;
import com.example.freelancing_app.network.ApiService;
import com.example.freelancing_app.network.RetrofitInstance;
import com.example.freelancing_app.utils.GlobalVariables;
import com.example.freelancing_app.utils.ImageUtils;
import com.example.freelancing_app.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


//TODO Back
public class ProfileServiceProviderInformation extends AppCompatActivity implements View.OnClickListener {

    private ApiService apiService;
    GlobalVariables globalVariables;
    private ProfileSellerResponse res;

    private TextView fullname_tv;
    private TextView username_tv;

    private TextView rating_tv;

    private ImageView photo_iv;

    private TextView bio_tv;
    private ImageButton settings_b;
    
    private ImageButton edit_profile_b;
    private ImageButton notification_b;
    private Button about_b;
    private Button Rating_b;

    private ImageButton account_ib;
    private ImageButton home_ib;
    private ImageButton chat_ib;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_service_provider_information);

        settings_b=findViewById(R.id.settings_b);
        edit_profile_b=findViewById(R.id.edit_profile_b);
        notification_b=findViewById(R.id.notification_b);
        about_b=findViewById(R.id.about_b);
        Rating_b=findViewById(R.id.Rating_b);
        account_ib=findViewById(R.id.account_ib);
        home_ib=findViewById(R.id.home_ib);
        chat_ib=findViewById(R.id.chat_ib);

       fullname_tv=findViewById(R.id.fullname_tv);;
        username_tv=findViewById(R.id.username_tv);;

       rating_tv=findViewById(R.id.rating_tv);;

       photo_iv=findViewById(R.id.photo_iv);;

        bio_tv=findViewById(R.id.bio_tv);;

        settings_b.setOnClickListener(this);
        edit_profile_b.setOnClickListener(this);
        notification_b.setOnClickListener(this);
        about_b .setOnClickListener(this);
        Rating_b.setOnClickListener(this);
        account_ib.setOnClickListener(this);
        home_ib.setOnClickListener(this);
        chat_ib .setOnClickListener(this);


        globalVariables = (GlobalVariables) getApplicationContext();
        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);


       // updateLayout();


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.settings_b){
            Intent intent=new Intent(ProfileServiceProviderInformation.this,AccountSettingsServiceProvider.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.edit_profile_b){
            // TODO make the class
            Intent intent=new Intent(ProfileServiceProviderInformation.this,ProfileSettings.class);
           startActivity(intent);
        }

        else if (v.getId()==R.id.notification_b){
            Intent intent=new Intent(ProfileServiceProviderInformation.this,NotificationsServiceProvider.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.about_b){
            Intent intent=new Intent(ProfileServiceProviderInformation.this, ProfileServiceProviderAbout.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.Rating_b){
            Intent intent=new Intent(ProfileServiceProviderInformation.this, ProfileServiceProviderRating.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.account_ib){
            Intent intent=new Intent(ProfileServiceProviderInformation.this,AccountServiceProvider.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.home_ib){
           Intent intent=new Intent(ProfileServiceProviderInformation.this,Home.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.chat_ib){
            Intent intent=new Intent(ProfileServiceProviderInformation.this,ChatList.class);
            startActivity(intent);
        }
    }
    void updateLayout(){
        String base64Image = globalVariables.getSeller().getImg();
        Bitmap bitmap = ImageUtils.decodeBase64ToBitmap(base64Image);
        photo_iv.setImageBitmap(bitmap);
        res=globalVariables.getProfileSellerResponse();
        fullname_tv.setText(res.getFirst_name() + " " + res.getSecond_name());
        username_tv.setText(res.getSeller_username());
        rating_tv.setText(String.valueOf(res.getRate()));
        bio_tv.setText(res.getBio());


    }

}