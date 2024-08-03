package com.example.freelancing_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.Message;

import java.util.ArrayList;

public class MessageAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Message> messageList;

    public MessageAdapter(Context context, ArrayList<Message> messageList) {
        this.context = context;
        this.messageList = messageList;
    }

    @Override
    public int getCount() {
        return messageList.size();
    }

    @Override
    public Object getItem(int position) {
        return messageList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = messageList.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_message, parent, false);
        }

        TextView textViewMessage = convertView.findViewById(R.id.textViewMessage);
        textViewMessage.setText(message.getText());

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) textViewMessage.getLayoutParams();
        params.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);

        if (message.isSent()) {
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            textViewMessage.setBackgroundResource(R.drawable.sent_message_right); // background for sent messages
        } else {
            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            textViewMessage.setBackgroundResource(R.drawable.received_message_left); // background for received messages
        }

        textViewMessage.setLayoutParams(params);

        return convertView;
    }
}
