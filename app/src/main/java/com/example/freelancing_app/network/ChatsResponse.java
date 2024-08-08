package com.example.freelancing_app.network;

import com.example.freelancing_app.models.Chat;
import com.example.freelancing_app.models.Chat_json;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChatsResponse {

    @SerializedName("unread_chats")
    private int unreadChats;

    @SerializedName("chats")
    private List<Chat_json> chats;

    // Getters and setters for each field
    public int getUnreadChats() {
        return unreadChats;
    }

    public void setUnreadChats(int unreadChats) {
        this.unreadChats = unreadChats;
    }

    public List<Chat_json> getChats() {
        return chats;
    }

    public void setChats(List<Chat_json> chats) {
        this.chats = chats;
    }
}
