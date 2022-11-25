package com.codewall.keeplinks.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.codewall.keeplinks.database.DataBaseHelper;
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
        if (sharedText != null) {
            binding.link.setText(sharedText);
        }
        DataBaseHelper db = new DataBaseHelper(getApplicationContext());
        binding.btnAdd.setOnClickListener(v -> {
            String name = binding.name.getText().toString(),
                    link = binding.link.getText().toString(),
                    category = binding.category.getText().toString(),
                    note = binding.note.getText().toString(),
                    date = binding.date.getText().toString();
            long status = db.addLink(name, link, category, note, date);
            if (status != -1) {
                Toast.makeText(this, "Add Success", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Add Fail", Toast.LENGTH_SHORT).show();
            }
            setResult(10);
            finish();
        });
    }
}