package com.example.freelancing_app.models;
public class NotificationItem {
    private final String personName;
    private final int photoResId;

    public NotificationItem(String personName, int photoResId) {
        this.personName = personName;
        this.photoResId = photoResId;
    }

    public String getPersonName() {
        return personName;
    }

    public int getPhotoResId() {
        return photoResId;
    }
}