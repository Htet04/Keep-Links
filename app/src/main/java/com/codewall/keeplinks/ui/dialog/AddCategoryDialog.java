package com.codewall.keeplinks.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.codewall.keeplinks.databinding.DialogAddCategoryBinding;

public class AddCategoryDialog extends AlertDialog {
    DialogAddCategoryBinding binding;
    public AddCategoryDialog(@NonNull Context context) {
        super(context);
        this.setTitle("Add Category");
        binding = DialogAddCategoryBinding.inflate(LayoutInflater.from(context));
        this.setView(binding.getRoot());
        binding.btnAddDialog.setOnClickListener(v -> {
            Toast.makeText(context, binding.textCategory.getText().toString(), Toast.LENGTH_SHORT).show();
            this.dismiss();
        });
    }
}
