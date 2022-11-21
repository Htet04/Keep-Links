package com.ktz.keeplinks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ktz.keeplinks.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Binding ထည့်ပြီး
    }
}