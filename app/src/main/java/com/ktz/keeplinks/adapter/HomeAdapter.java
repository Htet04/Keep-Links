package com.ktz.keeplinks.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ktz.keeplinks.database.DataBaseHelper;
import com.ktz.keeplinks.databinding.HomeRecyclerItemLayoutBinding;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    HomeRecyclerItemLayoutBinding binding;
    DataBaseHelper db;

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = HomeRecyclerItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        db = new DataBaseHelper(parent.getContext());
        return new HomeViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        /*binding.linkName.setText(db.getName(position+1));
        binding.linktext.setText(db.getName(position+1));
        binding.savedDate.setText(db.getSavedDate(position+1));*/
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
