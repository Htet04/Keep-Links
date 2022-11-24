package com.ktz.keeplinks.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ktz.keeplinks.databinding.ActivityLinkEditorBinding;

public class LinkEditorActivity extends AppCompatActivity {

    ActivityLinkEditorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLinkEditorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String sharedText = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText!=null) {
            binding.link.setText(sharedText);
        }
    }
}