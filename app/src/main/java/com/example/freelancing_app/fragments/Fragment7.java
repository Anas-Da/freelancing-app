package com.example.freelancing_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.freelancing_app.R;

public class Fragment7 extends Fragment implements EditableFragment {
//todo check this fragment please
    EditText bio_et;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_profile_information, container, false);

        // Initialize views
        bio_et = view.findViewById(R.id.bio_et);
        RelativeLayout parentLayout = view.findViewById(R.id.parent_layout); // Assuming RelativeLayout has this id in XML

        parentLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Check if the touch is outside the EditText
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    if (!isTouchInsideView(bio_et, event)) {
                        // Hide EditText and show TextView with entered text
                        bio_et.setText(bio_et.getText().toString().trim());
                    }
                }
                return true;
            }
        });

        return view;
    }

    // Helper method to check if touch is inside the view
    private boolean isTouchInsideView(View view, MotionEvent event) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];
        return !(event.getRawX() < x || event.getRawX() > x + view.getWidth() ||
                event.getRawY() < y || event.getRawY() > y + view.getHeight());
    }

    @Override
    public String getEditableText() {
        return bio_et.getText().toString().trim();
    }
}
