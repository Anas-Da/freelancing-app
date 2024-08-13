package com.example.freelancing_app.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancing_app.R;
import com.example.freelancing_app.adapters.ProfessionAdapter;
import com.example.freelancing_app.adapters.SellerAdapter;
import com.example.freelancing_app.models.Profession;
import com.example.freelancing_app.models.Profile;
import com.example.freelancing_app.models.Seller;
import com.example.freelancing_app.network.ApiService;
import com.example.freelancing_app.network.ProfilesResponse;
import com.example.freelancing_app.network.RetrofitInstance;
import com.example.freelancing_app.utils.GlobalVariables;
import com.example.freelancing_app.utils.ImageUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity implements View.OnClickListener,
        SellerAdapter.OnItemClickListener, ProfessionAdapter.OnItemClickListener {

    private ApiService apiService;
    private ImageButton account_ib;
    private ImageButton chat_ib;
    GlobalVariables globalVariables;
    private ProfessionAdapter professionAdapter;
    private RecyclerView profession_list;
    private List<Profession> professionList;
    private SellerAdapter sellerAdapter;
    private RecyclerView sellers_list;
    private List<Seller> sellerList;
    private List<Profile> profiles;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        account_ib = findViewById(R.id.account_ib);
        chat_ib = findViewById(R.id.chat_ib);
        relativeLayout = findViewById(R.id.relativeLayout);
        account_ib.setOnClickListener(this);
        chat_ib.setOnClickListener(this);
        relativeLayout.setOnClickListener(this);

        globalVariables = (GlobalVariables) getApplicationContext();

        profession_list = findViewById(R.id.workgroup_list);
        profession_list.setLayoutManager(new GridLayoutManager(this, 4));

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

        for (int i = 0; i < 8; i++) {
            professionList.add(new Profession(professionNames[i], professionImages[i]));
        }

        professionAdapter = new ProfessionAdapter(this, professionList, this);
        profession_list.setAdapter(professionAdapter);

        sellers_list = findViewById(R.id.sellers_li);
        sellers_list.setLayoutManager(new LinearLayoutManager(this));

        sellerList = new ArrayList<>();
        profiles = new ArrayList<>();

        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);

        sellerAdapter = new SellerAdapter(this, sellerList, this);
        sellers_list.setAdapter(sellerAdapter);

        Bitmap SS = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.michael_3);
        Bitmap MM = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.michael_4);
        Bitmap LL = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.michael_5);
        Bitmap RR = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.michael_2);
        sellerList.add(new Seller("Sdra" + " " + "Al_Kusaier", SS, "Intereor_Designer"));
        sellerList.add(new Seller("Mais" + " " + "Safadly", MM, "IT"));
        sellerList.add(new Seller("Lina" + " " + "Al_Rashid", LL, "Translator"));
        sellerList.add(new Seller("Mais" + " " + "Safadly", MM, "Lawyer"));
        sellerList.add(new Seller("Rani" + " " + "Ali", RR, "IT"));

        // TODO
        // fetchProfiles();
    }

    private void fetchProfiles() {
        Call<ProfilesResponse> call = apiService.getProfiles();
        call.enqueue(new Callback<ProfilesResponse>() {
            @Override
            public void onResponse(Call<ProfilesResponse> call, Response<ProfilesResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    profiles = response.body().getProfiles();
                    updateSellerList(); // Method to update list and notify adapter
                } else {
                    Toast.makeText(Home.this, "Failed to fetch profiles", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProfilesResponse> call, Throwable t) {
                Toast.makeText(Home.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateSellerList() {
        sellerList.clear();
        for (Profile profile : profiles) {
            String base64Image = profile.getImg();
            Bitmap bitmap = ImageUtils.decodeBase64ToBitmap(base64Image);
            sellerList.add(new Seller(profile.getFirstName() + " " + profile.getSecondName(), bitmap, profile.getWorkGroup()));
        }
        Toast.makeText(Home.this, "Updated", Toast.LENGTH_SHORT).show();
        sellerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.account_ib) {
            if(globalVariables.isCustomer()){
                Intent i = new Intent(Home.this, AccountCustomer.class);
                startActivity(i);
            }else {
                Intent i = new Intent(Home.this, AccountServiceProvider.class);
                startActivity(i);
            }
        } else if (v.getId() == R.id.chat_ib) {
            Intent i = new Intent(Home.this, ChatList.class);
            startActivity(i);
        } else if (v.getId() == R.id.relativeLayout) {
            Intent i = new Intent(Home.this, Search.class);
            startActivity(i);
        } else {
            globalVariables.setJob(v.getId());
        }
    }

    @Override
    public void onSellerClick(int position) {
        globalVariables.setSellerid(1);
        globalVariables.setSellerhandle("Anas_Da");
        //Toast.makeText(this, "Item " + position, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Home.this, ProfileServiceProviderAboutCustomer.class);
        startActivity(i);
    }

    @Override
    public void onProfessionClick(int position) {
        globalVariables.setWorkGroup(position);
        //Toast.makeText(this, "Item " + position, Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Home.this, SellerList_SingleWorkGroup.class);
        startActivity(i);
    }
}
