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
    private AddClickListener addClickListener;
    private boolean isEdit;
    private EditListener editListener;
    public AddCategoryDialog(@NonNull Context context) {
        super(context);
        binding = DialogAddCategoryBinding.inflate(LayoutInflater.from(context));
        this.setView(binding.getRoot());
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        binding.btnAddDialog.setOnClickListener(v -> {
            if (isEdit){
                editListener.onEdited(String.valueOf(binding.textCategory.getText()));
            } else {
                addClickListener.onClick(String.valueOf(binding.textCategory.getText()));
            }
            dismiss();
        });
    }

    @Override
    public void show() {
        super.show();
        isEdit = false;
    }

    public void showEdit(String old,EditListener editListener){
        isEdit = true;
        super.show();
        this.editListener = editListener;
        binding.textCategory.setText(old);
        binding.btnAddDialog.setText("Save");
    }

    public void setOnAddListener(AddClickListener addClickListener){
        this.addClickListener = addClickListener;
    }

    public interface AddClickListener{
        void onClick(String string);
    }
    public interface EditListener{
        void onEdited(String string);
    }
}
