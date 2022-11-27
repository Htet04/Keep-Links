package com.codewall.keeplinks.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.codewall.keeplinks.MainActivity;
import com.codewall.keeplinks.adapter.HomeAdapter;
import com.codewall.keeplinks.database.DataBaseHelper;
import com.codewall.keeplinks.databinding.FragmentHomeBinding;
import com.codewall.keeplinks.ui.LinkEditorActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    DataBaseHelper db;
    /**
     * Link add ပြီးတဲ့ အခါ RecyclerView ကို Data Update ဖြစ်အောင် လုပ်ဖို့
     */
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == 10) {
                binding.homeRecycler.setAdapter(new HomeAdapter(db));
            }
        }
    });

    public HomeFragment(FloatingActionButton mainFab) {
        // need to fix FAB
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("bts", "onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("bts", "onDetach: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        binding.homeRecycler.setHasFixedSize(true);
        binding.homeRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        db = new DataBaseHelper(getContext());
        binding.homeRecycler.setAdapter(new HomeAdapter(db));

        return binding.getRoot();
    }
}