package com.example.omdbs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.example.omdbs.dashboard.DashboardActivity;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private String loggedIn;

    private Handler mWaitHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        prefs = getSharedPreferences("datasaving", MODE_PRIVATE);
        loggedIn = prefs.getString("loggedIn", "");



        mWaitHandler.postDelayed(new Runnable() {

            @Override
            public void run() {



                try {


                    if(null != loggedIn && loggedIn.matches("userlogged")){
                        startActivity(new Intent(SplashScreenActivity.this, DashboardActivity.class));
                    }else {
                        startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                        finish();
                    }

                } catch (Exception ignored) {
                    ignored.printStackTrace();
                }
            }
        }, 3000);






    }
}