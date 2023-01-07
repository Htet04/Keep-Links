package com.codewall.keeplinks.ui.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.codewall.keeplinks.data.model.Home;
import com.codewall.keeplinks.databinding.DialogAddInfoBinding;

public class AddInfoDialogFragment extends DialogFragment {

    private DialogAddInfoBinding binding;

    private OnAddListener onAddListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogAddInfoBinding.inflate(inflater,container,false);
        binding.btnAdd.setOnClickListener(v -> {
            onAddListener.onAdd(binding.name.getText().toString(),
                    binding.link.getText().toString(),
                    binding.category.getText().toString(),
                    binding.note.getText().toString(),
                    binding.date.getText().toString());
        });
        binding.btnCancel.setOnClickListener(v -> {
            dismiss();
        });
        binding.name.setText(null);
        binding.link.setText(null);
        binding.category.setText(null);
        binding.note.setText(null);
        binding.date.setText(null);
        return binding.getRoot();
    }

    public void setOnAddListener(OnAddListener onAddListener) {
        this.onAddListener = onAddListener;
    }

    public interface OnAddListener {
        void onAdd(String name,String link,String cate,String note,String savedDate);
    }
}
