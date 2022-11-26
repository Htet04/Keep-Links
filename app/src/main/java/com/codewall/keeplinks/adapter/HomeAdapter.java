package com.codewall.keeplinks.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewall.keeplinks.database.DataBaseHelper;
import com.codewall.keeplinks.databinding.HomeItemLayoutBinding;
import com.codewall.keeplinks.util.SheetDialog;

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
            /*BottomSheetDialog dialog = new BottomSheetDialog(holder.itemView.getContext());
            dialog.setTitle("Test");
            dialog.setContentView(R.layout.bottom_sheet_layout);
            dialog.create();
            dialog.show();*/
            SheetDialog dialog = new SheetDialog(holder.itemView.getContext());
            dialog.setOnPositiveButtonClickListener(new SheetDialog.OnPositiveButtonClickListener() {
                @Override
                public void onPositiveButtonClicked() {
                    Toast.makeText(holder.itemView.getContext(), "Positive", Toast.LENGTH_SHORT).show();
                }
            });
            dialog.setOnNegativeButtonClickListener(new SheetDialog.OnNegativeButtonClickListener() {
                @Override
                public void onNegativeButtonClicked() {
                    Toast.makeText(holder.itemView.getContext(), "Negative", Toast.LENGTH_SHORT).show();
                }
            });
            dialog.show();
        });
    }

    @Override
    public int getItemCount() {
//        return db.size();
        return 30;
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
