package com.example.freelancing_app;
public class Profession {

    private String name;
    private int imageResource;

    public Profession(String name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }
}