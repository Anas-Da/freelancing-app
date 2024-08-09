package com.example.freelancing_app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.freelancing_app.R;

public class Fragment6 extends Fragment implements EditableFragment {
    private EditText firstname_et;
    private EditText secondname_et;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_name, container, false);
        firstname_et = view.findViewById(R.id.firstname_et);
        secondname_et = view.findViewById(R.id.secondname_et);
        return view;
    }

    @Override
    public String getEditableText() {
        String firstname = firstname_et.getText().toString().trim();
        String secondname = secondname_et.getText().toString().trim();

        return firstname + " " + secondname; // Combine both texts if needed

    }
}
