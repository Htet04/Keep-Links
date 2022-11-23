package com.ktz.keeplinks.ui.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.ktz.keeplinks.databinding.HomeRecyclerItemLayoutBinding;

public class AddDialogFragment extends DialogFragment {

    /**
     * Test only*/

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Add Link");
        builder.setMessage("Add Link to save.");
        HomeRecyclerItemLayoutBinding binding = HomeRecyclerItemLayoutBinding.inflate(getLayoutInflater());
        builder.setView(binding.getRoot());
        binding.ttt.setText("Add item from layout.");
        builder.setPositiveButton("Add", (dialog, which) -> {

        });
        builder.setNegativeButton("Cancel", (dialog, which) -> {

        });
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
