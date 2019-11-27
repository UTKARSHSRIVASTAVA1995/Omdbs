package com.example.omdbs;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.omdbs.fragments.MyAccountFragment;

import java.util.ArrayList;


public class AdapterAccount extends RecyclerView.Adapter<AdapterAccount.ViewHolder> {

    private MyAccountFragment[] listdata;
    ArrayList<User> listdata1;

    public AdapterAccount(ArrayList<User> listdata) {

        listdata1 = listdata;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.fragment_account, parent, false);
        RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(listItem) {

        };

        return (ViewHolder) viewHolder;
    }


    public void onBindViewHolder(ViewHolder holder, int position) {

        final MyAccountFragment myAccountFragment = listdata[position];
        holder.textName.setText(listdata1.get(position).getName());
        holder.textCompany.setText(listdata1.get(position).getCompanyOrganization());
        holder.textEmail.setText(listdata1.get(position).getEmail());
        holder.textPassword.setText(listdata1.get(position).getPassword());

    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textName, textCompany, textPassword, textEmail;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            this.textName = itemView.findViewById(R.id.textViewName);
            this.textCompany = itemView.findViewById(R.id.textViewCreditCard);
            this.textEmail = itemView.findViewById(R.id.textViewEmail);
            this.textPassword = itemView.findViewById(R.id.textViewPassword);
            linearLayout = itemView.findViewById(R.id.listaccount);
        }
    }
}
