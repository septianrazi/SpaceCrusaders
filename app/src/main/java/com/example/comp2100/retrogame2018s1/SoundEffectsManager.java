package com.example.comp2100.retrogame2018s1;

import android.content.Context;

public class SoundEffectsManager extends Manager {
    private static SoundEffectsManager reference = null;

    // Initialise if empty
    public static SoundEffectsManager getInstance(){
        if (reference == null){reference = new SoundEffectsManager();}
        return reference;
    }

    // Make constructor which creates background music
    public void initalizeMediaPlayer(Context context, int musicId){
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
