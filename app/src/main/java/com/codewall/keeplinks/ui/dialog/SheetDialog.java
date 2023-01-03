package com.codewall.keeplinks.ui.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;

import com.codewall.keeplinks.R;
import com.codewall.keeplinks.databinding.BottomSheetLayoutBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class SheetDialog extends BottomSheetDialog {
    public static final int BUTTON_COPY = 1;
    public static final int BUTTON_EDIT = 2;
    public static final int BUTTON_OPEN = 3;
    public static final int BUTTON_SHARE = 4;
    public static final int BUTTON_DELETE = 5;
    private BottomSheetLayoutBinding binding;
    private OnButtonClickListener buttonClickListener;

    private boolean isCate;

    public SheetDialog(@NonNull Context context) {
        super(context);
        binding = BottomSheetLayoutBinding.inflate(LayoutInflater.from(context));
        this.setContentView(binding.getRoot());

        setting();
    }

    public void setOnButtonClickListener(OnButtonClickListener buttonClickListener) {
        this.buttonClickListener = buttonClickListener;
    }

    public void setCate() {
        isCate = true;
        setting();
    }

    @Override
    public void show() {
        this.create();
        super.show();
    }

    private void setting() {
        if (isCate){
            binding.copy.getRoot().setVisibility(View.GONE);
            binding.open.getRoot().setVisibility(View.GONE);
            binding.share.getRoot().setVisibility(View.GONE);
        }
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
            buttonClickListener.onButtonClick(BUTTON_COPY);
        });
        binding.edit.getRoot().setOnClickListener(v -> {
            buttonClickListener.onButtonClick(BUTTON_EDIT);
        });
        binding.open.getRoot().setOnClickListener(v -> {
            buttonClickListener.onButtonClick(BUTTON_OPEN);
        });
        binding.share.getRoot().setOnClickListener(v -> {
            buttonClickListener.onButtonClick(BUTTON_SHARE);
        });
        binding.delete.getRoot().setOnClickListener(v -> {
            buttonClickListener.onButtonClick(BUTTON_DELETE);
        });
    }

    public interface OnButtonClickListener {
        /**
         * Button Types are
         * {@link #BUTTON_COPY}
         * {@link #BUTTON_EDIT}
         * {@link #BUTTON_OPEN}
         * {@link #BUTTON_SHARE}
         * {@link #BUTTON_DELETE}
         * */
        void onButtonClick(final int btn_type);
    }

}
