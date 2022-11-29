package com.codewall.keeplinks.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import com.codewall.keeplinks.R;
import com.codewall.keeplinks.databinding.BottomSheetLayoutBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class SheetDialog extends BottomSheetDialog {
    private BottomSheetLayoutBinding binding;
    private OnCopyButtonClickListener onCopyButtonClickListener;
    private OnEditButtonClickListener onEditButtonClickListener;
    private OnOpenButtonClickListener onOpenButtonClickListener;
    private OnShareButtonClickListener onShareButtonClickListener;
    private OnDeleteButtonClickListener onDeleteButtonClickListener;

    public SheetDialog(@NonNull Context context) {
        super(context);
        binding = BottomSheetLayoutBinding.inflate(LayoutInflater.from(context));
        this.setContentView(binding.getRoot());

        setting();
    }

    public void setOnCopyButtonClickListener(OnCopyButtonClickListener onCopyButtonClickListener) {
        this.onCopyButtonClickListener = onCopyButtonClickListener;
    }

    public void setOnEditButtonClickListener(OnEditButtonClickListener onEditButtonClickListener) {
        this.onEditButtonClickListener = onEditButtonClickListener;
    }

    public void setOnOpenButtonClickListener(OnOpenButtonClickListener onOpenButtonClickListener){
        this.onOpenButtonClickListener = onOpenButtonClickListener;
    }

    public void setOnShareButtonClickListener(OnShareButtonClickListener onShareButtonClickListener){
        this.onShareButtonClickListener = onShareButtonClickListener;
    }

    public void setOnDeleteButtonClickListener(OnDeleteButtonClickListener onDeleteButtonClickListener){
        this.onDeleteButtonClickListener = onDeleteButtonClickListener;
    }

    @Override
    public void show() {
        this.create();
        super.show();
    }

    private void setting() {
        binding.copy.text.setText("Copy");
        binding.copy.icon.setImageResource(R.drawable.ic_baseline_content_copy_24);
        binding.edit.text.setText("Edit");
        binding.edit.icon.setImageResource(R.drawable.ic_baseline_edit_24);
        binding.open.text.setText("Open");
        binding.open.icon.setImageResource(R.drawable.ic_baseline_open_in_browser_24);
        binding.share.text.setText("Share");
        binding.share.icon.setImageResource(R.drawable.ic_baseline_share_24);
        binding.delete.text.setText("Delete");
        binding.delete.icon.setImageResource(R.drawable.ic_baseline_delete_24);

        binding.copy.getRoot().setOnClickListener(v -> {
            onCopyButtonClickListener.onCopyButtonClicked();
        });
        binding.edit.getRoot().setOnClickListener(v -> {
            onEditButtonClickListener.onEditButtonClicked();
        });
        binding.open.getRoot().setOnClickListener(v -> {
            onOpenButtonClickListener.onOpenButtonButtonClicked();
        });
        binding.share.getRoot().setOnClickListener(v -> {
            onShareButtonClickListener.onShareButtonClicked();
        });
        binding.delete.getRoot().setOnClickListener(v -> {
            onDeleteButtonClickListener.onDeleteButtonClickListener();
        });
    }


    public interface OnCopyButtonClickListener {
        void onCopyButtonClicked();
    }

    public interface OnEditButtonClickListener {
        void onEditButtonClicked();
    }

    public interface OnOpenButtonClickListener {
        void onOpenButtonButtonClicked();
    }

    public interface OnShareButtonClickListener {
        void onShareButtonClicked();
    }

    public interface OnDeleteButtonClickListener {
        void onDeleteButtonClickListener();
    }
}
