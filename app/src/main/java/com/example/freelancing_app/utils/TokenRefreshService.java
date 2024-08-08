package com.example.freelancing_app.utils;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TokenRefreshService extends Service {

    private static final String TAG = "TokenRefreshService";
    private static final String SERVER_URL = "https://yourserver.com/refresh_token";
    private static final String PREF_FILE_NAME = "com.example.yourapp.PREF_FILE_KEY";
    private static final String PREF_REFRESH_TOKEN = "refresh_token";
    private static final String PREF_ACCESS_TOKEN = "access_token";

    private Handler handler;
    private boolean isRefreshing = false;

    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler();
        startPeriodicTokenRefresh();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY; // Service will be restarted if killed by the system
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void startPeriodicTokenRefresh() {
        handler.post(refreshTokenRunnable);
    }

    private Runnable refreshTokenRunnable = new Runnable() {
        @Override
        public void run() {
            SharedPreferences sharedPreferences = getSharedPreferences(PREF_FILE_NAME, MODE_PRIVATE);
            String refreshToken = sharedPreferences.getString(PREF_REFRESH_TOKEN, null);

            if (refreshToken != null && !isRefreshing) {
                sendRefreshToken(refreshToken);
                isRefreshing = true; // Set flag to prevent overlapping requests
            }

            // Schedule the next execution in 30 minutes (1800000 milliseconds)
            handler.postDelayed(this, 18000000);
        }
    };

    private void sendRefreshToken(String refreshToken) {
        OkHttpClient client = new OkHttpClient();

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Authorization", refreshToken);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody body = RequestBody.create(jsonObject.toString(), MediaType.parse("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url(SERVER_URL)
                .post(body)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "Request failed: " + e.getMessage());
                showToast("Timeout: Server didn't respond.");
                isRefreshing = false;
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                isRefreshing = false;

                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    Log.d(TAG, "Response: " + responseData);

                    try {
                        JSONObject jsonResponse = new JSONObject(responseData);
                        String accessToken = jsonResponse.getString("access_token");

                        saveAccessToken(accessToken);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        showToast("Error parsing server response.");
                    }
                } else {
                    Log.e(TAG, "Request unsuccessful: " + response.code());
                }
            }
        });
    }

    private void saveAccessToken(String accessToken) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_FILE_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREF_ACCESS_TOKEN, accessToken);
        editor.apply();
    }

    private void showToast(final String message) {
        // Display toast on the main UI thread
        Handler mainHandler = new Handler(getApplicationContext().getMainLooper());
        mainHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Clean up resources if needed
        handler.removeCallbacks(refreshTokenRunnable);
    }
}

