// Message.java
package com.example.freelancing_app.models;

import com.google.gson.annotations.SerializedName;

public class Message {

    @SerializedName("message")
    private String message;

    @SerializedName("image_message")
    private String imageMessage;

    @SerializedName("date")
    private String date;

    @SerializedName("time")
    private String time;

    @SerializedName("sender")
    private String sender;

    @SerializedName("reciever")
    private String receiver;

    public Message(String message, String imageMessage, String date, String time, String sender, String receiver) {
        this.message = message;
        this.imageMessage = imageMessage;
        this.date = date;
        this.time = time;
        this.sender = sender;
        this.receiver = receiver;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImageMessage() {
        return imageMessage;
    }

    public void setImageMessage(String imageMessage) {
        this.imageMessage = imageMessage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
