package com.example.freelancing_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.Message;
import com.example.freelancing_app.utils.GlobalVariables;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {

    private Context context;
    private ArrayList<Message> messageList;
    private GlobalVariables globalVariables;

    public MessageAdapter(Context context, ArrayList<Message> messageList) {
        this.context = context;
        this.messageList = messageList;
        this.globalVariables = (GlobalVariables) context.getApplicationContext();
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = messageList.get(position);
        holder.textViewMessage.setText(message.getMessage());

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) holder.textViewMessage.getLayoutParams();
        params.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        params.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);

        if (!message.getSender().equals(globalVariables.getUsername())) {
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            holder.textViewMessage.setBackgroundResource(R.drawable.sent_message_right); // background for sent messages
        } else {
            params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            holder.textViewMessage.setBackgroundResource(R.drawable.received_message_left); // background for received messages
        }

        holder.textViewMessage.setLayoutParams(params);
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        TextView textViewMessage;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewMessage = itemView.findViewById(R.id.textViewMessage);
        }
    }
}
