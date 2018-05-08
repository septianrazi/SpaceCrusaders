package com.example.comp2100.retrogame2018s1;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;


/*
    Created and edited by Kriti  Tripathi, 07/05/2018
    Activity for the options of the game such as difficulty to be displayed */

public class OptionsActivity extends AppCompatActivity {
    public static Switch switch_sound;
    public int current_speed, current_gravity;

        @Override
    protected void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_options);

        final Button button_return_2 = findViewById(R.id.btn_returnFromOptions);
        switch_sound = findViewById(R.id.switch_sound);
        final SeekBar seekBar_speed = findViewById(R.id.sb_speed);
        final SeekBar seekBar_gravity = findViewById(R.id.sb_gravity);
        final RadioButton button_easy = findViewById(R.id.btn_easy);
        final RadioButton button_medium = findViewById(R.id.btn_medium);
        final RadioButton button_hard = findViewById(R.id.btn_hard);
        final RadioGroup radioGroup = findViewById(R.id.group_difficulty);
        final TextView txt_speed = findViewById(R.id.txt_speed);
        final TextView txt_gravity = findViewById(R.id.txt_gravity);
        final TextView txt_sound = findViewById(R.id.txt_sound);

        current_speed = seekBar_speed.getProgress();
        current_gravity = seekBar_gravity.getProgress();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int selectedID) {
                if (selectedID == button_easy.getId()){
                    seekBar_speed.setProgress(2);
                    txt_speed.setText("Speed: 2");
                    seekBar_gravity.setProgress(2);
                    txt_gravity.setText("Gravity: 2");
                    current_speed = 2;
                    current_gravity = 2;
                }
                if (selectedID == button_medium.getId()){
                    seekBar_speed.setProgress(5);
                    txt_speed.setText("Speed: 5");
                    seekBar_gravity.setProgress(5);
                    txt_gravity.setText("Gravity: 5");
                    current_speed = 5;
                    current_gravity = 5;
                }
                if (selectedID == button_hard.getId()){
                    seekBar_speed.setProgress(8);
                    txt_speed.setText("Speed: 8");
                    seekBar_gravity.setProgress(9);
                    txt_gravity.setText("Gravity: Earth!");
                    current_speed = 8;
                    current_gravity = 9;
                }
            }
        });


        seekBar_speed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                current_speed = progress;
                txt_speed.setText("Speed: " + progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        seekBar_gravity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                current_gravity = progress;
                if (progress < 9){
                txt_gravity.setText("Gravity: " + progress);}
                else if (progress == 9){txt_gravity.setText("Gravity: Earth");}
                else {txt_gravity.setText("Gravity: Greater than Earth's!");}

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        button_return_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        switch_sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!b) {ManageMusic.getInstance().stop();
                txt_sound.setText("Sound is off!");
                }
                if (b) {
                    ManageMusic.getInstance().initalizeMediaPlayer(OptionsActivity.this, R.raw.ring);
                    ManageMusic.getInstance().start();
                    txt_sound.setText("Sound is on!");
                }
            }
        });

    }



}
