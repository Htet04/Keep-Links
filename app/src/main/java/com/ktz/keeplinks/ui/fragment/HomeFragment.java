package com.ktz.keeplinks.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ktz.keeplinks.R;
import com.ktz.keeplinks.adapter.HomeAdapter;
import com.ktz.keeplinks.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentHomeBinding.inflate(getLayoutInflater());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding.homeRecycler.setHasFixedSize(true);
        binding.homeRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.homeRecycler.setAdapter(new HomeAdapter());
        return binding.getRoot();
    }
}