package com.example.freelancing_app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.freelancing_app.R;
import com.example.freelancing_app.fragments.EditableFragment;
import com.example.freelancing_app.fragments.Fragment1;
import com.example.freelancing_app.fragments.Fragment2;
import com.example.freelancing_app.fragments.Fragment3;
import com.example.freelancing_app.fragments.Fragment4;
import com.example.freelancing_app.fragments.Fragment5;
import com.example.freelancing_app.fragments.Fragment6;


public class FragmentActivityCustomer extends AppCompatActivity {

    private Button save_changes_b;
    private  Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing_account_preferences);

        save_changes_b = findViewById(R.id.save_changes_b);

        String fragmentTag = getIntent().getStringExtra("FRAGMENT_TAG");
        if (fragmentTag != null) {
            fragment = null;
        }

        if (fragmentTag.equals("FRAGMENT_1")){
            //Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
            fragment = new Fragment1();
        }else if (fragmentTag.equals("FRAGMENT_2")) {
            //Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
            fragment = new Fragment2();
        } else if (fragmentTag.equals("FRAGMENT_3")) {
            //Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
            fragment = new Fragment3();
        } else if (fragmentTag.equals("FRAGMENT_4")) {
            //Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
            fragment = new Fragment4();
        } else if (fragmentTag.equals("FRAGMENT_5")) {
            //Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
            fragment = new Fragment5();
        }
        else if (fragmentTag.equals("FRAGMENT_6")) {
            Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
            fragment = new Fragment6();
        }
        //Toast.makeText(this, "0", Toast.LENGTH_SHORT).show();

        if (fragment != null) {
            loadFragment(fragment);
        }


        save_changes_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }
    private void loadFragment(Fragment fragment) {
        // Create Transaction for Fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
    private void saveData() {
        if (fragment instanceof EditableFragment) {
            String text = ((EditableFragment) fragment).getEditableText();
            if (text.isEmpty()) {
                Toast.makeText(this, "Editable text is empty and must be filled", Toast.LENGTH_SHORT).show();
            } else {
                // Return to MainActivity
                Intent intent = new Intent(FragmentActivityCustomer.this, AccountSettingsCustomer.class);
                startActivity(intent);
                finish();
            }
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}