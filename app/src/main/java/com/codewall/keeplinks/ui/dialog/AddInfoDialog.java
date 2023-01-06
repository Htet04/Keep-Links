package com.codewall.keeplinks.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.codewall.keeplinks.databinding.DialogAddInfoBinding;

public class AddInfoDialog extends AlertDialog {
    private DialogAddInfoBinding binding;
    public AddInfoDialog(@NonNull Context context) {
        super(context);
        binding = DialogAddInfoBinding.inflate(LayoutInflater.from(context));
        setView(binding.getRoot());
        setTitle("Add Link");
    }

    @Override
    public void show() {
        create();
        super.show();
    }
}
