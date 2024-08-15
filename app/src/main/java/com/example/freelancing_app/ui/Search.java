package com.example.freelancing_app.ui;

import static com.example.freelancing_app.network.RetrofitInstance.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.SearchResults;
import com.example.freelancing_app.network.ApiService;
import com.example.freelancing_app.utils.GlobalVariables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Search extends AppCompatActivity {
    GlobalVariables globalVariables;
    ApiService apiService;

    EditText firstname_et;
    EditText secondname_et;
    EditText username_et;
    EditText rating_et;
    EditText workgroup_et;

    CheckBox is_active;

    Button show_results_b;
    ImageButton back_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Initialize UI components
        firstname_et = findViewById(R.id.firstname_et);
        secondname_et = findViewById(R.id.lastname_et);
        username_et = findViewById(R.id.username_et);
        rating_et = findViewById(R.id.rating_et);
        workgroup_et = findViewById(R.id.workgroup_et);
        is_active = findViewById(R.id.is_active);
        show_results_b = findViewById(R.id.show_results_b);
        back_b = findViewById(R.id.back_b);

        // Back button logic
        back_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Show results button logic
        show_results_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performSearch(); // Call performSearch when the button is clicked
            }
        });

        // Initialize the ApiService (ensure you have retrofit and the service properly configured)
        apiService = retrofit.create(ApiService.class);
    }

    private void performSearch() {
        // Retrieve input values
        String firstName = firstname_et.getText().toString().trim();
        String secondName = secondname_et.getText().toString().trim();
        String username = username_et.getText().toString().trim();
        String rating = rating_et.getText().toString().trim();
        String workgroup = workgroup_et.getText().toString().trim();
        boolean isActive = is_active.isChecked();

        // Ensure at least one search criterion is provided
        if (firstName.isEmpty() && secondName.isEmpty() && username.isEmpty() && rating.isEmpty() && workgroup.isEmpty() && !isActive) {
            Toast.makeText(this, "Please enter at least one search criterion", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create the filter map
        Map<String, Object> filters = new HashMap<>();
        if (!firstName.isEmpty()) filters.put("first_name", firstName);
        if (!secondName.isEmpty()) filters.put("second_name", secondName);
        if (!username.isEmpty()) filters.put("username", username);
        if (!rating.isEmpty()) filters.put("rate", rating);
        if (!workgroup.isEmpty()) filters.put("work_group", workgroup);
        filters.put("active", isActive); // Add the active status filter

        // Make the API call
        Call<SearchResults> call = apiService.searchUsers(filters);
        call.enqueue(new Callback<SearchResults>() {
            @Override
            public void onResponse(Call<SearchResults> call, Response<SearchResults> response) {
                if (response.isSuccessful()) {
                    SearchResults results = response.body();
                    if (results != null) {
                        // Handle search results
                        List<SearchResults.User> userList = results.getUsers();
                        // TODO: Pass the userList to the next activity or display them on the current screen
                        Intent intent = new Intent(Search.this, ShowSearchResults.class);
                        intent.putExtra("userList", new ArrayList<>(userList)); // Assuming userList is serializable or Parcelable
                        startActivity(intent);
                    } else {
                        Toast.makeText(Search.this, "No results found.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Search.this, "Search failed with code: " + response.code(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SearchResults> call, Throwable t) {
                Toast.makeText(Search.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
