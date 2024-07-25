package com.example.freelancing_app;

public class Seller {

    private String seller_name;
    private int imageResource;
    private String service_type;

    public Seller(String name, int imageResource,String service_type) {
        this.seller_name = name;
        this.imageResource = imageResource;
        this.service_type = service_type;
    }

    public String getName() {
        return seller_name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }
}
