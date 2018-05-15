package com.example.comp2100.retrogame2018s1;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class GameOverActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        getWindow().setLayout((int) (GlobalGameVariables.windowWidth*0.70),
                (int) (GlobalGameVariables.windowHeight*0.60));
    }
}
