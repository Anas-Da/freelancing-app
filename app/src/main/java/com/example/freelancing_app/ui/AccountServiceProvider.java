package com.example.freelancing_app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.freelancing_app.R;
import com.example.freelancing_app.adapters.SellerAdapter;
import com.example.freelancing_app.adapters.UserProfileAdapter;
import com.example.freelancing_app.models.AccountSellerResponse;
import com.example.freelancing_app.models.Profile;
import com.example.freelancing_app.models.ProfileResponse;
import com.example.freelancing_app.models.Seller;
import com.example.freelancing_app.models.UserProfile;
import com.example.freelancing_app.network.ApiService;
import com.example.freelancing_app.network.RetrofitInstance;
import com.example.freelancing_app.utils.GlobalVariables;
import com.example.freelancing_app.utils.ImageUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//TODO backkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
public class AccountServiceProvider extends AppCompatActivity implements
        View.OnClickListener, UserProfileAdapter.OnItemClickListener{

    private ApiService apiService;
    GlobalVariables globalVariables;

    private RecyclerView profiles_li;
    private UserProfileAdapter adapter;
    private List<UserProfile> profileList;

    private ImageButton settings_b;
    private ImageButton add_profile_ib;

    private ImageButton home_ib;
    private  ImageButton chat_ib;

    ImageView profilePicture;
    TextView fullname_tv;

    AccountSellerResponse res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_service_provider1);
        settings_b = findViewById(R.id.settings_b);
        add_profile_ib = findViewById(R.id.add_profile_b);

        home_ib = findViewById(R.id.home_ib);
        chat_ib = findViewById(R.id.chat_ib);

        profilePicture = findViewById(R.id.profilePicture);
        fullname_tv = findViewById(R.id.fullname_tv);

        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        globalVariables = (GlobalVariables) getApplicationContext();
        res = new AccountSellerResponse();


        settings_b.setOnClickListener(this);
        add_profile_ib.setOnClickListener(this);
        home_ib.setOnClickListener(this);
        chat_ib.setOnClickListener(this);


        profiles_li = findViewById(R.id.profiles_li);
        profiles_li.setLayoutManager(new LinearLayoutManager(this));

        profileList = new ArrayList<>();


        Bitmap LL = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.michael_5);
        profileList.add(new UserProfile("Lina Al_Rashid", "Translator", LL, false));
        profileList.add(new UserProfile("Lina Al_Rashid", "Teacher", LL, false));
        profileList.add(new UserProfile("Lina Al_Rashid", "Designer", LL, false));
        profilePicture.setImageBitmap(LL);
        fullname_tv.setText("Lina" + " " + "Al_Rashid");


        adapter = new UserProfileAdapter(this,profileList,this);
        profiles_li.setAdapter(adapter);
        // TODO
      //   fetchAccount();

    }

    private void fetchAccount() {
        String authToken = "Bearer " + globalVariables.getToken();
        Call<AccountSellerResponse> call = apiService.getSellerAccount(authToken);
        call.enqueue(new Callback<AccountSellerResponse>() {
            @Override
            public void onResponse(Call<AccountSellerResponse> call, Response<AccountSellerResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    res = response.body();
                   // updateLayout(); // Method to update list and notify adapter
                } else {
                    Toast.makeText(AccountServiceProvider.this, "Failed to fetch Info", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AccountSellerResponse> call, Throwable t) {
                Toast.makeText(AccountServiceProvider.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void updateLayout(){
        String base64Image = res.getImg();
        Bitmap bitmap = ImageUtils.decodeBase64ToBitmap(base64Image);
        profilePicture.setImageBitmap(bitmap);
        fullname_tv.setText(res.getFirst_name() + " " + res.getSecond_name());
        updateList();
    }

    private void updateList() {
        //TODO

        profileList.clear();
        String base64Image = res.getImg();
        Bitmap bitmap = ImageUtils.decodeBase64ToBitmap(base64Image);
        for (ProfileResponse profile : res.getProfiles()) {
            profileList.add(new UserProfile(res.getFirst_name() + " " + res.getSecond_name(), profile.getWork_group(),bitmap, profile.getChecked()));
        }
        globalVariables.setSeller(res);
        Toast.makeText(AccountServiceProvider.this, "Updated", Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.settings_b){
            Intent intent=new Intent(AccountServiceProvider.this,AccountSettingsServiceProvider.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.add_profile_b){
            Intent intent=new Intent(AccountServiceProvider.this,ChoosingWorkgroup.class);
            startActivity(intent);
        }

        else if (v.getId()==R.id.home_ib){
            Intent intent=new Intent(AccountServiceProvider.this,Home.class);
            startActivity(intent);
        }
        else if (v.getId()==R.id.chat_ib){
            Intent intent=new Intent(AccountServiceProvider.this,ChatList.class);
            startActivity(intent);
        }
    }
    @Override
    public void onCheckBoxClick(int position){
        if (position != RecyclerView.NO_POSITION) {
            UserProfile profile = profileList.get(position);
            profile.setChecked(!profile.isChecked());
            adapter.notifyItemChanged(position);
        }
    }

    @Override
    public void onItemViewClick(int position) {
            if (position != RecyclerView.NO_POSITION) {
                UserProfile profile = profileList.get(position);
                Intent intent = new Intent(AccountServiceProvider.this, ProfileServiceProviderAbout.class);
            //    intent.putExtra("profile", profile);
             //   globalVariables.setProfile(profile);
              //  globalVariables.setProfileid(profile.getProfile_id());
                startActivity(intent);
            }
        }

}
