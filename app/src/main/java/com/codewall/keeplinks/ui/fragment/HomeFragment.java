package com.codewall.keeplinks.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codewall.keeplinks.R;
import com.codewall.keeplinks.adapter.HomeAdapter;
import com.codewall.keeplinks.data.HomeData;
import com.codewall.keeplinks.database.DataBaseHelper;
import com.codewall.keeplinks.databinding.FragmentHomeBinding;
import com.codewall.keeplinks.ui.LinkEditorActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    DataBaseHelper db;
    HomeData data;
    HomeAdapter adapter;
    /**
     * Link add ပြီးတဲ့ အခါ RecyclerView ကို Data Update ဖြစ်အောင် လုပ်ဖို့
     */
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == 10) {
                ((RecyclerView.Adapter<?>) binding.homeRecycler.getAdapter()).notifyDataSetChanged();
            }
        }
    });

    public HomeFragment() {
        // need to fix FAB
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        db = new DataBaseHelper(getContext());
        data = new HomeData().getInstance(requireContext());
        adapter = new HomeAdapter(data);

        db.getCategory();

        binding.homeRecycler.setHasFixedSize(true);
        binding.homeRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.homeRecycler.setAdapter(adapter);
        // TODO : add data manage method with listener Ok

        FloatingActionButton mainFab = requireActivity().findViewById(R.id.main_fab);

        mainFab.setOnClickListener(v -> {
            launcher.launch(new Intent(getContext(), LinkEditorActivity.class));
        });
        return binding.getRoot();
    }
}