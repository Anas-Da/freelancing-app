package com.example.freelancing_app.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class MessageResponse {

    @SerializedName("messages")
    private List<Message> messages;

    @SerializedName("img")
    private String img;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
