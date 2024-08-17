package com.example.freelancing_app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.freelancing_app.adapters.ItemAdapter;
import com.example.freelancing_app.models.Item;
import com.example.freelancing_app.models.WorkGroupsResponse;
import com.example.freelancing_app.network.ApiService;
import com.example.freelancing_app.network.RetrofitInstance;
import com.example.freelancing_app.utils.GlobalVariables;

import com.example.freelancing_app.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChoosingWorkgroup extends AppCompatActivity implements View.OnClickListener{
    private ApiService apiService;
    private Button next_b;
    private ImageButton back_b;
    GlobalVariables globalVariables;
    private RecyclerView workgroup_list;
    private ItemAdapter itemAdapter;
    private List<Item> itemList;
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

        itemList = new ArrayList<>();
      /*  itemList.add(new Item("Item 1", R.drawable.on));
        itemList.add(new Item("Item 2", R.drawable.off));
        itemList.add(new Item("Item 3", R.drawable.on));
        itemList.add(new Item("Item 4", R.drawable.off));
        itemList.add(new Item("Item 5", R.drawable.on));*/

        itemAdapter = new ItemAdapter(itemList, this);
        workgroup_list.setAdapter(itemAdapter);

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
    @SuppressLint("NotifyDataSetChanged")
    void updateLayout(){
        if(res.getResult().contains("Doctor"))
            itemList.add(new Item("Doctor",R.drawable.doctor_img)) ;
        if (res.getResult().contains("Interior Designer"))
            itemList.add(new Item("Interior Designer", R.drawable.interior_img));
        if (res.getResult().contains("Translator"))
            itemList.add(new Item("Translator", R.drawable.translator_img));
        if (res.getResult().contains("Architecture Engineer"))
            itemList.add(new Item("Architecture Engineer", R.drawable.arc_img));
        if (res.getResult().contains("Teacher"))
            itemList.add(new Item("Teacher", R.drawable.teach_img));
        if (res.getResult().contains("IT Engineer"))
            itemList.add(new Item("IT Engineer", R.drawable.it_engineer_img));
        if (res.getResult().contains("Lawyer"))
            itemList.add(new Item("Lawyer", R.drawable.law_img));
        if (res.getResult().contains("Designer"))
            itemList.add(new Item("Designer", R.drawable.design_img));
        itemAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.next_b){
            //TODO change destination
            Intent i=new Intent(ChoosingWorkgroup.this, AccountServiceProvider.class);
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
    public void onItemClick(int position) {
        // todo get from back the id and handle

        globalVariables.setWorkGroup(0);
        //todo to profile
        Toast.makeText(this, "Item " + position,Toast.LENGTH_SHORT).show();

    }
}