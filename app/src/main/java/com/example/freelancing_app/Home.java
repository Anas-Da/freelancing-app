package com.example.freelancing_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity implements View.OnClickListener,
        SellerAdapter.OnItemClickListener,ProfessionAdapter.OnItemClickListener  {

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
        //todo get them from the backEnd and display them
        for(int i=0;i<100;i++){
            professionList.add(new Profession("JOB "+ i, R.drawable.doctor));
        }
        professionAdapter = new ProfessionAdapter(this, professionList,this);
        workgroup_list.setAdapter(professionAdapter);


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
    public void onClick(View v) {
        //TODO go to the right places
        if(v.getId()==R.id.account_ib){
            Intent i=new Intent(Home.this,AccountServiceProvider.class);
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
