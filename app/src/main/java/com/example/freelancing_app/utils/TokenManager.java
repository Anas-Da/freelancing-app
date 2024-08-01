package com.example.freelancing_app.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class TokenManager {
    private static final String PREF_FILE_NAME = "com.example.yourapp.PREF_FILE_KEY";
    private static final String PREF_ACCESS_TOKEN = "access_token";

    public static String getAccessToken(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(PREF_ACCESS_TOKEN, null);
    }
}
