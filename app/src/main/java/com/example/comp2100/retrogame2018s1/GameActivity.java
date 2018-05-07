package com.example.comp2100.retrogame2018s1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
    Created by Septian Razi, 19/04/2018
    Edited by Kriti Tripathi, 07/05/2018
    ACtivity for the Game to be played
 */

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        final Button button_pause = findViewById(R.id.btn_pauseGame);
        final Button button_help = findViewById(R.id.btn_help);
        final Button button_quit = findViewById(R.id.btn_quit);

        button_pause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


            }
        });

        button_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameActivity.this, InstructionsActivity.class));
            }
        });

        button_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GameActivity.this, MainMenuActivity.class));
            }
        });
    }
}
