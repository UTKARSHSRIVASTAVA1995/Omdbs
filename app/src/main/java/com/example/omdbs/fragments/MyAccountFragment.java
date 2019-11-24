package com.example.omdbs.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.omdbs.R;

public class MyAccountFragment extends Fragment {

    TextView textName, textCompany, textPassword, textEmail;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_account, container, false);

        textName = v.findViewById(R.id.textViewName);
        textCompany = v.findViewById(R.id.textViewCreditCard);
        textEmail = v.findViewById(R.id.textViewEmail);
        textPassword = v.findViewById(R.id.textViewPassword);
        Bundle b3 = getArguments();
        String name = b3.getString("name");
        String company = b3.getString("company");
        String email = b3.getString("email");
        String pwd = b3.getString("pwd");

        textName.setText(name);
        textCompany.setText(company);
        textEmail.setText(email);
        textPassword.setText(pwd);
        return v;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}

