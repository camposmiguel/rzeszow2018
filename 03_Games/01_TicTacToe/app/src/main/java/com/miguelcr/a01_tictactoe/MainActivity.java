package com.miguelcr.a01_tictactoe;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = findViewById(R.id.textViewGame);

        // Change the "title" font type
        Typeface type = Typeface.createFromAsset(getAssets(),"vegan.ttf");
        title.setTypeface(type);

    }

    public void startGame(View v) {
        // The lines of code to execute when
        // user click on Start game button...
        Toast.makeText(this, "New game started!", Toast.LENGTH_SHORT).show();

        // define the new screen to open
        Intent i = new Intent(MainActivity.this, GameActivity.class);

        // putExtras
        i.putExtra()

        // navigate to GameActivity
        startActivity(i);

    }
}
