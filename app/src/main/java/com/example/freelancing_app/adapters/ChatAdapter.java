package com.example.freelancing_app.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.freelancing_app.R;
import com.example.freelancing_app.models.Chat;
import com.example.freelancing_app.models.Chat_json;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private List<Chat> chatList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public ChatAdapter(Context context, List<Chat> chatList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.chatList = chatList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_chat, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        Chat chat = chatList.get(position);
        holder.messageTextView.setText(chat.getLast_message());
        holder.senderTextView.setText(chat.getName());
        if (chat.getImage() != null) {
            holder.image.setImageBitmap(chat.getImage());
        } else {
            holder.image.setImageResource(R.drawable.person); // Replace with a default image resource
        }
        holder.time.setText(chat.getTime());
        if(chat.getUnread_cnt()==0){
            holder.unread_cnt.setVisibility(View.INVISIBLE);
        }else{
            holder.unread_cnt.setVisibility(View.VISIBLE);
            holder.unread_cnt.setText(String.valueOf(chat.getUnread_cnt()));
        }
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onChatClick(position);
            }
        });
        //todo

    }

    @Override
    public int getItemCount() {
        return (chatList != null) ? chatList.size() : 0;
    }

    public void updateChats(List<Chat> newChatList) {
        if (newChatList != null) {
            chatList.clear();
            chatList.addAll(newChatList);
            notifyDataSetChanged();
        }
    }

    public static class ChatViewHolder extends RecyclerView.ViewHolder {
        TextView messageTextView;
        TextView senderTextView;
        ImageView image;
        TextView time;

        TextView unread_cnt;

        public ChatViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            messageTextView = itemView.findViewById(R.id.last_message_tv);
            senderTextView = itemView.findViewById(R.id.seller_name_tv);
            time = itemView.findViewById(R.id.message_time);
            unread_cnt = itemView.findViewById(R.id.unread_count);
        }
    }
    public interface OnItemClickListener {
        void onChatClick(int position);
    }
}
