package com.example.comp2100.retrogame2018s1;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Activity for the GameOver Screen
 * Created by Septian Razi on 16 May 2018
 */
public class GameOverActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Set window so it seems like a pop up instead of an entire different activity
        getWindow().setLayout((int) (GlobalGameVariables.windowWidth*0.70),
                (int) (GlobalGameVariables.windowHeight*0.60));

        final Button button_replay = findViewById(R.id.btn_replay);
        button_replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameOverActivity.this, GameActivity.class);
                startActivity(intent);
            }
        });

        TextView text = (TextView) findViewById(R.id.scoreText);
        text.setText(""+getIntent().getIntExtra("SCORE", -1));

    }
}
