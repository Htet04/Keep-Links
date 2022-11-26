package com.codewall.keeplinks.util;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import com.codewall.keeplinks.R;
import com.codewall.keeplinks.databinding.BottomSheetLayoutBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class SheetDialog extends BottomSheetDialog {
    private BottomSheetLayoutBinding binding;
    private OnPositiveButtonClickListener onPositiveButtonClickListener;
    private OnNegativeButtonClickListener onNegativeButtonClickListener;
    public SheetDialog(@NonNull Context context) {
        super(context);
        binding = BottomSheetLayoutBinding.inflate(LayoutInflater.from(context));
        this.setContentView(binding.getRoot());
        binding.copy.getRoot().setOnClickListener(v -> {
            onNegativeButtonClickListener.onNegativeButtonClicked();
        });
        setting();
    }

    public void setOnPositiveButtonClickListener(OnPositiveButtonClickListener onPositiveButtonClickListener){
        this.onPositiveButtonClickListener = onPositiveButtonClickListener;
    }

    public void setOnNegativeButtonClickListener(OnNegativeButtonClickListener onNegativeButtonClickListener){
        this.onNegativeButtonClickListener = onNegativeButtonClickListener;
    }

    @Override
    public void show() {
        this.create();
        super.show();
    }

    private void setting(){
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
    }
    public interface OnPositiveButtonClickListener {
        void onPositiveButtonClicked();
    }
    public interface OnNegativeButtonClickListener{
        void onNegativeButtonClicked();
    }
}
