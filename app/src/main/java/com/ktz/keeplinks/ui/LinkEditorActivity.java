package com.ktz.keeplinks.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ktz.keeplinks.databinding.ActivityLinkEditorBinding;

public class LinkEditorActivity extends AppCompatActivity {

    ActivityLinkEditorBinding binding;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLinkEditorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String sharedText = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText!=null) {
            binding.link.setText(sharedText);
        }
    }
}