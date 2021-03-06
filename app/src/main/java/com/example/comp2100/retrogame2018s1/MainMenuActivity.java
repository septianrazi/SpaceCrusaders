package com.example.comp2100.retrogame2018s1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.q42.android.scrollingimageview.ScrollingImageView;

/*
    Created and edited by Kriti  Tripathi, 19/04/2018
    eddited by Yatindra Tripathi, 08/05/2018
    Activity for the menu display
 */

public class MainMenuActivity extends AppCompatActivity{
    public static MediaPlayer ring;

    /**
     * Code run on creation/ initialisation of this activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Getting the width and height of the screen
        GlobalGameVariables.windowWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        GlobalGameVariables.windowHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

        // Setting the scrolling background parameters
        final ScrollingImageView scrolling_background = findViewById(R.id.scrolling_background);
        scrolling_background.setScaleX(1);
        scrolling_background.setScaleY(1);

        // Adding buttons and menus
        final Button button_game = findViewById(R.id.btn_newGame);
        final Button button_options = findViewById(R.id.btn_options);
        final Button button_instructions = findViewById(R.id.btn_instructions);
        final Button button_exit = findViewById(R.id.btn_exit);
        final Switch switch_music = findViewById(R.id.switch_effects);
        final Switch switch_effects = findViewById(R.id.switch_effects);

        // Initialise background music
        MusicManager.getInstance().initalizeMediaPlayer(this, R.raw.ring);
        //play the music
        MusicManager.getInstance().start();

        // Implement the buttons
        button_game.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, GameActivity.class));
            }
        });

         button_instructions.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 Intent intent = new Intent(MainMenuActivity.this, InstructionsActivity.class);
                 startActivity(intent);
             }
         });

         button_options.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent = new Intent(MainMenuActivity.this, OptionsActivity.class);
                 intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                 intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                 startActivity(intent);
             }
         });

        button_exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.exit(0);

            }
        });

    }

}
