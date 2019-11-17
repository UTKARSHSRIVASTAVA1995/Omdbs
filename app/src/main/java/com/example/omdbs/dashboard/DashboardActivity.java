package com.example.omdbs.dashboard;

import android.content.DialogInterface;

import android.os.Bundle;

import android.widget.FrameLayout;

import com.example.omdbs.R;
import com.example.omdbs.fragments.MovieListFragment;
import com.example.omdbs.fragments.MyAccountFragment;

import com.ss.bottomnavigation.BottomNavigation;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


public class DashboardActivity extends AppCompatActivity {


    private BottomNavigation bottomNavigation;
    private FrameLayout frame_fragment_containers;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_movie_list);
        initViews();
    }


    private void initViews(){


        bottomNavigation=findViewById(R.id.bottom_navigation);
        frame_fragment_containers= findViewById(R.id.frame_fragment_containers);


        bottomNavigation.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
            @Override
            public void onSelectedItemChanged(int itemId) {
                switch (itemId){
                    case R.id.tab_home:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers,new MovieListFragment());
                        break;
                    case R.id.tab_downlaod:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers,new MyAccountFragment());
                        break;
                    case R.id.tab_account:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_fragment_containers,new MyAccountFragment());
                        break;
                }
                transaction.commit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Confirm");
        builder.setMessage("Are you sure?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
                finish();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {


                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }
}
