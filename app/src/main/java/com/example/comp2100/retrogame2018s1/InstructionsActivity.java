package com.example.comp2100.retrogame2018s1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/*
    Created and edited by Kriti  Tripathi, 07/05/2018
    Activity for the instructions of the game to be displayed */

public class InstructionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Define the return button
        final Button  button_return = findViewById(R.id.btn_return);

        // Implement it
        button_return.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               System.exit(0);
            }
        });


    }



}
