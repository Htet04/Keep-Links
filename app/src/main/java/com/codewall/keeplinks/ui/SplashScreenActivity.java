package com.codewall.keeplinks.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.codewall.keeplinks.MainActivity;
import com.codewall.keeplinks.databinding.ActivitySplashScreenBinding;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new Handler().postDelayed(()->{
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        },2250);
    }

    @Override
    public void onBackPressed() {

    }
}