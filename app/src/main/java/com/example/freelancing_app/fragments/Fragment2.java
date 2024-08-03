package com.example.freelancing_app.fragments;

// FirstFragment.java

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;

import com.example.freelancing_app.R;

public class Fragment2 extends Fragment implements EditableFragment {

    private EditText password_et, confirm_password_et;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_password, container, false);
        password_et = view.findViewById(R.id.password_et);
        confirm_password_et = view.findViewById(R.id.confirm_password_et);
        return view;
    }

    @Override
    public String getEditableText() {
        String password = password_et.getText().toString().trim();
        String confirm_password = confirm_password_et.getText().toString().trim();
        return password + " " + confirm_password; // Combine both texts if needed
    }
}