package com.ktz.keeplinks.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ktz.keeplinks.R;
import com.ktz.keeplinks.databinding.FragmentFavoriteBinding;

public class FavoriteFragment extends Fragment {

    FragmentFavoriteBinding binding;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFavoriteBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}