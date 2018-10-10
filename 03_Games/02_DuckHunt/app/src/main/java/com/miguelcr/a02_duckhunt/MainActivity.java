package com.miguelcr.a02_duckhunt;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editTextNick;
    Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide the toolbar in this Activity
        getSupportActionBar().hide();

        editTextNick = findViewById(R.id.editTextNick);
        btnStart = findViewById(R.id.buttonStart);

    }


    public void startGame(View view) {
        Intent i = new Intent(MainActivity.this, GameActivity.class);
        startActivity(i);
    }
}
