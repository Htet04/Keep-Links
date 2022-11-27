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
        holder.itemView.setOnLongClickListener(v ->{
            SheetDialog dialog = new SheetDialog(holder.itemView.getContext());
            dialog.setOnCopyButtonClickListener(()->{
                Toast.makeText(holder.itemView.getContext(), "Copy button click", Toast.LENGTH_SHORT).show();
            });
            dialog.setOnEditButtonClickListener(()->{
                Toast.makeText(holder.itemView.getContext(), "Edit button click", Toast.LENGTH_SHORT).show();
            });
            dialog.setOnOpenButtonClickListener(()->{
                Toast.makeText(holder.itemView.getContext(), "Open button click", Toast.LENGTH_SHORT).show();
            });
            dialog.setOnShareButtonClickListener(()->{
                Toast.makeText(holder.itemView.getContext(), "Share button click", Toast.LENGTH_SHORT).show();
            });
            dialog.setOnDeleteButtonClickListener(()->{
                Toast.makeText(holder.itemView.getContext(), "Delete button click", Toast.LENGTH_SHORT).show();
            });
            dialog.show();
            return true;
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
