package com.asier.aranda.diseointerfaces;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.asier.aranda.diseointerfaces.ui.main.SectionsPagerAdapter;
import com.asier.aranda.diseointerfaces.databinding.ActivityMainBnBinding;

public class MainBN extends AppCompatActivity {

    private ActivityMainBnBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBnBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);

        BottomNavigationView mybottomNavView = findViewById(R.id.bottom_navigation);


        mybottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.favourite:
                        item.setChecked(true);
                        Toast.makeText(MainBN.this, "Favoroutie clicked.", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.add:
                        item.setChecked(true);
                        Toast.makeText(MainBN.this, "Add clicked.", Toast.LENGTH_SHORT).show();
                        //removeBadge(mybottomNavView,item.getItemId());
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.browse:
                        item.setChecked(true);
                        Toast.makeText(MainBN.this, "Browse clicked.", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(2);

                        break;
                    case R.id.profile:
                        item.setChecked(true);
                        Toast.makeText(MainBN.this, "Profile clicked.", Toast.LENGTH_SHORT).show();
                        viewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });
    }
}
