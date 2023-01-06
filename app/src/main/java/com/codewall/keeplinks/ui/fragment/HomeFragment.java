package com.codewall.keeplinks.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.codewall.keeplinks.R;
import com.codewall.keeplinks.adapter.HomeAdapter;
import com.codewall.keeplinks.data.HomeData;
import com.codewall.keeplinks.database.DataBaseHelper;
import com.codewall.keeplinks.databinding.FragmentHomeBinding;
import com.codewall.keeplinks.ui.dialog.AddInfoDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    DataBaseHelper db;
    HomeData data;
    HomeAdapter adapter;

    public HomeFragment() {
        // need to fix FAB
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        initialization();

        binding.homeRecycler.setHasFixedSize(true);
        binding.homeRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.homeRecycler.setAdapter(adapter);
        // TODO : add data manage method with listener Ok

        FloatingActionButton mainFab = requireActivity().findViewById(R.id.main_fab);

        mainFab.setOnClickListener(v -> {
            AddInfoDialog dialog = new AddInfoDialog(getContext());
            dialog.show();
        });
        return binding.getRoot();
    }

    private void initialization(){
        db = new DataBaseHelper(getContext());
        data = new HomeData().getInstance(requireContext());
        adapter = new HomeAdapter(data);
    }
}