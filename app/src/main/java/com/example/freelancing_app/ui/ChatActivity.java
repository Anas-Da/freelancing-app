package com.example.freelancing_app.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.freelancing_app.R;
import com.example.freelancing_app.adapters.MessageAdapter;
import com.example.freelancing_app.models.Message;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    private ListView listViewMessages;
    private EditText editTextMessage;
    private Button buttonSend;
    private MessageAdapter messageAdapter;
    private ArrayList<Message> messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opened_chat);

       /* listViewMessages = findViewById(R.id.message_lv);
        editTextMessage = findViewById(R.id.send_message_et);
        //buttonSend = findViewById(R.id.buttonSend);

        messageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(this, messageList);

        listViewMessages.setAdapter(messageAdapter);

        // TODO get messages from back

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = editTextMessage.getText().toString().trim();
                if (!messageText.isEmpty()) {
                    Message message = new Message(messageText, true); // Assuming 'true' indicates it's a sent message
                    messageList.add(message);
                    messageAdapter.notifyDataSetChanged();
                    editTextMessage.setText("");
                }
            }
        });*/
    }
}
