package com.miguelcr.a02_intentextras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openActivity(View view) {
        // We define the navigation from the MainActivity >>>> SecondaryActivity
        Intent i = new Intent(MainActivity.this, SecondaryActivity.class);

        // Information to send to the SecondaryActivity
        i.putExtra(Constants.EXTRA_FIRST_NAME, "Miguel");
        i.putExtra(Constants.EXTRA_LAST_NAME, "Campos");

        // Launch the intent navigation
        startActivity(i);
    }
}
