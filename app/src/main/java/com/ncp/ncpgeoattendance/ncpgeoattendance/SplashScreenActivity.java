package com.ncp.ncpgeoattendance.ncpgeoattendance;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ncp.ncpgeoattendance.R;

public class SplashScreenActivity extends AppCompatActivity
{
    private static final int SPLASH_TIME_OUT = 3000; // 3 seconds
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            finish(); // Close splash activity
        }, SPLASH_TIME_OUT);


    }
}