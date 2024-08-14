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

import com.example.freelancing_app.models.CustomerResponse;
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
public class ProfileServiceProviderAbout extends AppCompatActivity implements View.OnClickListener {

    private ApiService apiService;
    GlobalVariables globalVariables;

    private ProfileSellerResponse res;

    private TextView fullname_tv;
    private TextView username_tv;
    private TextView location_tv;
    private TextView rating_tv;
    private TextView member_since_tv;
    private TextView group_tv;
    private  TextView phone_tv;
    private TextView payment_methods_tv;
    private TextView sevices_provided_tv;
    private TextView date_of_birth_tv;
    private ImageView photo_iv;
     ImageButton settings_b;

     ImageButton edit_profile_b;
     ImageButton notification_b;
     Button information_b;
     Button Rating_b;
    
     ImageButton account_ib;
     ImageButton home_ib;
     ImageButton chat_ib;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile_service_provider_about);

        globalVariables = (GlobalVariables) getApplicationContext();
        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);

        settings_b=findViewById(R.id.settings_b);
        edit_profile_b=findViewById(R.id.edit_profile_b);
        notification_b=findViewById(R.id.notification_b);
        information_b=findViewById(R.id.information_b);
        Rating_b=findViewById(R.id.Rating_b);
        account_ib=findViewById(R.id.account_ib);
        home_ib=findViewById(R.id.home_ib);
        chat_ib=findViewById(R.id.chat_ib);
        fullname_tv = findViewById(R.id.fullname_tv);
        photo_iv = findViewById(R.id.photo_iv);

        settings_b.setOnClickListener(this);
        edit_profile_b.setOnClickListener(this);
        notification_b.setOnClickListener(this);
        information_b .setOnClickListener(this);
        Rating_b.setOnClickListener(this);
        account_ib.setOnClickListener(this);
        home_ib.setOnClickListener(this);
        chat_ib .setOnClickListener(this);

        fullname_tv=findViewById(R.id.fullname_tv);
        username_tv=findViewById(R.id.username_tv);
        location_tv=findViewById(R.id.location_tv);
        rating_tv=findViewById(R.id.rating_tv);
        member_since_tv=findViewById(R.id.member_since_tv);
        group_tv=findViewById(R.id.group_tv);
        phone_tv=findViewById(R.id.phone_tv);
        payment_methods_tv=findViewById(R.id.payment_methods_tv);
        sevices_provided_tv=findViewById(R.id.sevices_provided_tv);
        date_of_birth_tv=findViewById(R.id.date_of_birth_tv);
        photo_iv=findViewById(R.id.photo_iv);

        // TODO
        fetchAccount();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.settings_b){
            Intent intent=new Intent(ProfileServiceProviderAbout.this,AccountSettingsServiceProvider.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.edit_profile_b){
            // TODO help
            Intent intent=new Intent(ProfileServiceProviderAbout.this,ProfileSettings.class);
            startActivity(intent);
        }

        else if (v.getId()==R.id.notification_b){
            Intent intent=new Intent(ProfileServiceProviderAbout.this,NotificationsServiceProvider.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.information_b){
            Intent intent=new Intent(ProfileServiceProviderAbout.this, ProfileServiceProviderInformation.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.Rating_b){
            Intent intent=new Intent(ProfileServiceProviderAbout.this, ProfileServiceProviderRating.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.account_ib){
            Intent intent=new Intent(ProfileServiceProviderAbout.this,AccountServiceProvider.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.home_ib){
           Intent intent=new Intent(ProfileServiceProviderAbout.this,Home.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.chat_ib){
            Intent intent=new Intent(ProfileServiceProviderAbout.this,ChatList.class);
            startActivity(intent);
        }
    }

    private void fetchAccount() {
        String authToken = "Bearer " + globalVariables.getToken();
        int pr_id=globalVariables.getProfileid();
        String username = globalVariables.getUsername();
        Call<ProfileSellerResponse> call = apiService.getProfileSellerResponse(authToken,username,pr_id+1);
        Toast.makeText(this,String.valueOf(pr_id+1) , Toast.LENGTH_SHORT).show();
        call.enqueue(new Callback<ProfileSellerResponse>() {
            @Override
            public void onResponse(Call<ProfileSellerResponse> call, Response<ProfileSellerResponse> response) {
                Toast.makeText(ProfileServiceProviderAbout.this, String.valueOf(response.isSuccessful()), Toast.LENGTH_SHORT).show();
                if (response.isSuccessful() && response.body() != null) {
                    res = response.body();
                    globalVariables.setProfileSellerResponse(res);
                    updateLayout();
                } else {
                    Toast.makeText(ProfileServiceProviderAbout.this, "Failed to fetch Info", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileSellerResponse> call, Throwable t) {
                Toast.makeText(ProfileServiceProviderAbout.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void updateLayout(){
        String base64Image = globalVariables.getSeller().getImg();
        Bitmap bitmap = ImageUtils.decodeBase64ToBitmap(base64Image);
        photo_iv.setImageBitmap(bitmap);
        fullname_tv.setText(res.getFirst_name() + " " + res.getSecond_name());
        globalVariables.setProfileid(res.getProfile_id());

        username_tv.setText(res.getSeller_username());
        rating_tv.setText(String.valueOf(res.getRate()));
        location_tv.setText(res.getCountry());
        date_of_birth_tv.setText(res.getBdate());
        phone_tv.setText(res.getPhone_number());
        group_tv.setText(res.getWork_group());
        sevices_provided_tv.setText(String.valueOf(res.getProvided_services()));
        member_since_tv.setText(res.getMember_since().substring(0,10));
        String s="";
        if(res.getAl_haram()){
            s+="Al_haram ";
        }
        if(res.getSyriatel_cash()){
            s+="Syriatel_Cash ";
        }
        if(res.getUsdt()){
            s+="USDT ";
        }
        payment_methods_tv.setText(s);

    }
}