package com.asier.aranda.diseointerfaces;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomappbar.BottomAppBar;


public class BottomAppBarr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_app_bar);
        BottomAppBar bottomAppBarr = findViewById(R.id.bottom_app_bar);

        //click event en el  FAB
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BottomAppBarr.this, "FAB Clicked.", Toast.LENGTH_SHORT).show();
            }
        });

        //click event en el Hamburguer menu
        bottomAppBarr.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BottomAppBarr.this, "Menu clicked!", Toast.LENGTH_SHORT).show();
//                sheetBehavior = BottomSheetBehavior.from(sheet);
            }


        });

        //click event en el Bottom bar menu item
        bottomAppBarr.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.heart:
                        Toast.makeText(BottomAppBarr.this, "added to favourites", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.search:
                        Toast.makeText(BottomAppBarr.this, "beginning search", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });


    }

}