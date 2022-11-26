package com.codewall.keeplinks.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.codewall.keeplinks.R;
import com.codewall.keeplinks.database.DataBaseHelper;
import com.codewall.keeplinks.databinding.HomeItemLayoutBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    HomeItemLayoutBinding binding;
    DataBaseHelper db;

    public HomeAdapter(DataBaseHelper db) {
        this.db = db;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = HomeItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HomeViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        /*binding.linkName.setText(db.getValue(position, DataBaseHelper.K_NAME));
        binding.linktext.setText(db.getValue(position, DataBaseHelper.K_LINK));
        binding.savedDate.setText(db.getValue(position, DataBaseHelper.K_SAVED_DATE));*/
        holder.itemView.setOnClickListener(v -> {
            BottomSheetDialog dialog = new BottomSheetDialog(holder.itemView.getContext());
            dialog.setTitle("Test");
            dialog.setContentView(R.layout.bottom_sheet_layout);
            dialog.create();
            dialog.show();
        });
    }

    @Override
    public int getItemCount() {
//        return db.size();
        return 30;
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
