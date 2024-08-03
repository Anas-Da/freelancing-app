package com.example.freelancing_app.models;

import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("text")
    private String text;
    @SerializedName("isSent")
    private boolean isSent;

    public Message(String text, boolean isSent) {
        this.text = text;
        this.isSent = isSent;
    }

    public String getText() {
        return text;
    }

    public boolean isSent() {
        return isSent;
    }
}
