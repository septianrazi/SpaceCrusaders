package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.content.Intent;
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

/*
    Created by Septian Razi, 19/04/2018
    Edited by Jasper McNiven 25/04/2018
    Edited by Kriti Tripathi, 07/05/2018
    ACtivity for the Game to be played
 */

public class GameActivity extends AppCompatActivity {
    private  static Context mContext;

    public static Context getContext() {
        return mContext;
    }

    public static void setContext(Context mContext1) {
        mContext = mContext1;
    }

    public GameActivity(){
        setContext(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GlobalGameVariables.gameRunning = GameState.PRETOUCH;

        final ImageView imageView_pause = findViewById(R.id.imageView_pause);

        final Button button_pause = findViewById(R.id.btn_pauseGame);
        final Button button_help = findViewById(R.id.btn_help);
        final Button button_quit = findViewById(R.id.btn_quit);

        button_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (GlobalGameVariables.gameRunning == GameState.RUNNING) {
                    GlobalGameVariables.gameRunning = GameState.PAUSED;
                    button_pause.setText("Resume Game");
                    imageView_pause.setVisibility(View.VISIBLE);
                }
                else {
                    GlobalGameVariables.gameRunning = GameState.RUNNING;
                    button_pause.setText("Pause Game");
                    imageView_pause.setVisibility(View.GONE);
                }
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
                System.exit(0);
            }
        });

    }

}
