package com.ktz.keeplinks.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ktz.keeplinks.adapter.HomeAdapter;
import com.ktz.keeplinks.databinding.FragmentHomeBinding;
import com.ktz.keeplinks.ui.LinkEditorActivity;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);
        binding.homeRecycler.setHasFixedSize(true);
        binding.homeRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.homeRecycler.setAdapter(new HomeAdapter());

        binding.btnFab.setOnClickListener(v -> {
            // test code
            startActivity(new Intent(getContext(), LinkEditorActivity.class));
        });
        return binding.getRoot();
    }
}