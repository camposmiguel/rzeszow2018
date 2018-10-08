package com.miguelcr.a02_intentextras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {
    TextView textViewInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        textViewInformation = findViewById(R.id.textViewInfo);

        // Get the intent object, to set the information into
        // the TextView
        Bundle extras = getIntent().getExtras();
        String name = extras.getString(Constants.EXTRA_FIRST_NAME);
        String lastName = extras.getString(Constants.EXTRA_LAST_NAME);

        // Set the extras into the textView
        textViewInformation.setText(name+", "+lastName);
    }
}
