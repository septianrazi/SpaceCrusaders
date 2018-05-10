package com.example.comp2100.retrogame2018s1;


import android.content.Intent;
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

import static com.example.comp2100.retrogame2018s1.GlobalGameVariables.gravity;
import static com.example.comp2100.retrogame2018s1.GlobalGameVariables.scrollSpeed;
import static com.example.comp2100.retrogame2018s1.GlobalGameVariables.soundOn;
import static com.example.comp2100.retrogame2018s1.GlobalGameVariables.effectsOn;


/*
    Created and edited by Kriti  Tripathi, 07/05/2018
    Activity for the options of the game such as difficulty to be displayed */

public class OptionsActivity extends AppCompatActivity {
    public static Switch switch_music, switch_effects;
    public int current_speed, current_gravity;
    final String GRAVITY = "Gravity is: ";
    final String SPEED = "Speed is: ";
    public TextView txt_speed, txt_gravity, txt_music, txt_effects;

    @Override
    protected void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        setContentView(R.layout.activity_options);

        // Making a button
        final Button button_return_2 = findViewById(R.id.btn_returnFromOptions);

        // Creating and configuring switches
        switch_music = findViewById(R.id.switch_music);
        switch_effects = findViewById(R.id.switch_effects);
        switch_music.setChecked(soundOn);
        switch_music.setChecked(effectsOn);

        // Setting seek bars
        final SeekBar seekBar_speed = findViewById(R.id.sb_speed);
        final SeekBar seekBar_gravity = findViewById(R.id.sb_gravity);

        // Making radio group and its corresponding radio buttons
        final RadioButton button_easy = findViewById(R.id.btn_easy);
        final RadioButton button_medium = findViewById(R.id.btn_medium);
        final RadioButton button_hard = findViewById(R.id.btn_hard);
        final RadioGroup radioGroup = findViewById(R.id.group_difficulty);

        // Defining text fields
        txt_speed = findViewById(R.id.txt_speed);
        txt_gravity = findViewById(R.id.txt_gravity);
        txt_music = findViewById(R.id.txt_music);
        txt_effects = findViewById(R.id.txt_effects);

        seekBar_speed.setProgress((int)(scrollSpeed));
        seekBar_gravity.setProgress((int)(gravity));

        // setting local variables
        current_speed = seekBar_speed.getProgress();
        current_gravity = seekBar_gravity.getProgress();
        setGlobalVariables();

        // Detects a change in the radioGroup and accordingly sets the value of the two seekbars
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int selectedID) {
                if (selectedID == button_easy.getId()){
                    seekBar_speed.setProgress(2);
                    seekBar_gravity.setProgress(2);
                    current_speed = 2;
                    current_gravity = 2;
                    setText();

                }
                if (selectedID == button_medium.getId()){
                    seekBar_speed.setProgress(5);
                    seekBar_gravity.setProgress(5);
                    current_speed = 5;
                    current_gravity = 5;
                    setText();
                }
                if (selectedID == button_hard.getId()){
                    seekBar_speed.setProgress(8);
                    seekBar_gravity.setProgress(9);
                    current_speed = 8;
                    current_gravity = 9;
                    setText();
                }
            }

        });

        // Detects a change in the speed seekbar and saves it
        seekBar_speed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                current_speed = progress;
                setText();
                setGlobalVariables();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });

        // Detects a change in the gravity seekbar and saves it
        seekBar_gravity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                current_gravity = progress;
                setText();
                setGlobalVariables();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        // Make sures that the return button on the screen works
        button_return_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {finish();}
        });

        // Whenever it detects a change in the sound switch, it either starts or stops the music depending on whether the switch is on or ff
        switch_music.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isOn) {
                if (!isOn) {
                    MusicManager.getInstance().stop();
                txt_music.setText("Sound is off!");
                } else {
                    MusicManager.getInstance().initalizeMediaPlayer(OptionsActivity.this, R.raw.ring);
                    MusicManager.getInstance().start();
                    txt_music.setText("Sound is on!");
                }
                soundOn = isOn;
                System.out.println(isOn);
            }
        });

        switch_effects.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isOn) {
                if (!isOn){txt_effects.setText("Effects are off!"); }
                else {txt_effects.setText("Effects are on!");}
                effectsOn = isOn;
                System.out.println(isOn);
            }
        });

    }

    //Setting the global variables to the changed seekbar values
    public void setGlobalVariables(){
            scrollSpeed = current_speed;
            gravity = current_gravity;
    }

    public void setText(){
        txt_speed.setText(SPEED + current_speed);
        txt_gravity.setText(GRAVITY + current_gravity);
    }

}
