package com.example.glowlane;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // Add any additional logic or animations for the splash screen

        // Example: Delay for a few seconds and then start the main activity
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
            }
        }, 3000); // 3 seconds delay
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish(); // Finish the splash screen activity
    }
}

