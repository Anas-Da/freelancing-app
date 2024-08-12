package com.example.freelancing_app.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.CustomerResponse;
import com.example.freelancing_app.network.ApiService;
import com.example.freelancing_app.network.RetrofitInstance;
import com.example.freelancing_app.ui.AccountSettingsCustomer;
import com.example.freelancing_app.ui.ChatList;
import com.example.freelancing_app.ui.Home;
import com.example.freelancing_app.ui.NotificationsServiceProvider;
import com.example.freelancing_app.utils.GlobalVariables;
import com.example.freelancing_app.utils.ImageUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AccountCustomer extends AppCompatActivity implements View.OnClickListener {

    private ApiService apiService;
    GlobalVariables globalVariables;

    CustomerResponse res;
    ImageButton settings_b;
    ImageButton notification_b;
    ImageButton account_ib;
    ImageButton home_ib;
    ImageButton chat_ib;
    //TODO get these information from back
    private ImageView photo_iv;
    private TextView fullname_tv;
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
        fullname_tv = findViewById(R.id.fullname_tv);
        location_tv = findViewById(R.id.location_tv);
        member_since_tv = findViewById(R.id.member_since_tv);
        language_tv = findViewById(R.id.language_tv);
        date_of_birth_tv = findViewById(R.id.date_of_birth_tv);

        settings_b.setOnClickListener(this);
        notification_b.setOnClickListener(this);
        account_ib.setOnClickListener(this);
        home_ib.setOnClickListener(this);
        chat_ib.setOnClickListener(this);

        globalVariables = (GlobalVariables) getApplicationContext();
        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);


        fetchAccount();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.settings_b){
            Intent intent=new Intent(AccountCustomer.this, AccountSettingsCustomer.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.notification_b){
            Intent intent=new Intent(AccountCustomer.this, NotificationsCustomer.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.home_ib){
            Intent intent=new Intent(AccountCustomer.this, Home.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.chat_ib){
            Intent intent=new Intent(AccountCustomer.this, ChatList.class);
            startActivity(intent);
        }


    }
    private void fetchAccount() {
        String authToken = "Bearer " + globalVariables.getToken();
        Call<CustomerResponse> call = apiService.getCustomerResponse(authToken);
        call.enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    res = response.body();
                    updateLayout();
                } else {
                    Toast.makeText(AccountCustomer.this, "Failed to fetch Info", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CustomerResponse> call, Throwable t) {
                Toast.makeText(AccountCustomer.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void updateLayout(){
        String base64Image = res.getImg();
        Bitmap bitmap = ImageUtils.decodeBase64ToBitmap(base64Image);
        photo_iv.setImageBitmap(bitmap);
        fullname_tv.setText(res.getFirst_name() + " " + res.getSecond_name());
    }


}

