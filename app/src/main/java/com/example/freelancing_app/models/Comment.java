package com.example.freelancing_app.models;

// Comment.java
public class Comment {
    private String userName;
    private int  userPhotoResId;
    private String text;
    private int rating;

    public Comment(String userName, int userPhotoUrl, String text, int rating) {
        this.userName = userName;
        this.userPhotoResId = userPhotoResId;
        this.text = text;
        this.rating = rating;
    }

    // Getters
    public String getUserName() { return userName; }
    public int getUserPhotoResId() { return userPhotoResId; }
    public String getText() { return text; }
    public int getRating() { return rating; }
}
