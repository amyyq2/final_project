package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons = new Button[3][3];
    private int player1Points;
    private int player2Points;
    private TextView player1;
    private TextView player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonID = "button_" + i + j;
                int id = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(id);
                buttons[i][j].setOnClickListener(this);
            }
        }
        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player1Points = 0;
                player2Points = 0;
                updatePoints();
                resetBoard();
            }
        });
    }

    @Override
    public void onClick(View view) {
        toClicker();
    }

    private String checkBoardWin() {
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = buttons[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1])
                && board[i][0].equals(board[i][2])
                && !board[i][0].equals("")) {
                return board[i][0];
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i])
                    && board[0][i].equals(board[2][i])
                    && !board[0][i].equals("")) {
                return board[0][i];
            }
        }
        if (board[0][0].equals(board[1][1])
                && board[0][0].equals(board[2][2])
                && !board[0][0].equals("")) {
            return board[0][0];
        }
        if (board[0][2].equals(board[1][1])
                && board[0][2].equals(board[2][0])
                && !board[0][2].equals("")) {
            return board[0][2];
        }
        return "-";
    }
    private void player1Win() {
        player1Points++;
        Toast.makeText(this, "Player 1 wins", Toast.LENGTH_SHORT).show();
        updatePoints();
        resetBoard();
    }
    private void player2Win() {
        player2Points++;
        Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show();
        updatePoints();
        resetBoard();
    }
    private void draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }
    private void updatePoints() {
        player1.setText("Player 1: " + player1Points);
        player2.setText("Player 2: " + player2Points);
    }
    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }
    private void toClicker() {
        Intent intent = new Intent(this, ClickerActivity.class);
        startActivity(intent);
    }
}
