package com.codewall.keeplinks.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.codewall.keeplinks.R;
import com.codewall.keeplinks.databinding.DialogAddCategoryBinding;

public class AddCategoryDialog extends AlertDialog {
    DialogAddCategoryBinding binding;
    AddClickListener addClickListener;
    public AddCategoryDialog(@NonNull Context context) {
        super(context);
        binding = DialogAddCategoryBinding.inflate(LayoutInflater.from(context));
        this.setView(binding.getRoot());
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        binding.btnAddDialog.setOnClickListener(v -> {
            addClickListener.onClick(String.valueOf(binding.textCategory.getText()));
        });
        Dialog dialog = new Dialog(context);
    }
    public void setOnAddListener(AddClickListener addClickListener){
        this.addClickListener = addClickListener;
    }
    public interface AddClickListener{
        void onClick(String string);
    }
}
