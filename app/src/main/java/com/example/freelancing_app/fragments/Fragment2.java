package com.example.freelancing_app.fragments;

import android.widget.EditText;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.freelancing_app.R;

public class Fragment2 extends Fragment  implements EditableFragment{

    private EditText email_et;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_email, container, false);
        email_et = view.findViewById(R.id.email_et);
        return view;
    }

    @Override
    public String getEditableText() {
        return email_et.getText().toString().trim();
    }
}
