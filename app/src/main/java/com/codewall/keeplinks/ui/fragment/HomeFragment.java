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
import com.codewall.keeplinks.data.model.Home;
import com.codewall.keeplinks.database.DataBaseHelper;
import com.codewall.keeplinks.databinding.FragmentHomeBinding;
import com.codewall.keeplinks.ui.dialog.AddInfoDialogFragment;
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
        AddInfoDialogFragment addInfo = new AddInfoDialogFragment();
        addInfo.setOnAddListener((name, link, cate, note, savedDate) -> {
            data.addToDb(new Home().setName(name).setLink(link).setCategory(cate).setNote(note).setSavedDate(savedDate));
            adapter.notifyDataSetChanged();
        });
        mainFab.setOnClickListener(v -> {
            addInfo.show(getParentFragmentManager(),null);
        });
        return binding.getRoot();
    }

    private void initialization(){
        db = new DataBaseHelper(getContext());
        data = db.getHomeData();
        adapter = new HomeAdapter(data);
    }
}