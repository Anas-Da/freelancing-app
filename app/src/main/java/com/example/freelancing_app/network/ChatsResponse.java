package com.example.freelancing_app.network;

import com.example.freelancing_app.models.Chat_json;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChatsResponse {

    @SerializedName("chats")
    private List<Chat_json> chatJsons;


    public List<Chat_json> getChats() {
        return chatJsons;
    }

    public void setChat(List<Chat_json> chatJsons) {
        this.chatJsons = chatJsons;
    }
}
