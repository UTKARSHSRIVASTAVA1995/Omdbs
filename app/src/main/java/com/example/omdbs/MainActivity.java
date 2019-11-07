package com.example.omdbs;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class MainActivity extends Activity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();

            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}



