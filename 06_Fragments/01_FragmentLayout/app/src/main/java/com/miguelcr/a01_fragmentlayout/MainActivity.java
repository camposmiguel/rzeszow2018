package com.miguelcr.a01_fragmentlayout;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean loadBlue = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load the default Fragment component >>>> into the FrameLayout
        // FrameLayout is the container and the id => R.id.container
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new RedFragment())
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu_main , menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_change:
                changeColorFragment();
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "Action settings clicked", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void changeColorFragment() {
        // Change the Fragment loaded into the FrameLayout container
        Fragment f = null;

        if(loadBlue) {
            f = new BlueFragment();
        } else {
            f = new RedFragment();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, f)
                .commit();
        
        loadBlue = !loadBlue;
    }
}
