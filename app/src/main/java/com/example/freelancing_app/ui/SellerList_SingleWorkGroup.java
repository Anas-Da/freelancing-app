package com.example.freelancing_app.ui;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    private RecyclerView sellers_list;
    private SellerAdapter sellerAdapter;
    private List<Seller> sellerList;

    private ApiService apiService;
    private List<Profile> profiles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_workgroup_service_provider1);


        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        fetchProfiles();

        sellers_list = findViewById(R.id.sellers_li);
        sellers_list.setLayoutManager(new LinearLayoutManager(this));

        sellerList = new ArrayList<>();
        //todo get them from the backEnd and display them
        for (int i = 0; i < profiles.size(); i++){
            Profile x= profiles.get(i);
            String base64Image = x.getImg();
            Bitmap bitmap = ImageUtils.decodeBase64ToBitmap(base64Image);
            sellerList.add(new Seller(x.getFirstName() + " " + x.getSecondName(),bitmap,x.getWorkGroup()));
        }
        sellerAdapter = new SellerAdapter(this,sellerList,this);
        sellers_list.setAdapter(sellerAdapter);

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

    }
}