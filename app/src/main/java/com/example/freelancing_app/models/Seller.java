package com.example.freelancing_app.models;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class Seller {

    private String seller_name;
    private Bitmap imageResource;
    private String service_type;

    public Seller(String name, Bitmap imageResource,String service_type) {
        this.seller_name = name;
        this.imageResource = imageResource;
        this.service_type = service_type;
    }

    public String getName() {
        return seller_name;
    }

    public Bitmap getImageResource() {
        return imageResource;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }
}
