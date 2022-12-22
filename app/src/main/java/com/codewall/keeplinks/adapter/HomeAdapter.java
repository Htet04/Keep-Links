package com.codewall.keeplinks.adapter;

import static com.codewall.keeplinks.database.DataBaseHelper.CATEGORY;
import static com.codewall.keeplinks.database.DataBaseHelper.LINK;
import static com.codewall.keeplinks.database.DataBaseHelper.NAME;
import static com.codewall.keeplinks.database.DataBaseHelper.SAVED_DATE;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_COPY;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_DELETE;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_EDIT;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_OPEN;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_SHARE;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewall.keeplinks.data.HomeData;
import com.codewall.keeplinks.database.DataBaseHelper;
import com.codewall.keeplinks.databinding.HomeItemLayoutBinding;
import com.codewall.keeplinks.ui.dialog.SheetDialog;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    HomeItemLayoutBinding binding;
    DataBaseHelper db;
    HomeData data;

    public HomeAdapter(HomeData data) {
        this.data = data;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = HomeItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HomeViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {

        binding.linkName.setText(data.get(position).get(CATEGORY));
        binding.linktext.setText(data.get(position).get(LINK));
        binding.savedDate.setText(data.get(position).get(SAVED_DATE));

        holder.itemView.setOnLongClickListener(v ->{
            SheetDialog dialog = new SheetDialog(holder.itemView.getContext());
            dialog.setOnButtonClickListener(btn_type -> {
                switch (btn_type){
                    case BUTTON_COPY:{
                        Toast.makeText(holder.itemView.getContext(), "Copy button click", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case BUTTON_EDIT:{
                        Toast.makeText(holder.itemView.getContext(), "Edit button click", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case BUTTON_OPEN:{
                        Toast.makeText(holder.itemView.getContext(), "Open button click", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case BUTTON_SHARE:{
                        Toast.makeText(holder.itemView.getContext(), "Share button click", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case BUTTON_DELETE:{
                        Toast.makeText(holder.itemView.getContext(), "Delete button click", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    default:{

                    }
                }
            });
            dialog.show();
            return true;
        });
    }

    @Override
    public int getItemCount() {
//        return db.size();
        return data.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
