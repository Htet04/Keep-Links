package com.codewall.keeplinks.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewall.keeplinks.R;
import com.codewall.keeplinks.data.CategoryData;
import com.codewall.keeplinks.database.DataBaseHelper;
import com.codewall.keeplinks.databinding.CatagoryItemLayoutBinding;
import com.codewall.keeplinks.listener.OnItemLongClickListener;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    CatagoryItemLayoutBinding binding;
    CategoryData data;
    private String title;

    private OnItemLongClickListener onItemLongClickListener;

    public CategoryAdapter(CategoryData data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CatagoryItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        binding.categoryName.setText((CharSequence) data.getCategory(position));

        holder.itemView.setOnLongClickListener(v -> {
            onItemLongClickListener.onLongClick(1);
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            textView = itemView.findViewById(R.id.category_name);
        }
    }
}
