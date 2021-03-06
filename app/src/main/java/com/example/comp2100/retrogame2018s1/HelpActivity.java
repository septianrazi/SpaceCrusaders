package com.example.comp2100.retrogame2018s1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/* This class was created and edited by Kriti Tripathi on 17/05/18
* */
public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Define the return button
        final Button button_returnHelp = findViewById(R.id.btn_helpResume);

        // Implement it
        button_returnHelp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                startActivity(new Intent(HelpActivity.this, GameActivity.class));
            }
        });


    }
}
