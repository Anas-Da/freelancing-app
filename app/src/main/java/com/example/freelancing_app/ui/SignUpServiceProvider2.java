package com.example.freelancing_app.ui;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancing_app.R;
import com.example.freelancing_app.utils.GlobalVariables;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class SignUpServiceProvider2  extends AppCompatActivity {

    String name1,name2;
    String to641=null,to642=null;
    CheckBox checkBox1,checkBox2,checkBox3;
    private static final int PICK_IMAGE = 1;
    int b=1;
    boolean usdt=false,al_haram=false,syriatel_cash=false;
    RelativeLayout frontface_file,backside_file;
    TextView backface_tv,frontface_tv;
    GlobalVariables globalVariables;
    Button back_b,next_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page2service_provider);
        globalVariables = (GlobalVariables) getApplicationContext();
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        backface_tv  = findViewById(R.id.backface_tv);
        frontface_tv = findViewById(R.id.frontface_tv);
        frontface_file = findViewById(R.id.frontface_file);
        backside_file  = findViewById(R.id.backside_file);
        back_b = findViewById(R.id.back_b);
        next_b = findViewById(R.id.next_b);
        frontface_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=1;
                openGallery();
                frontface_tv.setText(name1);
            }
        });
        backside_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=2;
                openGallery();
                backface_tv.setText(name2);
            }
        });
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                al_haram=isChecked;
            }
        });
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                syriatel_cash=isChecked;
            }
        });
        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                usdt=isChecked;
            }
        });
        back_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        next_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                globalVariables.getSignUpRequest().setAl_haram(al_haram);
                globalVariables.getSignUpRequest().setSyriatel_cash(syriatel_cash);
                globalVariables.getSignUpRequest().setUsdt(usdt);
                globalVariables.getSignUpRequest().setId_picture(to641);
                globalVariables.getSignUpRequest().setId_picture2(to642);
                Intent i = new Intent(SignUpServiceProvider2.this,SignUpBase3.class);
                startActivity(i);
            }
        });

    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            if(b==1)name1 = getImageName(imageUri);
            if(b==2)name2 = getImageName(imageUri);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                byte[] imageBytes = bitmapToByteArray(bitmap);
                String base64String = encodeImageToBase64(imageBytes);
                if(b==1)to641 = base64String;
                if(b==2)to642 = base64String;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private String encodeImageToBase64(byte[] imageBytes) {
        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }
    private String getImageName(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DISPLAY_NAME };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        String imageName = "Unknown";
        if (cursor != null && cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DISPLAY_NAME);
            imageName = cursor.getString(columnIndex);
            cursor.close();
        }
        return imageName;
    }
}
