package com.ktz.keeplinks;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.ktz.keeplinks.databinding.ActivitySpleshScreenBinding;

@SuppressLint("CustomSplashScreen")
public class SplashScreenActivity extends AppCompatActivity {

    ActivitySpleshScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySpleshScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        new Handler().postDelayed(()->{
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        },2250);
    }

    @Override
    public void onBackPressed() {

    }
}