package com.example.freelancing_app.ui;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.Customer_json;
import com.example.freelancing_app.models.LoginRequest;
import com.example.freelancing_app.models.Provider_json;
import com.example.freelancing_app.network.ApiService;
import com.example.freelancing_app.network.RetrofitInstance;
import com.example.freelancing_app.utils.GlobalVariables;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SignInActivity extends AppCompatActivity {

    private ApiService apiService;
    private EditText fullname_et;
    private EditText password_et;
    private Button SignIn_b;
    private ImageView eye_b;
    private TextView SignUp_b;
    private RadioButton ServiceProvider_rb;
    private RadioButton Customer_rb;
    private boolean isPasswordVisible;
    GlobalVariables globalVariables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        fullname_et = findViewById(R.id.fullname_et);
        password_et = findViewById(R.id.password_et);
        SignIn_b = findViewById(R.id.SignIn_b);
        SignUp_b = findViewById(R.id.SignUp_b);
        Customer_rb = findViewById(R.id.Customer_rb);
        ServiceProvider_rb = findViewById(R.id.ServiceProvider_rb);
        eye_b = findViewById(R.id.eye_b);

        globalVariables = (GlobalVariables) getApplicationContext();

        eye_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPasswordVisible = !isPasswordVisible;
                if (isPasswordVisible) {
                    password_et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    password_et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });

        SignIn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO going to Home for customer and service provider not that Activity
                String email = fullname_et.getText().toString();
                String password = password_et.getText().toString();
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(SignInActivity.this,
                            "Enter Both Email and password", Toast.LENGTH_SHORT).show();
                } else {
                    if (Customer_rb.isChecked()) {
                        globalVariables.setCustomer(true);
                        logincustomer(email, password);
                    } else if (ServiceProvider_rb.isChecked()) {
                        globalVariables.setCustomer(false);
                        loginprovider(email, password);
                    } else {
                        Toast.makeText(SignInActivity.this,
                                "Select ServiceProvider or customer", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        SignUp_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO go to first signup page
                Intent i = new Intent(SignInActivity.this, SignUpBase1.class);
                if (Customer_rb.isChecked()) {
                    globalVariables.setCustomer(true);
                } else if (ServiceProvider_rb.isChecked()) {
                    globalVariables.setCustomer(false);
                } else {
                    Toast.makeText(SignInActivity.this, "Select ServiceProvider or customer", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(i);
            }
        });

        //todo return it
        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);

    }



    private void logincustomer( String username, String password) {
        LoginRequest loginRequest = new LoginRequest(username, password);
        Call<Customer_json> call = apiService.logincustomer(loginRequest);
        call.enqueue(new Callback<Customer_json>() {
            @Override
            public void onResponse(Call<Customer_json> call, Response<Customer_json> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String newAccessToken = response.body().getAccessToken();
                    String refreshToken = response.body().getRefreshToken();
                    saveTokens(newAccessToken, refreshToken);
                    handleLoginResponsecustomer(response);
                    // Proceed with the next activity

                } else {
                    Toast.makeText(SignInActivity.this, "Login failed! Invalid credentials.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Customer_json> call, Throwable t) {
                Toast.makeText(SignInActivity.this, "Login failed! " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void loginprovider( String username, String password) {
        LoginRequest loginRequest = new LoginRequest(username, password);
        Call<Provider_json> call = apiService.loginprovider( loginRequest);
        call.enqueue(new Callback<Provider_json>() {
            @Override
            public void onResponse(Call<Provider_json> call, Response<Provider_json> response) {
                if (response.isSuccessful() && response.body() != null) {
                    String newAccessToken = response.body().getAccessToken();
                    String refreshToken = response.body().getRefreshToken();
                    globalVariables.setToken(newAccessToken);
                    saveTokens(newAccessToken, refreshToken);
                    handleLoginResponseprovider(response);
                    // Proceed with the next activity
                } else {
                    Toast.makeText(SignInActivity.this, "Login failed! Invalid credentials.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Provider_json> call, Throwable t) {
                Toast.makeText(SignInActivity.this, "Login failed! " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void saveTokens(String accessToken, String refreshToken) {
        SharedPreferences preferences = getSharedPreferences("my_app_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("access_token", accessToken);
        editor.putString("refresh_token", refreshToken);
        editor.apply();
    }


    private void handleLoginResponseprovider(Response<Provider_json> response) {
        if (response.isSuccessful() && response.body() != null) {
            Provider_json providerJson = response.body();
            globalVariables.setProvider(providerJson);
            if (providerJson.getError() == null || providerJson.getError().equals("no error found")) {
                Toast.makeText(SignInActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                globalVariables.setUsername(providerJson.getSellerUsername());
                Intent intent = new Intent(SignInActivity.this, Home.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(SignInActivity.this, "Login failed! " + providerJson.getError(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(SignInActivity.this, "Login failed! Invalid credentials.", Toast.LENGTH_SHORT).show();
        }
    }
    private void handleLoginResponsecustomer(Response<Customer_json> response) {
        if (response.isSuccessful() && response.body() != null) {
            Customer_json customerJson = response.body();
            globalVariables.setCustomer(customerJson);
            if (customerJson.getError() == null || customerJson.getError().equals("no error found")) {
                Toast.makeText(SignInActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                globalVariables.setUsername(customerJson.getUserName());
                Intent intent = new Intent(SignInActivity.this, Home.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(SignInActivity.this, "Login failed! " + customerJson.getError(), Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(SignInActivity.this, "Login failed! Invalid credentials.", Toast.LENGTH_SHORT).show();
        }
    }
}