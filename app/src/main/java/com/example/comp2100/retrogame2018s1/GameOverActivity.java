package com.example.comp2100.retrogame2018s1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class GameOverActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_over);

        getWindow().setLayout((int) (GlobalGameVariables.windowWidth*0.5),
                (int) (GlobalGameVariables.windowHeight*0.75));
    }
}
