package com.codewall.keeplinks.adapter;

import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_COPY;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_DELETE;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_EDIT;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_OPEN;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_SHARE;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewall.keeplinks.data.HomeData;
import com.codewall.keeplinks.databinding.HomeItemLayoutBinding;
import com.codewall.keeplinks.ui.dialog.SheetDialog;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    HomeItemLayoutBinding binding;
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

        binding.linkName.setText(data.get(position).getCATEGORY());
        binding.linktext.setText(data.get(position).getLINK());
        binding.savedDate.setText(data.get(position).getSAVEDDATE());

        holder.itemView.setOnLongClickListener(v -> {
            SheetDialog dialog = new SheetDialog(holder.itemView.getContext());
            dialog.setOnButtonClickListener(btn_type -> {
                switch (btn_type) {
                    case BUTTON_COPY: {

                        break;
                    }
                    case BUTTON_EDIT: {

                        break;
                    }
                    case BUTTON_OPEN: {

                        break;
                    }
                    case BUTTON_SHARE: {
                        //holder.itemView.getContext().startActivity(Intent.createChooser(new Intent().setAction(Intent.ACTION_SEND).setDataAndType(Uri.parse(data.get(position).getLINK()),"*/*").putExtra(Intent.EXTRA_TEXT,data.get(position).getLINK()),null));
                        break;
                    }
                    case BUTTON_DELETE: {
                        data.rm(position);
                        break;
                    }
                    default: {

                    }
                }
                notifyDataSetChanged();
                dialog.dismiss();
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
