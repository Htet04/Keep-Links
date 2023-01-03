package com.codewall.keeplinks.ui.fragment;

import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_COPY;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_DELETE;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_EDIT;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_OPEN;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_SHARE;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.codewall.keeplinks.R;
import com.codewall.keeplinks.adapter.CategoryAdapter;
import com.codewall.keeplinks.data.CategoryData;
import com.codewall.keeplinks.database.DataBaseHelper;
import com.codewall.keeplinks.databinding.FragmentCategoryBinding;
import com.codewall.keeplinks.ui.dialog.AddCategoryDialog;
import com.codewall.keeplinks.ui.dialog.SheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CategoryFragment extends Fragment {

    CategoryData data;
    FragmentCategoryBinding binding;
    DataBaseHelper db;
    CategoryAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater, container, false);


        db = new DataBaseHelper(getContext());
        data = new CategoryData(requireContext());
        adapter = new CategoryAdapter(data);

        binding.categoryRecycler.setHasFixedSize(true);

        binding.categoryRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.categoryRecycler.setAdapter(adapter);

        adapter.setOnItemLongClickListener((btn_type,position) -> {
            switch (btn_type){
                case BUTTON_EDIT:{

                    break;
                }
                case BUTTON_DELETE:{

                    break;
                }
            }
        });

        FloatingActionButton mainFab = requireActivity().findViewById(R.id.main_fab);

        mainFab.setOnClickListener(v -> {
            /*MyDialog myDialog = new MyDialog();
            myDialog.show(getActivity().getSupportFragmentManager(), "my");*/
            AddCategoryDialog dialog = new AddCategoryDialog(getContext());
            dialog.setOnAddListener(string -> {
                // TODO : fix here

            });
            dialog.show();
        });
        return binding.getRoot();

    }
}

