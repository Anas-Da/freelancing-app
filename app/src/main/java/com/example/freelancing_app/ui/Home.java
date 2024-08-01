package com.example.freelancing_app.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancing_app.network.ApiService;
import com.example.freelancing_app.utils.GlobalVariables;
import com.example.freelancing_app.utils.ImageUtils;
import com.example.freelancing_app.adapters.ProfessionAdapter;
import com.example.freelancing_app.network.ProfilesResponse;
import com.example.freelancing_app.R;
import com.example.freelancing_app.network.RetrofitInstance;
import com.example.freelancing_app.models.Seller;
import com.example.freelancing_app.adapters.SellerAdapter;
import com.example.freelancing_app.models.Profession;
import com.example.freelancing_app.models.Profile;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity implements View.OnClickListener,
        SellerAdapter.OnItemClickListener, ProfessionAdapter.OnItemClickListener {

    private ApiService apiService;
    private EditText search_et;
    private ImageButton account_ib;
    private ImageButton chat_ib;
    GlobalVariables globalVariables;
    private RecyclerView workgroup_list;
    private RecyclerView sellers_list;
    private ProfessionAdapter professionAdapter;
    private SellerAdapter sellerAdapter;
    private List<Profession> professionList;
    private List<Seller> sellerList;
    private List<Profile> profiles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        search_et = findViewById(R.id.search_et);
        account_ib = findViewById(R.id.account_ib);
        chat_ib = findViewById(R.id.chat_ib);
        search_et.setOnClickListener(this);
        account_ib.setOnClickListener(this);
        chat_ib.setOnClickListener(this);

        globalVariables= (GlobalVariables) getApplicationContext();

        workgroup_list = findViewById(R.id.workgroup_list);
        workgroup_list.setLayoutManager(new GridLayoutManager(this, 4));

        professionList = new ArrayList<>();
        String[] professionNames = {
                "Doctor",
                "Designer",
                "Architecture",
                "Teacher",
                "Interior Designer",
                "IT Engineer",
                "Translator",
                "Lawyer"
        };
        int[] professionImages = {
                R.drawable.doctor_img,
                R.drawable.design_img,
                R.drawable.arc_img,
                R.drawable.teach_img,
                R.drawable.interior_img,
                R.drawable.it_engineer_img,
                R.drawable.translator_img,
                R.drawable.law_img
        };
        //todo get them from the backEnd and display them
        for(int i=0;i<8;i++){
            professionList.add(new Profession( professionNames[i], professionImages[i]));
        }
        professionAdapter = new ProfessionAdapter(this, professionList,this);
        workgroup_list.setAdapter(professionAdapter);


        sellers_list = findViewById(R.id.sellers_li);


        sellers_list.setLayoutManager(new LinearLayoutManager(this));

        sellerList = new ArrayList<>();

        profiles=new ArrayList<Profile>();

        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
/*
         fetchProfiles();

        //todo get them from the backEnd and display them
        for (int i = 0; i < profiles.size(); i++){
            Profile x= profiles.get(i);
            String base64Image = x.getImg();
            Bitmap bitmap = ImageUtils.decodeBase64ToBitmap(base64Image);
            sellerList.add(new Seller(x.getFirstName() + " " + x.getSecondName(),bitmap,x.getWorkGroup()));
        }
        sellerAdapter = new SellerAdapter(this,sellerList,this);
        sellers_list.setAdapter(sellerAdapter);
            */
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

                    // Update the sellerList and notify the adapter
                    updateSellerList();
                } else {
                    // Handle the case when the response is not successful
                    Toast.makeText(Home.this, "Failed to fetch profiles", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProfilesResponse> call, Throwable t) {
                // Handle the error
                Toast.makeText(Home.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateSellerList() {
        sellerList.clear(); // Clear the current list
        for (Profile profile : profiles) {
            String base64Image = profile.getImg();
            Bitmap bitmap = ImageUtils.decodeBase64ToBitmap(base64Image);
            sellerList.add(new Seller(profile.getFirstName() + " " + profile.getSecondName(), bitmap, profile.getWorkGroup()));
        }
        Toast.makeText(Home.this, "Updated", Toast.LENGTH_SHORT).show();
        sellerAdapter.notifyDataSetChanged(); // Notify the adapter of data changes
    }

    @Override
    public void onClick(View v) {
        //TODO go to the right places
        if(v.getId()==R.id.account_ib){
            Intent i=new Intent(Home.this, AccountServiceProvider.class);
            startActivity(i);
        }else if (v.getId()==R.id.chat_ib){
            /*
            Intent i=new Intent(Home.this,AccountServiceProvider.class);
            startActivity(i);
             */
        }else if(v.getId()==R.id.search_et){
            /*
            Intent i=new Intent(Home.this,AccountServiceProvider.class);
            startActivity(i);
             */
        }else{
            globalVariables.setJob(v.getId());
        }

    }
    @Override
    public void onSellerClick(int position) {
        // todo get from back the id and handle

        globalVariables.setSellerid(1);
        globalVariables.setSellerhandle("Anas_Da");
        //todo to profile
        Toast.makeText(this, "Item " + position,Toast.LENGTH_SHORT).show();
        Intent i=new Intent(Home.this,AccountServiceProvider.class);
        startActivity(i);
    }
    @Override
    public void onProfessionClick(int position) {
        // todo get from back the id and handle

        globalVariables.setWorkGroup(0);
        //todo to profile
        Toast.makeText(this, "Item " + position,Toast.LENGTH_SHORT).show();
        Intent i=new Intent(Home.this, SellerList_SingleWorkGroup.class);
        startActivity(i);
    }
}
