package com.example.comp2100.retrogame2018s1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/*
    Created and edited by Kriti  Tripathi, 07/05/2018
    Activity for the options of the game such as difficulty to be displayed */

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_options);

        final Button button_return_2 = findViewById(R.id.btn_returnFromOptions);
        button_return_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
}
