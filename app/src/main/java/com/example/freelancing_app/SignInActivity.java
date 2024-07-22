package com.example.freelancing_app;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class SignInActivity extends AppCompatActivity {
    private EditText email_et;
    private EditText password_et;
    private Button SignIn_b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page1_1);
        email_et = findViewById(R.id.email_et);
        password_et = findViewById(R.id.password_et);
        SignIn_b =  findViewById(R.id.SignIn_b);
        SignIn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = email_et.getText().toString();
                String password = password_et.getText().toString();
                if(email.length()==0||password.length()==0){
                    Toast.makeText(SignInActivity.this,
                            "Enter Both Email and password", Toast.LENGTH_SHORT).show();
                }else{
                    Intent i=new Intent(SignInActivity.this,SignInActivity_2.class);
                    startActivity(i);
                }
            }
        });
    }

}
