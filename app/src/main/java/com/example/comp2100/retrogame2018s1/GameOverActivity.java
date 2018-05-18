package com.example.comp2100.retrogame2018s1;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Activity for the GameOver Screen
 * Created by Septian Razi on 16 May 2018
 */
public class GameOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Set window so it seems like a pop up instead of an entire different activity
        getWindow().setLayout((int) (GlobalGameVariables.windowWidth*1),
                (int) (GlobalGameVariables.windowHeight*1));

        final Button button_replay = findViewById(R.id.btn_replay);
        final Button button_exit = findViewById(R.id.btn_exitOver);
        button_replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOverActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                GameActivity.ga.finish();
                Intent intent = new Intent(GameOverActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });

        TextView scoreText = (TextView) findViewById(R.id.scoreText);
        scoreText.setText("Score: " + Integer.toString(Scoring.getCurrentScore()));
        TextView highscoreText = (TextView) findViewById(R.id.highscoreText);
        if (Scoring.getCurrentScore() > Scoring.getHighScore())
            highscoreText.setText("New High Score: " + Integer.toString(Scoring.getHighScore()) + "!");
        else
            highscoreText.setText("High Score: " + Integer.toString(Scoring.getHighScore()));
    }
}
