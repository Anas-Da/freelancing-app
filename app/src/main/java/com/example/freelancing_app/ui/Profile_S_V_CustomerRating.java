package com.example.freelancing_app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.freelancing_app.R;
import com.example.freelancing_app.adapters.CommentsAdapter;
import com.example.freelancing_app.models.Comment;
import com.example.freelancing_app.models.ReviewList;
import com.example.freelancing_app.models.ReviewsResponse;
import com.example.freelancing_app.network.ApiService;
import com.example.freelancing_app.network.RetrofitInstance;
import com.example.freelancing_app.utils.GlobalVariables;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//TODO bACKkkkkkkkkkkkkkkkkkk
public class Profile_S_V_CustomerRating extends AppCompatActivity   implements View.OnClickListener{

    private ApiService apiService;
    GlobalVariables globalVariables;
    private ImageView back_b;

    private Button about_b;
    private Button  Rating_b;

    private  ImageButton account_ib;
    private  ImageButton home_ib;
    private  ImageButton chat_ib;
    private RecyclerView comments_iv;
    private CommentsAdapter commentsAdapter;
    private List<Comment> commentList;
    private  List <ReviewList> reviewLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_s_v_customer_rating);

        back_b=findViewById(R.id.back_b);
        about_b=findViewById(R.id.about_b);
        Rating_b=findViewById(R.id.Rating_b);
        account_ib=findViewById(R.id.account_ib);
        home_ib=findViewById(R.id.home_ib);
        chat_ib=findViewById(R.id.chat_ib);

        globalVariables = (GlobalVariables) getApplicationContext();
        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);

        reviewLists = new ArrayList<>();

        back_b.setOnClickListener(this);
        about_b.setOnClickListener(this);
        Rating_b.setOnClickListener(this);
        account_ib.setOnClickListener(this);
        home_ib.setOnClickListener(this);
        chat_ib.setOnClickListener(this);

        comments_iv = findViewById(R.id.comments_iv);
        comments_iv.setLayoutManager(new LinearLayoutManager(this));

        commentList = new ArrayList<>();
         commentList.add(new Comment("John Doe", R.drawable.yellow_star, "Great product!", 5));
         commentList.add(new Comment("Jane Smith",R.drawable.yellow_star , "Not bad, but could be better.", 3));
        commentsAdapter = new CommentsAdapter(commentList, this);
        comments_iv .setAdapter(commentsAdapter);



    //    fetchReview();
    }
    private void fetchReview(){

        Call<ReviewsResponse> call = apiService.getReviews(globalVariables.getUsername(),String.valueOf(globalVariables.getProfileid()));
        call.enqueue(new Callback<ReviewsResponse>() {
            @Override
            public void onResponse(Call<ReviewsResponse> call, Response<ReviewsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    reviewLists = response.body().getResult();
                //    updateLayout();
                } else {
                    Toast.makeText(Profile_S_V_CustomerRating.this, "Failed to fetch Info", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReviewsResponse> call, Throwable t) {
                Toast.makeText(Profile_S_V_CustomerRating.this, t.toString(), Toast.LENGTH_SHORT).show();
            }

        });
    }
    void updateLayout(){
        commentList.clear();
        for (ReviewList reviewList : reviewLists){
            //todo photo Customer
        //    commentList.add(new Comment(reviewList.getCustomer_username(),"",reviewList.getRate(),reviewList.getComment()));
            commentsAdapter.notifyDataSetChanged();

        }

    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.back_b)
        {
            destroyInterface();
        }
        else if(v.getId()==R.id.about_b)
        {
            Intent i=new Intent(Profile_S_V_CustomerRating.this,Profile_S_V_CustomerAbout.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.information_b)
        {
            Intent i=new Intent(Profile_S_V_CustomerRating.this, Profile_S_V_CustomerInformation.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.account_ib)
        {
            Intent i=new Intent(Profile_S_V_CustomerRating.this,AccountServiceProvider.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.home_ib)
        {
            Intent i=new Intent(Profile_S_V_CustomerRating.this,Home.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.chat_ib)
        {
            Intent i=new Intent(Profile_S_V_CustomerRating.this,ChatList.class);
            startActivity(i);
        }
    }
    private void destroyInterface() {
        finish();
    }

}