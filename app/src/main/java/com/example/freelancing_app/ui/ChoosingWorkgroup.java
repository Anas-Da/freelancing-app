package com.example.freelancing_app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.freelancing_app.models.WorkGroupsResponse;
import com.example.freelancing_app.network.ApiService;
import com.example.freelancing_app.network.RetrofitInstance;
import com.example.freelancing_app.utils.GlobalVariables;
import com.example.freelancing_app.adapters.ProfessionAdapter;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.Profession;
import com.example.freelancing_app.utils.ImageUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChoosingWorkgroup extends AppCompatActivity implements View.OnClickListener,
        ProfessionAdapter.OnItemClickListener {
    private ApiService apiService;
    private Button next_b;
    private ImageButton back_b;
    GlobalVariables globalVariables;
    private RecyclerView workgroup_list;
    private RecyclerView sellers_list;
    private ProfessionAdapter professionAdapter;
    private List<Profession> professionList;
    WorkGroupsResponse res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_workgroup_service_provider1);

        next_b = findViewById(R.id.next_b);
        back_b = findViewById(R.id.back_b);

        next_b.setOnClickListener(this);

        back_b.setOnClickListener(this);

        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        globalVariables= (GlobalVariables) getApplicationContext();

        workgroup_list = findViewById(R.id.workgroup_list);
        workgroup_list.setLayoutManager(new GridLayoutManager(this, 2));



        professionList = new ArrayList<>();

        professionAdapter = new ProfessionAdapter(this, professionList,this);
        workgroup_list.setAdapter(professionAdapter);

        fetchWorkGroup();

    }

    private void fetchWorkGroup() {
        String authToken = "Bearer " + globalVariables.getToken();
        Call<WorkGroupsResponse> call = apiService.getWorkGroups(authToken);
        call.enqueue(new Callback<WorkGroupsResponse>() {
            @Override
            public void onResponse(Call<WorkGroupsResponse> call, Response<WorkGroupsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Toast.makeText(ChoosingWorkgroup.this, "connection done", Toast.LENGTH_SHORT).show();
                    res = response.body();
                    updateLayout();
                } else {
                    Toast.makeText(ChoosingWorkgroup.this, "Failed to fetch Info", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<WorkGroupsResponse> call, Throwable t) {
                Toast.makeText(ChoosingWorkgroup.this, t.toString(), Toast.LENGTH_SHORT).show();
            }

        });
    }

    void updateLayout(){
        if(res.getResult().contains("Doctor"))
            professionList.add(new Profession("Doctor",R.drawable.design_img)) ;
        if (res.getResult().contains("Interior Designer"))
            professionList.add(new Profession("Interior Designer", R.drawable.interior_img));
        if (res.getResult().contains("Translator"))
            professionList.add(new Profession("Translator", R.drawable.translator_img));
        if (res.getResult().contains("Architecture Engineer"))
            professionList.add(new Profession("Architecture Engineer", R.drawable.arc_img));
        if (res.getResult().contains("Teacher"))
            professionList.add(new Profession("Teacher", R.drawable.teach_img));
        if (res.getResult().contains("IT Engineer"))
            professionList.add(new Profession("IT Engineer", R.drawable.it_engineer_img));
        if (res.getResult().contains("Lawyer"))
            professionList.add(new Profession("Lawyer", R.drawable.law_img));
        if (res.getResult().contains("Designer"))
            professionList.add(new Profession("Designer", R.drawable.design_img));
        professionAdapter.notifyDataSetChanged();

    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.next_b){
            //TODO change destination
            Intent i=new Intent(ChoosingWorkgroup.this, Home.class);
            startActivity(i);
        } else if (view.getId()==R.id.back_b) {
            onBackPressed();
        } else{
            globalVariables.setJob(view.getId());
        }
    }
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public void onProfessionClick(int position) {
        // todo get from back the id and handle

        globalVariables.setWorkGroup(0);
        //todo to profile
        Toast.makeText(this, "Item " + position,Toast.LENGTH_SHORT).show();
        Intent i=new Intent(ChoosingWorkgroup.this, SellerList_SingleWorkGroup.class);
        startActivity(i);
    }
}