package com.codewall.keeplinks.adapter;

import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_COPY;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_DELETE;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_EDIT;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_OPEN;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_SHARE;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewall.keeplinks.data.HomeData;
import com.codewall.keeplinks.databinding.HomeItemLayoutBinding;
import com.codewall.keeplinks.ui.dialog.SheetDialog;
import com.codewall.keeplinks.util.Utils;

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

        binding.linkName.setText(data.getCategory(position));
        binding.linktext.setText(data.getLink(position));
        binding.savedDate.setText(data.getSavedDate(position));

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(holder.itemView.getContext(), String.valueOf(data.getId(position)), Toast.LENGTH_SHORT).show();
        });

        holder.itemView.setOnLongClickListener(v -> {
            SheetDialog dialog = new SheetDialog(holder.itemView.getContext());
            dialog.setOnButtonClickListener(btn_type -> {
                switch (btn_type) {
                    case BUTTON_COPY: {
                        Utils.copyToClipboard(holder.itemView.getContext(), data.getLink(position));
                        Toast.makeText(holder.itemView.getContext(), "Link Copied!", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case BUTTON_EDIT: {

                        break;
                    }
                    case BUTTON_OPEN: {
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        String url = data.get(position).getLink();
                        url = url.startsWith("http")?url:"https://"+url;
                        intent.setData(Uri.parse(url));
                        holder.itemView.getContext().startActivity(Intent.createChooser(intent,"Open with..."));
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
