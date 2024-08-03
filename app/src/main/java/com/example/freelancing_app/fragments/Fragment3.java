package com.example.freelancing_app.fragments;

import android.annotation.SuppressLint;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.freelancing_app.R;

public class Fragment3 extends Fragment  implements EditableFragment{

    private EditText phone_number_et;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_phone_number, container, false);
        phone_number_et = view.findViewById(R.id.email_et);
        return view;
    }

    @Override
    public String getEditableText() {
        return phone_number_et.getText().toString().trim();
    }
}
