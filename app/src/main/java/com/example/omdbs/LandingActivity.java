package com.example.omdbs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import androidx.annotation.Nullable;

public class LandingActivity extends Activity {
    private final int SPLASH_DISPLAY_LENGTH = 1000;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(LandingActivity.this, MainActivity.class);
                LandingActivity.this.startActivity(mainIntent);
                LandingActivity.this.finish();

            }
        },SPLASH_DISPLAY_LENGTH);

    }
}
