package com.example.freelancing_app.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
//import androidx.annotation.Nullable;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.freelancing_app.R;


public class AccountSettingsServiceProvider extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener , View.OnClickListener{

    //TODO add change name
    // add Support stuff
    private ImageButton back_b;
    private static final int PICK_IMAGE = 1;
    private RelativeLayout photo_rl;
    private ImageView photo_iv;
    /*
    private TextView name_tv;
    private EditText editname_et;
    private ImageButton name_b ;
    */
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private ImageButton buttonFragmentPassword_b;
    private ImageButton buttonFragmentEmail_b;
    private ImageButton buttonFragmentPhone_b;
    private ImageButton buttonFragmentCountry_b;
    private ImageButton buttonFragmentbirthdate_b;
    private  ImageButton logout_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_settings_service_provider1);

        back_b = findViewById(R.id.back_b);
        photo_rl = findViewById(R.id.photo_rl);
        photo_iv = findViewById(R.id.photo_iv);

        /* name_tv = findViewById(R.id.seller_name_tv);
        editname_et = findViewById(R.id.editname_et);
        name_b = findViewById(R.id.name_b);*/

        photo_rl.setOnClickListener(this);
        // editname_et.setVisibility(View.GONE);
        //pencil_im .setOnClickListener(this);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);

        buttonFragmentPassword_b=findViewById(R.id.password_b);
        buttonFragmentEmail_b=findViewById(R.id.email_b);
        buttonFragmentPhone_b=findViewById(R.id.phone_b);
        buttonFragmentCountry_b=findViewById(R.id.country_b);
        buttonFragmentbirthdate_b=findViewById(R.id.birthdate_b);

        logout_b = findViewById(R.id.logout_b);

        back_b.setOnClickListener(this);
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);

        buttonFragmentPassword_b.setOnClickListener(this);
        buttonFragmentEmail_b.setOnClickListener(this);
        buttonFragmentPhone_b.setOnClickListener(this);
        buttonFragmentCountry_b.setOnClickListener(this);
        buttonFragmentbirthdate_b.setOnClickListener(this);

        logout_b.setOnClickListener(this);

        /*
        editname_et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String newName = editname_et.getText().toString();
                    //TODO Send newName to the backend
                    name_tv.setText(newName);
                    editname_et.setVisibility(View.GONE);
                    nme_tv.setVisibility(View.VISIBLE);
                }
            }
        });
         */


    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView.getId()==R.id.checkBox1)
            setCheckBoxColor(checkBox1, isChecked);
        else  if(buttonView.getId()==R.id.checkBox2)
            setCheckBoxColor(checkBox2, isChecked);
        else  if(buttonView.getId()==R.id.checkBox3)
            setCheckBoxColor(checkBox3, isChecked);


    }

    private void setCheckBoxColor(CheckBox checkBox, boolean isChecked) {
        int colorResId = isChecked ? R.color.checkbox_color : R.color.default_checkbox_color;
        checkBox.setButtonTintList(ContextCompat.getColorStateList(this, colorResId));
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.password_b)
            openFragmentActivity("FRAGMENT_1");
        else if(v.getId()==R.id.email_b)
            openFragmentActivity("FRAGMENT_2");
        else if(v.getId()==R.id.phone_b)
            openFragmentActivity("FRAGMENT_3");
        else if(v.getId()==R.id.country_b)
            openFragmentActivity("FRAGMENT_4");
        else if(v.getId()==R.id.birthdate_b)
            openFragmentActivity("FRAGMENT_5");
        else if(v.getId()==R.id.logout_b)
            showLogoutDialog();
        if(v.getId()==R.id.photo_rl)
            openGallery();
        else if(v.getId()==R.id.back_b)
            destroyInterface();
        /* else if(v.getId()==R.id.name_b) {
             String text = name_tv.getText().toString();
             name_tv.setVisibility(View.GONE);
             editname_et.setVisibility(View.VISIBLE);
             name_tv.setText(text);
         }*/


    }
    private void openFragmentActivity(String fragmentTag) {
        Intent intent = new Intent(AccountSettingsServiceProvider.this, FragmentActivity.class);
        intent.putExtra("FRAGMENT_TAG", fragmentTag);
        startActivity(intent);
    }
    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri selectedImageUri = data.getData();
            photo_iv .setImageURI(selectedImageUri);
            // TODO send the photo to back to save it
        }
    }
    private void showLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to log out?")
                .setPositiveButton("Log out", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Navigate to SignInActivity
                        Intent intent = new Intent(AccountSettingsServiceProvider.this, SignInActivity.class);
                        startActivity(intent);
                        finish(); // This closes the MainActivity
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void destroyInterface() {
        finish();
    }
}
