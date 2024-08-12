package com.example.freelancing_app.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancing_app.R;
import com.example.freelancing_app.adapters.ChatAdapter;
import com.example.freelancing_app.models.Chat;
import com.example.freelancing_app.models.Chat_json;
import com.example.freelancing_app.network.ApiService;
import com.example.freelancing_app.network.ChatsResponse;
import com.example.freelancing_app.network.RetrofitInstance;
import com.example.freelancing_app.utils.GlobalVariables;
import com.example.freelancing_app.utils.ImageUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChatList extends AppCompatActivity implements ChatAdapter.OnItemClickListener{

    private ApiService apiService;
    private ChatAdapter chatAdapter;
    private RecyclerView chats_list;
    private List<Chat_json> chatJsonList;
    private List<Chat> chat;
    GlobalVariables globalVariables;



    ImageButton home_ib;
    ImageButton account_ib;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats_list);

        globalVariables= (GlobalVariables) getApplicationContext();


        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);


        chats_list = findViewById(R.id.chats_li);


        chats_list.setLayoutManager(new LinearLayoutManager(this));

        chatJsonList = new ArrayList<>();



        chat = new ArrayList<>();
        chatAdapter = new ChatAdapter(this,chat,this);
        chats_list.setAdapter(chatAdapter);


        // TODO  Call fetchProfiles to populate data
        //fetchChats();
        //startChatRefreshTimer();

        String s="Hello i wana ask you about a case that i have a prob...";
        Bitmap AA = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.michael_6);
        chat.add(new Chat("Ahmad_Shamma", s,AA,2,
                "02:14"));
        String s2="Great,Thank you very much for your Help.";
        Bitmap DD = BitmapFactory.decodeResource(this.getResources(),
        R.drawable.michael_1);
        chat.add(new Chat("Anas_Da", s2,DD,0,
        "12:31"));

        home_ib = findViewById(R.id.home_ib);
        home_ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ChatList.this, Home.class);
                startActivity(i);
            }
        });

        account_ib = findViewById(R.id.account_ib);
        account_ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ChatList.this, AccountServiceProvider.class);
                startActivity(i);
            }
        });

    }


    private void fetchChats() {
        String authToken = "Bearer " + globalVariables.getToken();
        Call<ChatsResponse> call = apiService.getChats(authToken);
        call.enqueue(new Callback<ChatsResponse>() {
            @Override
            public void onResponse(Call<ChatsResponse> call, Response<ChatsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Chat_json> chatJsonList = response.body().getChats();
                    updateChatList(chatJsonList);
                }else if(!response.isSuccessful()){
                    Toast.makeText(ChatList.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ChatsResponse> call, Throwable t) {
                Toast.makeText(ChatList.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateChatList(List<Chat_json> chatJsonList) {
        List<Chat> updatedChatList = new ArrayList<>();
        for (Chat_json chatJson : chatJsonList) {
            String base64Image = chatJson.getImg();
            String s=chatJson.getLastMessage();
            if(s.length()>40){
                s=s.substring(0,40);
                s+="...";
            }
            Bitmap bitmap = ImageUtils.decodeBase64ToBitmap(base64Image);
            updatedChatList.add(new Chat(chatJson.getPerson2Username(), s,bitmap,chatJson.getUnreadCnt(),
                    chatJson.getTime().substring(0,5)));
        }
        chatAdapter.updateChats(updatedChatList);
    }

    private Handler handler;
    private Runnable runnable;

    private void startChatRefreshTimer() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                fetchChats();
                handler.postDelayed(this, 5000); // Refresh every 5 seconds
            }
        };
        handler.post(runnable);
    }
    @Override
    public void onChatClick(int position){
        // TODO get the handle
        Chat selectedChat = chat.get(position);
        String handle = selectedChat.getName(); // Or any other property you need
        globalVariables.setChatWith(handle);
        Toast.makeText(this, "Item " + position,Toast.LENGTH_SHORT).show();

       Intent i=new Intent(ChatList.this, ChatActivity.class);
        startActivity(i);

    }

    @Override
    protected void onDestroy() {
        stopChatRefreshTimer(); // Stop the timer when the activity is destroyed
        super.onDestroy();
    }

    private void stopChatRefreshTimer() {
        if (handler != null && runnable != null) {
            handler.removeCallbacks(runnable);
        }
    }

}
