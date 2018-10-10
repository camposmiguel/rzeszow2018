package com.miguelcr.a02_duckhunt;

import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    FloatingActionButton fab;
    ImageView duck;
    Random rand;
    int counter = 0;
    TextView textViewCounter, textViewTimer;
    CountDownTimer timer;
    boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        duck = findViewById(R.id.imageViewDuck);
        textViewCounter = findViewById(R.id.textViewCounter);
        textViewTimer = findViewById(R.id.textViewTimer);
        rand = new Random();

        startTimer();
    }

    private void startTimer() {
        timer = new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                textViewTimer.setText(millisUntilFinished / 1000+"s");
            }

            public void onFinish() {
                textViewTimer.setText("Game over!");
            }
        }.start();

    }

    public void duckClicked(View view) {
        if(gameOver) {
            Toast.makeText(this, "Game is Over", Toast.LENGTH_SHORT).show();
        } else {
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            int height = size.y;

            // Define the maxX and maxY
            int maxX = width - duck.getWidth();
            int maxY = height - duck.getHeight();

            // Generate random x coordinate
            int randomX = rand.nextInt((maxX - 0) + 1);

            // Generate random y coordinate
            int randomY = rand.nextInt((maxY - 0) + 1);

            // Apply the random position to the duck imageView
            duck.setX(randomX);
            duck.setY(randomY);

            // Increase the counter
            counter++;
            textViewCounter.setText(String.valueOf(counter));
        }
    }
}
