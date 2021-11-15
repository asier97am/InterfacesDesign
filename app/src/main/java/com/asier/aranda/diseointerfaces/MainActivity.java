package com.asier.aranda.diseointerfaces;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // casting a la vista a la que aplicamos un menu contextual
        // y la registramos
        TextView mycontext = (TextView) findViewById(R.id.textTap);
        registerForContextMenu(mycontext);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast toast = Toast.makeText(this, "Item Copied", Toast.LENGTH_LONG);
                toast.show();
                return true;

            case R.id.item2:
                Toast toast2 = Toast.makeText(this, "Downloading", Toast.LENGTH_LONG);
                toast2.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}


