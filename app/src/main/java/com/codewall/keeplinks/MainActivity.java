package com.codewall.keeplinks;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.codewall.keeplinks.databinding.ActivityMainBinding;
import com.codewall.keeplinks.ui.dialog.MyDialog;
import com.codewall.keeplinks.ui.fragment.BrowserFragment;
import com.codewall.keeplinks.ui.fragment.CategoryFragment;
import com.codewall.keeplinks.ui.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private MenuItem menuSearch, menuOpenWith;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        initialize();

    }

    private void openDialog() {
        MyDialog myDialog = new MyDialog();
        myDialog.show(getSupportFragmentManager(), "mydialog");
    }

    private void initialize() {
        // on App start view
        // can change to user last chose by using SharedPreference
        showFragment(new HomeFragment());

        binding.mainBnv.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_bnv_home: {
                    //test
                    menuSearch.setVisible(true);
                    menuOpenWith.setVisible(false);
                    showFragment(new HomeFragment());
                    break;
                }
                case R.id.menu_bnv_category: {
                    menuSearch.setVisible(true);
                    menuOpenWith.setVisible(false);
                    showFragment(new CategoryFragment());
                    break;
                }
                case R.id.browser: {
                    menuSearch.setVisible(false);
                    menuOpenWith.setVisible(true);
                    showFragment(new BrowserFragment());
                    break;
                }
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

        menuSearch = menu.findItem(R.id.menu_toolbar_search);
        menuOpenWith = menu.findItem(R.id.menu_toolbar_open_with);

        // code reference to SearchView from Menu
        final SearchView searchView = (SearchView) menuSearch.getActionView();
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
        outState.putInt("bnv", binding.mainBnv.getSelectedItemId());
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