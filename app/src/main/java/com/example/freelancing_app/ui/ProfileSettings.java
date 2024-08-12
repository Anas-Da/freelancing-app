package com.example.freelancing_app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.Provider_json;
import com.example.freelancing_app.network.ApiService;
import com.example.freelancing_app.network.ProfilesResponse;
import com.example.freelancing_app.utils.GlobalVariables;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileSettings extends AppCompatActivity implements View.OnClickListener {

    GlobalVariables globalVariables;
    ApiService apiService;

    ImageButton bio_b;
    ImageButton language_b;
    ImageButton back_b;
    Button save_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile_settings);

        bio_b = findViewById(R.id.bio_b);
        language_b = findViewById(R.id.language_b);
        back_b = findViewById(R.id.back_b);
        save_b = findViewById(R.id.save_b);
        bio_b.setOnClickListener(this);
        language_b.setOnClickListener(this);
        back_b.setOnClickListener(this);
        save_b.setOnClickListener(this);

        globalVariables = (GlobalVariables) getApplicationContext();

    }
    private void updateProfiles() {
        int profileid = globalVariables.getProfileid();
        String authToken = "Bearer " + globalVariables.getToken();
        Call<Provider_json> call = apiService.updateprofile(globalVariables.getBio(), authToken,profileid );
        call.enqueue(new Callback<Provider_json>() {
            @Override
            public void onResponse(Call<Provider_json> call, Response<Provider_json> response) {
                if (response.isSuccessful() && response.body() != null) {

                    updateProfiles();
                } else {
                    Toast.makeText(ProfileSettings.this, "Failed to update profile", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Provider_json> call, Throwable t) {
                Toast.makeText(ProfileSettings.this,"Failed to update", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.bio_b){
            globalVariables.setWhereAmI("bio");
            openFragmentActivity("FRAGMENT_7");
        }
      // todo : Need to decide-->
            //  else if (v.getId()==R.id.language_b);
        else if (v.getId()==R.id.back_b)
            destroyInterface();
        //todo : send information to back
           //  else if (v.getId()==R.id.save_b)


    }
    private void openFragmentActivity(String fragmentTag) {
        Intent intent = new Intent(ProfileSettings.this, FragmentActivity.class);
        intent.putExtra("FRAGMENT_TAG", fragmentTag);
        startActivity(intent);
    }
    private void destroyInterface() {
        finish();
    }
}

