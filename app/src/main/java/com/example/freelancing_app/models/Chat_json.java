package com.example.freelancing_app.models;

import com.google.gson.annotations.SerializedName;

public class Chat_json {

    @SerializedName("person2_username")
    private String person2Username;

    @SerializedName("unread_cnt")
    private int unreadCnt;

    @SerializedName("last_message")
    private String lastMessage;

    @SerializedName("image_message")
    private String imageMessage;

    @SerializedName("username")
    private String username;

    @SerializedName("date")
    private String date;

    @SerializedName("time")
    private String time;

    @SerializedName("sender")
    private String sender;

    @SerializedName("reciever")
    private String receiver;

    @SerializedName("img")
    private String img;

    // Getters and Setters
    public String getPerson2Username() {
        return person2Username;
    }

    public void setPerson2Username(String person2Username) {
        this.person2Username = person2Username;
    }

    public int getUnreadCnt() {
        return unreadCnt;
    }

    public void setUnreadCnt(int unreadCnt) {
        this.unreadCnt = unreadCnt;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }


    public String getImageMessage() {
        return imageMessage;
    }

    public void setImageMessage(String imageMessage) {
        this.imageMessage = imageMessage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
