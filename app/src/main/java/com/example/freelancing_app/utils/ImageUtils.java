package com.example.freelancing_app.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ImageUtils {

    public static String decodeBitmapToBase64(Bitmap bitmap){
        String res="";
        return res;
    }
    public static Bitmap decodeBase64ToBitmap(String base64Image) {
        if(base64Image == null)return null;
        // Remove the prefix if there's one (e.g., "data:image/png;base64,")
        if (base64Image.contains(",")) {
            base64Image = base64Image.split(",")[1];
        }

        byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }


}
