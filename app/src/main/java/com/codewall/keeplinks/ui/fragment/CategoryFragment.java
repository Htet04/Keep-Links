package com.codewall.keeplinks.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.codewall.keeplinks.MainActivity;
import com.codewall.keeplinks.adapter.CategoryAdapter;
import com.codewall.keeplinks.databinding.FragmentCategoryBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CategoryFragment extends Fragment {

    FragmentCategoryBinding binding;

    public CategoryFragment(FloatingActionButton mainFab) {
        // Need to fix FAB
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater,container,false);
        binding.categoryRecycler.setHasFixedSize(true);
        binding.categoryRecycler.setLayoutManager(new GridLayoutManager(getContext(),2));
        binding.categoryRecycler.setAdapter(new CategoryAdapter());
        return binding.getRoot();
    }
}