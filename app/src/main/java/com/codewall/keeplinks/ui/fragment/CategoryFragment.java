package com.codewall.keeplinks.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.codewall.keeplinks.R;
import com.codewall.keeplinks.adapter.CategoryAdapter;
import com.codewall.keeplinks.data.CategoryData;
import com.codewall.keeplinks.database.DataBaseHelper;
import com.codewall.keeplinks.databinding.FragmentCategoryBinding;
import com.codewall.keeplinks.ui.dialog.AddCategoryDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

public class CategoryFragment extends Fragment {

    CategoryData data;
    FragmentCategoryBinding binding;
    CategoryAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater, container, false);

        data = new DataBaseHelper(getContext()).getCategory();
        Log.i("caterr", "onCreateView: " + new Gson().toJson(data));

        adapter = new CategoryAdapter(data);

        binding.categoryRecycler.setHasFixedSize(true);

        binding.categoryRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.categoryRecycler.setAdapter(adapter);
        AddCategoryDialog edit = new AddCategoryDialog(getContext());

        FloatingActionButton mainFab = requireActivity().findViewById(R.id.main_fab);
        AddCategoryDialog dialog = new AddCategoryDialog(requireContext());
        dialog.setOnAddListener(string -> {
            // TODO : fix here
            Toast.makeText(requireContext(), string, Toast.LENGTH_SHORT).show();
        });

        mainFab.setOnClickListener(v -> {
            /*MyDialog myDialog = new MyDialog();
            myDialog.show(getActivity().getSupportFragmentManager(), "my");*/
//            dialog.show();
            new DataBaseHelper(requireContext()).addLink("test", "test", "test", "test", "test");
        });
        return binding.getRoot();

    }
}

