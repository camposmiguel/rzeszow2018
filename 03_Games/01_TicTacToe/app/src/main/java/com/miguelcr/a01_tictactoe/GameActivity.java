package com.miguelcr.a01_tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7, iv8, iv9;
    boolean isPlayingPlayer1 = true;
    boolean gameOver = false;
    Button btnRestart;

    // 0 > the cell is empty
    // 1 > player 1 clicked
    // 2 > player 2 clicked
    // imageview           1 2 3 4 5 6 7 8 9
    // array position      0 1 2 3 4 5 6 7 8
    int[] selectedCells = {0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        iv1 = findViewById(R.id.imageView1);
        iv2 = findViewById(R.id.imageView2);
        iv3 = findViewById(R.id.imageView3);
        iv4 = findViewById(R.id.imageView4);
        iv5 = findViewById(R.id.imageView5);
        iv6 = findViewById(R.id.imageView6);
        iv7 = findViewById(R.id.imageView7);
        iv8 = findViewById(R.id.imageView8);
        iv9 = findViewById(R.id.imageView9);
        btnRestart = findViewById(R.id.buttonRestart);

    }


    public void cellClicked(View view) {
        if(gameOver) {
            Toast.makeText(this, "The GAME is OVER", Toast.LENGTH_SHORT).show();
        } else {
            int id = view.getId();
            ImageView imageViewClicked = null;
            int positionClicked = 0;

            if(id == R.id.imageView1) {
                imageViewClicked = iv1;
                positionClicked = 0;
            } else if(id == R.id.imageView2) {
                imageViewClicked = iv2;
                positionClicked = 1;
            } else if(id == R.id.imageView3) {
                imageViewClicked = iv3;
                positionClicked = 2;
            } else if(id == R.id.imageView4) {
                imageViewClicked = iv4;
                positionClicked = 3;
            } else if(id == R.id.imageView5) {
                imageViewClicked = iv5;
                positionClicked = 4;
            } else if(id == R.id.imageView6) {
                imageViewClicked = iv6;
                positionClicked = 5;
            } else if(id == R.id.imageView7) {
                imageViewClicked = iv7;
                positionClicked = 6;
            } else if(id == R.id.imageView8) {
                imageViewClicked = iv8;
                positionClicked = 7;
            } else if(id == R.id.imageView9) {
                imageViewClicked = iv9;
                positionClicked = 8;
            }

            // Check if the cell clicked is empty
            if(selectedCells[positionClicked] == 0) {

                // Change the imageViewClicked icon
                if (isPlayingPlayer1) {
                    imageViewClicked.setImageResource(R.drawable.ic_player_one);

                    selectedCells[positionClicked] = 1;
                } else {
                    imageViewClicked.setImageResource(R.drawable.ic_player_two);
                    selectedCells[positionClicked] = 2;
                }

                checkWinner();


            } else {
                Toast.makeText(this, "Select an empty cell", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void checkWinner() {
        boolean existSolution = false;

        if(selectedCells[0] == selectedCells[4]
                && selectedCells[4] == selectedCells[8]
                && selectedCells[8] != 0) { // 0, 4, 8

            existSolution = true;

        } else if(selectedCells[2] == selectedCells[4]
                && selectedCells[4] == selectedCells[6]
                && selectedCells[6] != 0) { // 2, 4, 6

            existSolution = true;
        } // ...
        
        

        if(existSolution) {
            gameOver = true;
            btnRestart.setVisibility(View.VISIBLE);

            if(isPlayingPlayer1) {
                Toast.makeText(this, "Winner is P1", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Winner is P2", Toast.LENGTH_SHORT).show();
            }
        } else {
            boolean twoWinners = true;
            for(int i=0; i<9; i++) {
                if(selectedCells[i] == 0) twoWinners = false;
            }
            
            if(twoWinners) {
                gameOver = true;
                btnRestart.setVisibility(View.VISIBLE);
                Toast.makeText(this, "P1 & P2 remis!", Toast.LENGTH_SHORT).show();
            } else {
                isPlayingPlayer1 = !isPlayingPlayer1;
            }
        }

    }


    public void restartGame(View view) {
        // 1. restart the imageViews to empty_box
        iv1.setImageResource(R.drawable.ic_empty_cell);
        iv2.setImageResource(R.drawable.ic_empty_cell);
        iv3.setImageResource(R.drawable.ic_empty_cell);
        iv4.setImageResource(R.drawable.ic_empty_cell);
        iv5.setImageResource(R.drawable.ic_empty_cell);
        iv6.setImageResource(R.drawable.ic_empty_cell);
        iv7.setImageResource(R.drawable.ic_empty_cell);
        iv8.setImageResource(R.drawable.ic_empty_cell);
        iv9.setImageResource(R.drawable.ic_empty_cell);

        // 2. restart the turn > playerOneIsplaying...
        isPlayingPlayer1 = true;
        gameOver = false;

        // 3. reset selectedCells to 0
        for(int i=0; i<9; i++) {
            selectedCells[i] = 0;
        }

        // 4. hide the restart button
        btnRestart.setVisibility(View.INVISIBLE);
    }
    
    
}
