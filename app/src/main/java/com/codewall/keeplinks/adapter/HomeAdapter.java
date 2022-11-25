package com.codewall.keeplinks.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewall.keeplinks.data.LinkData;
import com.codewall.keeplinks.database.DataBaseHelper;
import com.codewall.keeplinks.databinding.HomeRecyclerItemLayoutBinding;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    HomeRecyclerItemLayoutBinding binding;
    DataBaseHelper db;
    List<LinkData> list;

    public HomeAdapter(DataBaseHelper db) {
        this.db = db;
        list = db.getData();
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = HomeRecyclerItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new HomeViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        /*binding.linkName.setText(db.getValue(position,DataBaseHelper.K_NAME));
        binding.linktext.setText(db.getValue(position,DataBaseHelper.K_LINK));
        binding.savedDate.setText(db.getValue(position,DataBaseHelper.K_SAVED_DATE));*/
        binding.linkName.setText(list.get(position).getName());
        binding.linktext.setText(list.get(position).getLink());
        binding.savedDate.setText(list.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return db.getData().size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
