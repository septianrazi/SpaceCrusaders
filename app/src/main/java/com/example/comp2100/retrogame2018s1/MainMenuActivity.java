package com.example.comp2100.retrogame2018s1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/*
    Created and edited by Kriti  Tripathi, 19/04/2018
    Activity for the menu display
 */

public class MainMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final Button button_game = findViewById(R.id.btn_newGame);
        final Button button_options = findViewById(R.id.btn_options);
        final Button button_instructions = findViewById(R.id.btn_instructions);
        final Button button_exit = findViewById(R.id.btn_exit);
        final TextView txtView = findViewById(R.id.txt_insturctions);


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


        button_exit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.exit(0);
            }
        });


    }

}
