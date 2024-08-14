package com.example.freelancing_app.ui;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.Customer_json;
import com.example.freelancing_app.models.LoginRequest;
import com.example.freelancing_app.models.Provider_json;
import com.example.freelancing_app.models.SignUpRequest;
import com.example.freelancing_app.network.ApiService;
import com.example.freelancing_app.network.RetrofitInstance;
import com.example.freelancing_app.utils.GlobalVariables;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpBase3 extends AppCompatActivity {

    GlobalVariables globalVariables;
    TextView create_account_tv;
    RelativeLayout account_photo;
    ImageView photo_iv;
    Button back_b,next_b;
    private static final int PICK_IMAGE = 1;
    private ApiService apiService;
    boolean customer;
    String to641=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page3both);

        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        globalVariables = (GlobalVariables) getApplicationContext();

        create_account_tv = findViewById(R.id.create_account_tv);
        account_photo = findViewById(R.id.account_photo);
        photo_iv = findViewById(R.id.photo_iv);
        back_b = findViewById(R.id.back_b);
        next_b = findViewById(R.id.next_b);
        customer =globalVariables.isCustomer();
        if(customer){
            create_account_tv.setText(R.string.create_customer_account);
        }else{
            create_account_tv.setText(R.string.create_service_provider_account);
        }
        account_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        back_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        next_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completeSignUp();
            }
        });
    }
    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            photo_iv .setImageURI(imageUri);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                byte[] imageBytes = bitmapToByteArray(bitmap);
                to641 = encodeImageToBase64(imageBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private String encodeImageToBase64(byte[] imageBytes) {
        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    private void completeSignUp() {
        // Call this method when the signup process is complete
        globalVariables.getSignUpRequest().setImg(to641);

        if(customer){
            signupcustomer(globalVariables.getSignUpRequest());
        }else{
            signupprovider(globalVariables.getSignUpRequest());
        }
        //Log.d("SignUpServiceProvider2", globalVariables.getSignUpRequest().toString());

    }


    private void signupcustomer(SignUpRequest signUpRequest) {
        Call<Customer_json> call = apiService.signupcustomer(signUpRequest);
        call.enqueue(new Callback<Customer_json>() {
            @Override
            public void onResponse(Call<Customer_json> call, Response<Customer_json> response) {
                if (response.isSuccessful() && response.body() != null) {
                    handlecustomer(response);
                    String newAccessToken = response.body().getAccessToken();
                    String refreshToken = response.body().getRefreshToken();
                    //saveTokens(newAccessToken, refreshToken);
                    // Proceed with the next activity

                } else {
                    Toast.makeText(SignUpBase3.this, "Signup failed! Invalid credentials.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Customer_json> call, Throwable t) {
                Toast.makeText(SignUpBase3.this, "Signup failed! " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void signupprovider(SignUpRequest signUpRequest) {
        Call<Provider_json> call = apiService.signupprovider( signUpRequest);
        call.enqueue(new Callback<Provider_json>() {
            @Override
            public void onResponse(Call<Provider_json> call, Response<Provider_json> response) {
                if (response.body() != null) {
                    handleprovider(response);
                    String newAccessToken = response.body().getAccessToken();
                    String refreshToken = response.body().getRefreshToken();
                    //saveTokens(newAccessToken, refreshToken);
                    // Proceed with the next activity
                } else {
                    Toast.makeText(SignUpBase3.this, "Signup failed! Invalid credentials.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Provider_json> call, Throwable t) {
                Toast.makeText(SignUpBase3.this, "Signup failed! " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        //Log.d("SignUpBase3", globalVariables.getSignUpRequest().toString());
    }


    private void handleprovider(Response<Provider_json> response) {
        if (response.body() != null) {
            Provider_json providerJson = response.body();
            globalVariables.setProvider(providerJson);
            if (providerJson.getError() == null || providerJson.getError().equals("no error found")) {
                Toast.makeText(SignUpBase3.this, "Signup successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpBase3.this, Home.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // Finish the current activity
            } else {
                Toast.makeText(SignUpBase3.this, "Signup failed! " + providerJson.getError(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(SignUpBase3.this, "Signup failed! Invalid credentials.", Toast.LENGTH_SHORT).show();
        }
    }
    private void handlecustomer(Response<Customer_json> response) {
        if (response.isSuccessful() && response.body() != null) {
            Customer_json customerJson = response.body();
            globalVariables.setCustomer(customerJson);
            if (customerJson.getError() == null || customerJson.getError().equals("no error found")) {
                Toast.makeText(SignUpBase3.this, "Signup successful!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignUpBase3.this, Home.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish(); // Finish the current activity
            } else {
                Toast.makeText(SignUpBase3.this, "Signup failed! " + customerJson.getError(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(SignUpBase3.this, "Signup failed! Invalid credentials.", Toast.LENGTH_SHORT).show();
        }
    }
}
