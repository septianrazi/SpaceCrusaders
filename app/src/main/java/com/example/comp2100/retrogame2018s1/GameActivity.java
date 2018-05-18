
/**
*Created by Septian Razi, 19/04/2018
    Edited by Jasper McNiven 25/04/2018
    Edited by Kriti Tripathi, 07/05/2018
    ACtivity for the Game to be played
*/

package com.example.comp2100.retrogame2018s1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.concurrent.Semaphore;


public class GameActivity extends AppCompatActivity {
    public static Activity ga;

    public static Button button_pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ga = this;

        // the game state
        GlobalGameVariables.gameRunning = GameState.PRETOUCH;

        //making the buttons
        button_pause = findViewById(R.id.btn_pauseGame);
        final Button button_help = findViewById(R.id.btn_help);
        final Button button_quit = findViewById(R.id.btn_quit);

        //making the buttons functional
        button_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GlobalGameVariables.gameRunning == GameState.RUNNING) {
                    GlobalGameVariables.gameRunning = GameState.PAUSED;
                    button_pause.setText("Tap to Resume");
                }
            }
        });

        button_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GlobalGameVariables.gameRunning = GameState.PRETOUCH;
                Intent intent = new Intent(GameActivity.this, HelpActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                finish();
                startActivity(intent);
            }
        });

        button_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalGameVariables.gameRunning = GameState.PRETOUCH;
                Intent intent = new Intent(GameActivity.this, MainMenuActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                finish();
                startActivity(intent);

            }
        });

    }

    /** This method initialises global variables such as speed, gravity etc
    * when this method is called.
*/
    public void onStart() {
        super.onStart();
        GlobalGameVariables.gravity = 1.2f; // The speed at which objects falls
        GlobalGameVariables.jumpSpeed = (float) ((Math.sqrt(2.0 * GlobalGameVariables.gravity *
                (GlobalGameVariables.windowHeight *  GlobalGameVariables.jumpSpeedScaling))));
        GlobalGameVariables.scrollSpeed = GlobalGameVariables.defaultScrollSpeed;
    }

}
