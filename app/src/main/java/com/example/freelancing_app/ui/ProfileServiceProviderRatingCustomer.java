package com.example.freelancing_app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
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


public class ProfileServiceProviderRatingCustomer extends AppCompatActivity implements View.OnClickListener {

    private ApiService apiService;

    GlobalVariables globalVariables;
    private ImageView back_b;

    private RelativeLayout chat_b;
    private Button  information_b;
    private Button  about_b;
    private  ImageButton account_ib;
    private  ImageButton home_ib;
    private  ImageButton chat_ib;
    private TextView addRatingTextView;

    private RecyclerView comments_iv;
    private CommentsAdapter commentsAdapter;
    private List<Comment> commentList;
    private  List <ReviewList> reviewLists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_service_provider_rating_customer);

        back_b=findViewById(R.id.back_b);
        chat_b=findViewById(R.id.chat_b);
        information_b=findViewById(R.id.information_b);
        about_b=findViewById(R.id.about_b);
        account_ib=findViewById(R.id.account_ib);
        home_ib=findViewById(R.id.home_ib);
        chat_ib=findViewById(R.id.chat_ib);

        reviewLists = new ArrayList<>();

        globalVariables = (GlobalVariables) getApplicationContext();
        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);

        back_b.setOnClickListener(this);
        chat_b.setOnClickListener(this);
        information_b.setOnClickListener(this);
        about_b.setOnClickListener(this);
        account_ib.setOnClickListener(this);
        home_ib.setOnClickListener(this);
        chat_ib.setOnClickListener(this);
        addRatingTextView = findViewById(R.id.add_rating_dialog_b);
        comments_iv = findViewById(R.id.comments_iv);
        comments_iv.setLayoutManager(new LinearLayoutManager(this));

        commentList = new ArrayList<>();
        // commentList.add(new Comment("John Doe", R.drawable.yellow_star, "Great product!", 5));
        // commentList.add(new Comment("Jane Smith",R.drawable.yellow_star , "Not bad, but could be better.", 3));

        commentsAdapter = new CommentsAdapter(commentList, this);
        comments_iv .setAdapter(commentsAdapter);
        addRatingTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCommentDialog();
            }
        });
        fetchReview();
    }


    private void showCommentDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.add_comment_dialog);

        EditText commentEditText = dialog.findViewById(R.id.comment_et);
        CheckBox star1 = dialog.findViewById(R.id.star1);
        CheckBox star2 = dialog.findViewById(R.id.star2);
        CheckBox star3 = dialog.findViewById(R.id.star3);
        CheckBox star4 = dialog.findViewById(R.id.star4);
        CheckBox star5 = dialog.findViewById(R.id.star5);
        Button submitButton = dialog.findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = commentEditText.getText().toString();
                StringBuilder ratingString = new StringBuilder();

                ratingString.append(star1.isChecked() ? "1" : "0");
                ratingString.append(star2.isChecked() ? "1" : "0");
                ratingString.append(star3.isChecked() ? "1" : "0");
                ratingString.append(star4.isChecked() ? "1" : "0");
                ratingString.append(star5.isChecked() ? "1" : "0");

                Log.d("Rating", "Comment: " + comment);
                Log.d("Rating", "Rating: " + ratingString.toString());

               dialog.dismiss();
            }
        });

        dialog.show();
    }
    private void fetchReview() {

        Call<ReviewsResponse> call = apiService.getReviews(globalVariables.getUsername(),String.valueOf( globalVariables.getProfileid()));
        call.enqueue(new Callback<ReviewsResponse>() {
            @Override
            public void onResponse(Call<ReviewsResponse> call, Response<ReviewsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    reviewLists = response.body().getResult();
                    updateLayout();
                } else {
                    Toast.makeText(ProfileServiceProviderRatingCustomer.this, "Failed to fetch Info", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ReviewsResponse> call, Throwable t) {
                Toast.makeText(ProfileServiceProviderRatingCustomer.this, t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }
        void updateLayout() {
            commentList.clear();
                for (ReviewList reviewList : reviewLists) {
                    //todo photo Customer
                    // commentList.add(new Comment(reviewList.getCustomer_username(),"",reviewList.getRate(),reviewList.getComment()));
                    commentsAdapter.notifyDataSetChanged();

                }

            }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.back_b)
        {
            destroyInterface();
        }
        else if(v.getId()==R.id.chat_b)
        {
            Intent i=new Intent(ProfileServiceProviderRatingCustomer.this,ChatActivity.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.information_b)
        {
            Intent i=new Intent(ProfileServiceProviderRatingCustomer.this, ProfileServiceProviderInformationCustomer.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.about)
        {
            Intent i=new Intent(ProfileServiceProviderRatingCustomer.this, ProfileServiceProviderAboutCustomer.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.account_ib)
        {
            Intent i=new Intent(ProfileServiceProviderRatingCustomer.this,AccountServiceProvider.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.home_ib)
        {
            Intent i=new Intent(ProfileServiceProviderRatingCustomer.this,Home.class);
            startActivity(i);
        }
        else if(v.getId()==R.id.chat_ib)
        {
            Intent i=new Intent(ProfileServiceProviderRatingCustomer.this,ChatList.class);
            startActivity(i);
        }

    }
    private void destroyInterface() {
        finish();
    }
}