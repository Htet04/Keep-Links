package com.codewall.keeplinks.adapter;

import static com.codewall.keeplinks.database.DataBaseHelper.CATEGORY;
import static com.codewall.keeplinks.database.DataBaseHelper.LINK;
import static com.codewall.keeplinks.database.DataBaseHelper.SAVED_DATE;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_COPY;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_DELETE;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_EDIT;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_OPEN;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_SHARE;
import static com.codewall.keeplinks.util.Utils.copyToClipboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewall.keeplinks.data.HomeData;
import com.codewall.keeplinks.database.DataBaseHelper;
import com.codewall.keeplinks.databinding.HomeItemLayoutBinding;
import com.codewall.keeplinks.listener.OnItemLongClickListener;
import com.codewall.keeplinks.ui.dialog.SheetDialog;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    HomeItemLayoutBinding binding;
    DataBaseHelper db;
    HomeData data;

    OnItemLongClickListener onItemLongClickListener;

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

        binding.linkName.setText(data.getCategory(position));
        binding.linktext.setText(data.getLink(position));
        binding.savedDate.setText(data.getSavedDate(position));

        holder.itemView.setOnLongClickListener(v ->{
            SheetDialog dialog = new SheetDialog(holder.itemView.getContext());
            dialog.setOnButtonClickListener(btn_type -> {
                onItemLongClickListener.onLongClick(btn_type,position);
                notifyDataSetChanged();
                dialog.dismiss();
            });
            dialog.show();
            return true;
        });
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener = onItemLongClickListener;
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
