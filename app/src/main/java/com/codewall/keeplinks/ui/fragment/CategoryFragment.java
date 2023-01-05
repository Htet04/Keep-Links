package com.codewall.keeplinks.ui.fragment;

import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_DELETE;
import static com.codewall.keeplinks.ui.dialog.SheetDialog.BUTTON_EDIT;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codewall.keeplinks.R;
import com.codewall.keeplinks.adapter.CategoryAdapter;
import com.codewall.keeplinks.data.CategoryData;
import com.codewall.keeplinks.databinding.FragmentCategoryBinding;
import com.codewall.keeplinks.ui.dialog.AddCategoryDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CategoryFragment extends Fragment {

    CategoryData data;
    FragmentCategoryBinding binding;
    AddCategoryDialog dialog;
    CategoryAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater, container, false);

        data = new CategoryData().getInstance(requireContext());

        dialog = new AddCategoryDialog(requireContext());
        adapter = new CategoryAdapter(data);

        binding.categoryRecycler.setHasFixedSize(true);

        binding.categoryRecycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.categoryRecycler.setAdapter(adapter);

        adapter.setOnItemLongClickListener((btn_type, position) -> {
            switch (btn_type) {
                case BUTTON_EDIT: {
                    dialog.showEdit(data.get(position).getCategory(),string -> {

                    });
                    break;
                }
                case BUTTON_DELETE: {

                    break;
                }
            }
        });

        FloatingActionButton mainFab = requireActivity().findViewById(R.id.main_fab);
        dialog.setOnAddListener(string -> {
            // TODO : fix here
            Toast.makeText(requireContext(), string, Toast.LENGTH_SHORT).show();
        });

        mainFab.setOnClickListener(v -> {
            /*MyDialog myDialog = new MyDialog();
            myDialog.show(getActivity().getSupportFragmentManager(), "my");*/
            dialog.show();
        });
        return binding.getRoot();

    }
}

