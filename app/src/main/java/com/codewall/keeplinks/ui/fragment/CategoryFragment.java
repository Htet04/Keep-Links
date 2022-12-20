package com.codewall.keeplinks.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.codewall.keeplinks.adapter.CategoryAdapter;
import com.codewall.keeplinks.data.CateData;
import com.codewall.keeplinks.database.DataBaseHelper;
import com.codewall.keeplinks.databinding.FragmentCategoryBinding;
import com.codewall.keeplinks.ui.dialog.AddCategoryDialog;
import com.codewall.keeplinks.ui.dialog.MyDialog;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {
    ArrayList<CateData> arrayList;
    FragmentCategoryBinding binding;
    DataBaseHelper db;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        arrayList = new ArrayList<>();

        db = new DataBaseHelper(getContext());
        arrayList = (ArrayList<CateData>) db.getCategoryList();
        arrayList.add(new CateData("hello"));
        binding = FragmentCategoryBinding.inflate(inflater, container, false);
        binding.categoryRecycler.setHasFixedSize(true);
        CategoryAdapter adapter = new CategoryAdapter(arrayList);
        binding.categoryRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.categoryRecycler.setAdapter(adapter);

        binding.btnFab.setOnClickListener(v -> {
            /*MyDialog myDialog = new MyDialog();
            myDialog.show(getActivity().getSupportFragmentManager(), "my");*/
            AddCategoryDialog dialog = new AddCategoryDialog(getContext());
            db.getCategory();
            dialog.show();
        });
        return binding.getRoot();

    }
}

