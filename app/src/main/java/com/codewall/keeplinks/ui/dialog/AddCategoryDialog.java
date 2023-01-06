package com.codewall.keeplinks.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.codewall.keeplinks.databinding.DialogAddCategoryBinding;

public class AddCategoryDialog extends AlertDialog {
    DialogAddCategoryBinding binding;
    private AddClickListener addClickListener;
    private boolean isEdit;
    private EditListener editListener;
    private int oldPo;

    public AddCategoryDialog(@NonNull Context context) {
        super(context);
        binding = DialogAddCategoryBinding.inflate(LayoutInflater.from(context));
        this.setView(binding.getRoot());
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        binding.btnAddDialog.setOnClickListener(v -> {
            if (isEdit) {
                editListener.onEdited(oldPo, String.valueOf(binding.textCategory.getText()));
            } else {
                addClickListener.onClick(String.valueOf(binding.textCategory.getText()));
            }
            dismiss();
        });
    }

    public void showEdit(String old, int position) {
        isEdit = true;
        oldPo = position;
        super.show();
        binding.textCategory.setText(old);
        binding.btnAddDialog.setText("Save");
    }

    public void setOnEditListener(EditListener editListener) {
        this.editListener = editListener;
    }

    public void setOnAddListener(AddClickListener addClickListener) {
        this.addClickListener = addClickListener;
    }

    public interface AddClickListener {
        void onClick(String string);
    }

    public interface EditListener {
        void onEdited(int oldPo, String string);
    }
}
