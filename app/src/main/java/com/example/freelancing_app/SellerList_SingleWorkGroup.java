package com.example.freelancing_app;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SellerList_SingleWorkGroup extends AppCompatActivity implements SellerAdapter.OnItemClickListener{

    private RecyclerView sellers_list;
    private SellerAdapter sellerAdapter;
    private List<Seller> sellerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_workgroup_service_provider1);


        sellers_list = findViewById(R.id.sellers_li);
        sellers_list.setLayoutManager(new LinearLayoutManager(this));

        sellerList = new ArrayList<>();
        //todo get them from the backEnd and display them
        for(int i=0;i<100;i++){
            sellerList.add(new Seller("seller",R.drawable.account_img_small,"doctor"));
        }
        sellerAdapter = new SellerAdapter(this,sellerList,this);
        sellers_list.setAdapter(sellerAdapter);

    }


    @Override
    public void onSellerClick(int position) {

    }
}