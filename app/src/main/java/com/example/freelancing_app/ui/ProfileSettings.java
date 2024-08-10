package com.example.freelancing_app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancing_app.R;
import com.example.freelancing_app.utils.GlobalVariables;

public class ProfileSettings extends AppCompatActivity implements View.OnClickListener {


    ImageButton bio_b;
    ImageButton language_b;
    ImageButton back_b;
    Button save_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile_settings);

        bio_b = findViewById(R.id.bio_b);
        language_b = findViewById(R.id.language_b);
        back_b = findViewById(R.id.back_b);
        save_b = findViewById(R.id.save_b);
        bio_b.setOnClickListener(this);
        language_b.setOnClickListener(this);
        back_b.setOnClickListener(this);
        save_b.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.bio_b)
            openFragmentActivity("FRAGMENT_7");
      // todo : Need to decide-->
            //  else if (v.getId()==R.id.language_b);
        else if (v.getId()==R.id.back_b)
            destroyInterface();
        //todo : send information to back
           //  else if (v.getId()==R.id.save_b)


    }
    private void openFragmentActivity(String fragmentTag) {
        Intent intent = new Intent(ProfileSettings.this, FragmentActivity.class);
        intent.putExtra("FRAGMENT_TAG", fragmentTag);
        startActivity(intent);
    }
    private void destroyInterface() {
        finish();
    }
}

