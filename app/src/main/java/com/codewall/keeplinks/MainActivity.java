package com.codewall.keeplinks;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.codewall.keeplinks.databinding.ActivityMainBinding;
import com.codewall.keeplinks.ui.fragment.CategoryFragment;
import com.codewall.keeplinks.ui.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        initialize();
    }

    private void initialize() {
        // on App start view
        // can change to user last chose by using SharedPreference
        showFragment(new HomeFragment());

        binding.mainBnv.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_bnv_home: {
                    showFragment(new HomeFragment());
                    break;
                }
                case R.id.menu_bnv_category: {
                    showFragment(new CategoryFragment());
                    break;
                }
                /*
                tempo code
                case R.id.menu_bnv_favorite: {
                    showFragment(new FavoriteFragment());
                    break;
                }*/
            }
            return true;
        });
        binding.mainBnv.setOnItemReselectedListener(item -> {
            // to prevent content reload
        });
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_menu, menu);

        // code to show the Option Menu icon visible
        if (menu instanceof MenuBuilder) {
            MenuBuilder menuBuilder = (MenuBuilder) menu;
            menuBuilder.setOptionalIconsVisible(true);
        }

        // code reference to SearchView from Menu
        final SearchView searchView = (SearchView) menu.findItem(R.id.menu_toolbar_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast T = Toast.makeText(MainActivity.this, newText, Toast.LENGTH_SHORT);
                T.setGravity(Gravity.CENTER, 0, 0);
                T.show();
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("bnv",binding.mainBnv.getSelectedItemId());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        binding.mainBnv.setSelectedItemId(savedInstanceState.getInt("bnv"));
    }

    private void showFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame, fragment);
        transaction.commit();
    }
}