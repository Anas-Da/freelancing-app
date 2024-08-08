package com.example.freelancing_app.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancing_app.utils.GlobalVariables;
import com.example.freelancing_app.utils.ImageUtils;
import com.example.freelancing_app.R;
import com.example.freelancing_app.adapters.SellerAdapter;
import com.example.freelancing_app.models.Profile;
import com.example.freelancing_app.models.Seller;
import com.example.freelancing_app.network.ApiService;
import com.example.freelancing_app.network.ProfilesResponse;
import com.example.freelancing_app.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SellerList_SingleWorkGroup extends AppCompatActivity implements SellerAdapter.OnItemClickListener{


    GlobalVariables globalVariables;

    private RecyclerView sellers_list;
    private SellerAdapter sellerAdapter;
    private List<Seller> sellerList;

    private ApiService apiService;
    private List<Profile> profiles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_workgroup_service_provider1);

        globalVariables = (GlobalVariables) getApplicationContext();
        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        fetchProfiles();

        sellers_list = findViewById(R.id.sellers_li);


        sellers_list.setLayoutManager(new LinearLayoutManager(this));

        sellerList = new ArrayList<>();

        profiles=new ArrayList<>();

        //getting from back
        // todo return it
       //apiService = RetrofitInstance.getRetrofitInstance(globalVariables.getToken()).create(ApiService.class);

        sellers_list.setLayoutManager(new LinearLayoutManager(this));
        sellerAdapter = new SellerAdapter(this, sellerList, this);
        sellers_list.setAdapter(sellerAdapter);

        // Call fetchProfiles to populate data
        fetchProfiles();
    }


    private void fetchProfiles() {
        Call<ProfilesResponse> call = apiService.getProfiles();
        call.enqueue(new Callback<ProfilesResponse>() {
            @Override
            public void onResponse(Call<ProfilesResponse> call, Response<ProfilesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    profiles = response.body().getProfiles();
                }
            }

            @Override
            public void onFailure(Call<ProfilesResponse> call, Throwable t) {
                // Handle the error
            }
        });
    }
    @Override
    public void onSellerClick(int position) {
        // todo get from back the id and handle

        globalVariables.setSellerid(1);
        globalVariables.setSellerhandle("Anas_Da");
        //todo to profile
        Toast.makeText(this, "Item " + position,Toast.LENGTH_SHORT).show();
        Intent i=new Intent(SellerList_SingleWorkGroup.this,AccountServiceProvider.class);
        startActivity(i);
    }
}