package com.codewall.keeplinks.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.codewall.keeplinks.databinding.ActivityLinkEditorBinding;

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