package com.example.freelancing_app.models;

import android.graphics.Bitmap;


public class Chat {
    private String name;
    private String last_message;
    private Bitmap image;
    private int unread_cnt;
    public Chat(String name, String last_message, Bitmap photo, int unread_cnt/*, */) {
        this.name = name;
        this.last_message = last_message;
        this.image = photo;
        this.unread_cnt = unread_cnt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_message() {
        return last_message;
    }

    public void setLast_message(String last_message) {
        this.last_message = last_message;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public int getUnread_cnt() {
        return unread_cnt;
    }

    public void setUnread_cnt(int unread_cnt) {
        this.unread_cnt = unread_cnt;
    }
}
