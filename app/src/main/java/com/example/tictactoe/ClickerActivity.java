package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ClickerActivity extends AppCompatActivity {
    private int p1_points;
    private int p2_points;
    private TextView p1_click_view;
    private TextView p2_click_view;
    private Button p1_button;
    private Button p2_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker);
        p1_click_view = findViewById(R.id.p1_clicks);
        p2_click_view = findViewById(R.id.p2_clicks);
        p1_button = findViewById(R.id.p1_button);
        p2_button = findViewById(R.id.p2_button);
        p1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p1_points++;
                updateP1Points();
            }
        });
        p2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p2_points++;
                updateP2Points();
            }
        });
        //after countdown timer ends:
        /**
         if (winner()) {
         Toast.makeText(this, "Player 1 wins", Toast.LENGTH_SHORT).show();
         Intent intent = new Intent(this, MainActivity.class);
         startActivity(intent);
         } else {
         Toast.makeText(this, "Player 2 wins", Toast.LENGTH_SHORT).show();
         Intent intent = new Intent(this, MainActivity.class);
         startActivity(intent);
         }
         */
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("winner", true);
        startActivity(intent);
    }
    private void updateP1Points() {
        p1_click_view.setText("" + p1_points);
    }

    private void updateP2Points() {
        p2_click_view.setText("" + p2_points);
    }

    private boolean winner() {
        if (p1_points > p2_points) {
            return true;
        }
        return false;
    }
}