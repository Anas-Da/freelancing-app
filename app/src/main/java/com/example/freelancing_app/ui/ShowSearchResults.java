package com.example.freelancing_app.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.SearchResults;
import com.example.freelancing_app.adapters.UserAdapter;

import java.util.ArrayList;
public class ShowSearchResults extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private ArrayList<SearchResults.User> userList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_results); // Make sure this matches your layout name

        recyclerView = findViewById(R.id.search_li);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Receiving the user list from the intent
        userList = getIntent().getParcelableArrayListExtra("userList");

        // Setting up the adapter
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
    }
}
