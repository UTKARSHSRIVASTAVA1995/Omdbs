package com.example.omdbs.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.omdbs.DatabaseHelper;
import com.example.omdbs.R;
import com.example.omdbs.User;

import java.util.ArrayList;

public class MyAccountFragment extends Fragment {

    DatabaseHelper db;

    ArrayList<User> arrayList = new ArrayList<User>();


    TextView textName, textCompany, textPassword, textEmail;


    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(getActivity());
        arrayList = db.getAllUser();

    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_account, container, false);

        /*RecyclerView recyclerView = v.findViewById(R.id.recyclerView);
        AdapterAccount adapter = new AdapterAccount(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);*/


        textName = v.findViewById(R.id.textViewName);
        textCompany = v.findViewById(R.id.textViewCreditCard);
        textEmail = v.findViewById(R.id.textViewEmail);
        textPassword = v.findViewById(R.id.textViewPassword);

        arrayList = db.getAllUser();
        for (User user : arrayList) {

            Object rowData[] = {user.getName(), user.getCompanyOrganization(), user.getEmail(), user.getPassword()};

        }

        textName.setText(arrayList.get(0).getName());
        textCompany.setText(arrayList.get(0).getCompanyOrganization());
        textEmail.setText(arrayList.get(0).getEmail());
        textPassword.setText(arrayList.get(0).getPassword());

        return v;


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}

