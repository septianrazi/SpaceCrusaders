package com.example.comp2100.retrogame2018s1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
    Created and edited by Kriti  Tripathi, 19/04/2018
    eddited by Yatindra Tripathi, 08/05/2018
    Activity for the menu display
 */

public class MainMenuActivity extends AppCompatActivity{
    public static MediaPlayer ring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        // Adding buttons and menus
        final Button button_game = findViewById(R.id.btn_newGame);
        final Button button_options = findViewById(R.id.btn_options);
        final Button button_instructions = findViewById(R.id.btn_instructions);
        final Button button_exit = findViewById(R.id.btn_exit);

        // Initialise background music
        MusicManager.getInstance().initalizeMediaPlayer(this, R.raw.ring);
        MusicManager.getInstance().start();

        // Implement the buttons
        button_game.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, GameActivity.class));
            }
        });

         button_instructions.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 startActivity(new Intent(MainMenuActivity.this, InstructionsActivity.class));
             }
         });

         button_options.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startActivity(new Intent(MainMenuActivity.this, OptionsActivity.class));
             }
         });

        button_exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.exit(0);

            }
        });


    }

}
