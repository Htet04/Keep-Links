package com.ktz.keeplinks;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.SearchView;

import com.ktz.keeplinks.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Binding ထည့်ပြီး
    }

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu,menu);

        // code to show the Option Menu icon visible
        if (menu instanceof MenuBuilder){
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
                Toast T=Toast.makeText(MainActivity.this, newText, Toast.LENGTH_SHORT);
                T.setGravity(Gravity.CENTER,0,0);
                T.show();
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.isCheckable()){
            item.setChecked(true);
            switch (item.getItemId()){
                case R.id.theme_light:{
                    Utils.setTheme(AppCompatDelegate.MODE_NIGHT_NO);
                    break;
                }
                case R.id.theme_dark:{
                    Utils.setTheme(AppCompatDelegate.MODE_NIGHT_YES);
                    break;
                }
                case R.id.theme_system:{
                    Utils.setTheme(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                    break;
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }
}