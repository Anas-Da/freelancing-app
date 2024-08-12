package com.example.freelancing_app.models;

import android.graphics.Bitmap;

public class NotificationItem {
    private final String personName;
    private final Bitmap photoResId;

    public NotificationItem(String personName, Bitmap photoResId) {
        this.personName = personName;
        this.photoResId = photoResId;
    }

    public String getPersonName() {
        return personName;
    }

    public Bitmap getPhotoResId() {
        return photoResId;
    }
}