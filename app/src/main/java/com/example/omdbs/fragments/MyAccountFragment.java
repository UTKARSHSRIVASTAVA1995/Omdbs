package com.example.omdbs.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.omdbs.view.adapters.AdapterAccount;
import com.example.omdbs.sqlite.DatabaseHelper;
import com.example.omdbs.R;
import com.example.omdbs.models.User;

import java.util.ArrayList;

public class MyAccountFragment extends Fragment {

    DatabaseHelper db;

    ArrayList<User> arrayList = new ArrayList<User>();


    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DatabaseHelper(getActivity());
        arrayList = db.getAllUser();

    }


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_account, container, false);

        RecyclerView recyclerView = v.findViewById(R.id.recyclerViewAccount);
        AdapterAccount adapter = new AdapterAccount(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        arrayList = db.getAllUser();
        for (User user : arrayList) {

            Object rowData[] = {user.getName(), user.getCompanyOrganization(), user.getEmail(), user.getPassword()};
        }

        return v;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}

