package com.example.omdbs;




import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;


import com.example.omdbs.dashboard.DashboardActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private String loggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =  findViewById(R.id.btn_1);

        prefs = getSharedPreferences("datasaving", MODE_PRIVATE);
         loggedIn = prefs.getString("loggedIn", "");//"No name defined" is the default value.

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(null != loggedIn && !TextUtils.isEmpty(loggedIn) && loggedIn.matches("userlogged")){
                    startActivity(new Intent(MainActivity.this,DashboardActivity.class));
                }else {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }

            }
        });

    }
}