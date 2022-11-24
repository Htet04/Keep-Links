package com.codewall.keeplinks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.codewall.keeplinks.databinding.FragmentCategoryfragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class categoryfragment extends Fragment {
    FragmentCategoryfragmentBinding binding;
    List<Contacts> contacts;

    DBHelper db;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentCategoryfragmentBinding.inflate(getLayoutInflater());

        contacts = new ArrayList<>();

        db = new DBHelper(getContext());
        contacts = db.getAllContacts();
        MyAdapter myAdapter = new MyAdapter(contacts, getContext());
        binding.fragment.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.fragment.setAdapter(myAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_categoryfragment, container, false);
//b


        binding.fab.setOnClickListener(v -> {

            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame, new addlink()).commit();
        });
        return binding.getRoot();
    }
}