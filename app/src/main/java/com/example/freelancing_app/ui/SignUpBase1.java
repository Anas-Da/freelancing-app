package com.example.freelancing_app.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancing_app.models.SignUpRequest;
import com.example.freelancing_app.utils.GlobalVariables;
import com.example.freelancing_app.R;

public class SignUpBase1 extends AppCompatActivity {

    TextView create_tv;

    EditText firstname_et;
    EditText secondname_et;
    EditText username_et;
    EditText email_et;
    EditText password_et;
    EditText confirm_password_et;
    EditText date_of_birth_et;
    EditText country_et;
    EditText phone_number_et;
    Button next_b;
    Button back_b;
    boolean isCustomer;
    GlobalVariables globalVariables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page1both);
        globalVariables = (GlobalVariables) getApplicationContext();

        create_tv = findViewById(R.id.create_account_tv);

        isCustomer = globalVariables.isCustomer();
        if(isCustomer){
            create_tv.setText(R.string.create_customer_account);
        }else{
            create_tv.setText(R.string.create_service_provider_account);
        }

        firstname_et = findViewById(R.id.firstname_et);
        secondname_et = findViewById(R.id.lastname_et);
        username_et         = findViewById(R.id.username_et);
        email_et            = findViewById(R.id.email_et);
        password_et         = findViewById(R.id.password_et);
        confirm_password_et = findViewById(R.id.confirm_password_et);
        date_of_birth_et    = findViewById(R.id.date_of_birth_et);
        country_et          = findViewById(R.id.country_et);
        phone_number_et     = findViewById(R.id.phone_number_et);
        next_b              = findViewById(R.id.next_b);
        back_b              = findViewById(R.id.back_b);

        next_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check()){
                    Intent i;
                    if(isCustomer){
                        i = new Intent(SignUpBase1.this, SignUpBase3.class);
                    }else{
                        i = new Intent(SignUpBase1.this, SignUpServiceProvider2.class);
                    }
                    startActivity(i);
                }
            }
        });
        back_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    boolean check(){
        if(firstname_et        .getText().toString().isEmpty())return false;
        if(secondname_et        .getText().toString().isEmpty())return false;
        if(username_et        .getText().toString().isEmpty())return false;
        if(email_et           .getText().toString().isEmpty())return false;
        if(password_et        .getText().toString().isEmpty())return false;
        if(confirm_password_et.getText().toString().isEmpty())return false;
        if(!password_et.getText().toString().equals(confirm_password_et.getText().toString()))return false;
        if(date_of_birth_et   .getText().toString().isEmpty())return false;
        if(country_et         .getText().toString().isEmpty())return false;
        if(phone_number_et    .getText().toString().isEmpty())return false;
        globalVariables.setSignUpRequest(
                new SignUpRequest(username_et.getText().toString(),
                        firstname_et.getText().toString(),secondname_et.getText().toString(),
                        country_et.getText().toString(),date_of_birth_et.getText().toString(),
                        email_et.getText().toString(),phone_number_et.getText().toString(),
                        password_et.getText().toString(),confirm_password_et.getText().toString()
                ));
        return true;
    }
}
