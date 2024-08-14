package com.example.freelancing_app.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static Retrofit retrofit=null;

    // private static final String BASE_URL = "http://192.168.1.4:8000/";
    private static final String BASE_URL = "http://192.168.1.102:8000/";
    //private static final String BASE_URL = "http://192.168.14.161:8000/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
