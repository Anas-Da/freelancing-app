package com.example.freelancing_app;


import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class SignInActivity extends AppCompatActivity {
    private EditText email_et;
    private EditText password_et;
    private Button SignIn_b;
    private ImageView eye_b;
    private TextView SignUp_tv;
    private RadioButton ServiceProvider_rb;
    private RadioButton Customer_rb;
    private  boolean isPasswordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page1_1);
        email_et = findViewById(R.id.email_et);
        password_et = findViewById(R.id.password_et);
        SignIn_b =  findViewById(R.id.SignIn_b);
        SignUp_tv = findViewById(R.id.SignUp_tv);
        Customer_rb = findViewById(R.id.Customer_rb);
        ServiceProvider_rb = findViewById(R.id.ServiceProvider_rb);
        eye_b = findViewById(R.id.eye_b);
        isPasswordVisible = false;
        eye_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPasswordVisible = !isPasswordVisible;
                if(isPasswordVisible){
                    password_et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }else{
                    password_et.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });

        SignIn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO going to Home for customer and service provider not that Activity
                String email = email_et.getText().toString();
                String password = password_et.getText().toString();
                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(SignInActivity.this,
                            "Enter Both Email and password", Toast.LENGTH_SHORT).show();
                }else{
                    if(!check(password,email)){
                        Toast.makeText(SignInActivity.this,
                                "Wrong Email or Password,\nPlease try again", Toast.LENGTH_SHORT).show();
                        email_et.getText().clear();
                        password_et.getText().clear();
                    }else{
                        if(Customer_rb.isChecked()){
                            Intent i=new Intent(SignInActivity.this,SignInActivity_2.class);
                            i.putExtra("isCustomer",true);
                            startActivity(i);
                        }else if(ServiceProvider_rb.isChecked()){
                            Intent i=new Intent(SignInActivity.this,SignInActivity_2.class);
                            i.putExtra("isCustomer",false);
                            startActivity(i);
                        }else{
                            Toast.makeText(SignInActivity.this,
                                    "Select ServiceProvider or customer", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        SignUp_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO go to signup page
                Intent i=new Intent(SignInActivity.this,SignInActivity_2.class);
                startActivity(i);
            }
        });
    }
    boolean check(String password,String email){
        // TODO query to Database to check the Email/Password
         return true;
    }
}
