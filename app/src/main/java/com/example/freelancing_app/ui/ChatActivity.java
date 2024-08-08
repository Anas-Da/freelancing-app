package com.example.freelancing_app.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancing_app.R;
import com.example.freelancing_app.adapters.MessageAdapter;
import com.example.freelancing_app.models.Chat;
import com.example.freelancing_app.models.Message;
import com.example.freelancing_app.models.MessageResponse;
import com.example.freelancing_app.network.ApiService;
import com.example.freelancing_app.network.RetrofitInstance;
import com.example.freelancing_app.utils.GlobalVariables;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ChatActivity extends AppCompatActivity {
    private static final String TAG = "ChatActivity";

    ApiService apiService;
    GlobalVariables globalVariables;
    private EditText editTextMessage;
    private ImageButton buttonSend,back_b,more_b,attachment_b,microphone_b;
    TextView seller_name_tv;
    private MessageAdapter messageAdapter;
    private RecyclerView recyclerViewMessages;
    private ArrayList<Message> messageList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opened_chat);

        apiService = RetrofitInstance.getRetrofitInstance().create(ApiService.class);
        globalVariables = (GlobalVariables) getApplicationContext();

        recyclerViewMessages = findViewById(R.id.message_lv);
        editTextMessage = findViewById(R.id.send_message_et);
        seller_name_tv = findViewById(R.id.seller_name_tv);
        buttonSend = findViewById(R.id.send_b);
        seller_name_tv.setText(globalVariables.getChatWith());

        messageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(this, messageList);

        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMessages.setAdapter(messageAdapter);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = editTextMessage.getText().toString().trim();
                if (!messageText.isEmpty()) {
                    String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
                    String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
                    Message message = new Message(messageText, null, date, currentTime, globalVariables.getUsername(), globalVariables.getChatWith());
                    messageList.add(message);
                    messageAdapter.notifyDataSetChanged();
                    editTextMessage.setText("");
                    sendMessageToServer(messageText); // Assuming you have a method to send the message to the server
                }
            }
        });

        back_b = findViewById(R.id.back_b);
        more_b = findViewById(R.id.more_b);
        attachment_b = findViewById(R.id.attachment_b);
        microphone_b = findViewById(R.id.microphone_b);

        back_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        more_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo that notification thing
            }
        });

        fetchMessages();

        editTextMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // No action needed here
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    buttonSend.setVisibility(View.VISIBLE);
                    attachment_b.setVisibility(View.INVISIBLE);
                    microphone_b.setVisibility(View.INVISIBLE);
                } else {
                    buttonSend.setVisibility(View.INVISIBLE);
                    attachment_b.setVisibility(View.VISIBLE);
                    microphone_b.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



    }
    private void fetchMessages() {
        String chatId = globalVariables.getChatWith();
        String authToken = "Bearer " + globalVariables.getToken();
        Call<MessageResponse> call = apiService.getMessages(chatId, authToken);
        call.enqueue(new Callback<MessageResponse>() {
            @Override
            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    messageList.clear();
                    messageList.addAll(response.body().getMessages());
                    messageAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(ChatActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t) {
                Toast.makeText(ChatActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendMessageToServer(String messageText) {
        // TODO: Implement the logic to send the message to the server
        Log.d(TAG, "Sending message to server: " + messageText);
    }
   /* private void fetchMessages() {
        String chatId = globalVariables.getChatWith();
        String authToken = "Bearer " + globalVariables.getToken();
        Call<MessageResponse> call = apiService.getMessages(chatId, authToken);
        call.enqueue(new Callback<MessageResponse>() {
            @Override
            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(TAG, "Messages count: " + messageList.size());
                    for (Message message : messageList) {
                        Log.d(TAG, "Message: " + message.getMessage());
                    }
                    messageList.clear();
                    messageList.addAll(response.body().getMessages());
                    messageAdapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(ChatActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t) {
                Toast.makeText(ChatActivity.this, "Failed to fetch messages", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void sendMessageToServer(String messageText) {
        // TODO: Implement the logic to send the message to the server
    }*/
}
