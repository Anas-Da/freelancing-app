package com.example.freelancing_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChoosingWorkgroup extends AppCompatActivity implements View.OnClickListener,
        ProfessionAdapter.OnItemClickListener {

    private Button next_b;
    private ImageButton back_b;
    GlobalVariables globalVariables;
    private RecyclerView workgroup_list;
    private RecyclerView sellers_list;
    private ProfessionAdapter professionAdapter;
    private List<Profession> professionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosing_workgroup_service_provider1);

        next_b = findViewById(R.id.next_b);
        back_b = findViewById(R.id.back_b);

        next_b.setOnClickListener(this);

        back_b.setOnClickListener(this);

        globalVariables= (GlobalVariables) getApplicationContext();

        workgroup_list = findViewById(R.id.workgroup_list);
        workgroup_list.setLayoutManager(new GridLayoutManager(this, 2));



        professionList = new ArrayList<>();
        professionList.add(new Profession("Doctor", R.drawable.doctor));
        professionList.add(new Profession("Doctor", R.drawable.doctor));
        professionList.add(new Profession("Doctor", R.drawable.doctor));
        professionList.add(new Profession("Doctor", R.drawable.doctor));
        professionList.add(new Profession("Doctor", R.drawable.doctor));
        professionList.add(new Profession("Doctor", R.drawable.doctor));
        /*
        professionList.add(new com.example.test_fla.Profession("interior  designer", R.drawable.interior_design));
        professionList.add(new com.example.test_fla.Profession("Translator", R.drawable.Translator));
        professionList.add(new com.example.test_fla.Profession("architecture engineer", R.drawable.architect));
        professionList.add(new com.example.test_fla.Profession("Teacher", R.drawable.Teacher));
        professionList.add(new com.example.test_fla.Profession("it engineer", R.drawable.IT));
        professionList.add(new com.example.test_fla.Profession("Lawyer", R.drawable.Lawyer));
        professionList.add(new com.example.test_fla.Profession("Designer", R.drawable.Designer));
         */

        professionAdapter = new ProfessionAdapter(this, professionList,this);
        workgroup_list.setAdapter(professionAdapter);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.next_b){
            //TODO change destination
            Intent i=new Intent(ChoosingWorkgroup.this,Home.class);
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