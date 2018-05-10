package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;

import java.util.concurrent.Semaphore;


public class SoundEffectsManager extends Manager {
    private static SoundEffectsManager reference = null;
    public int soundID;

    MediaPlayer soundEffects;

    // Initialise if empty
    public static SoundEffectsManager getInstance(){
        if (reference == null){reference = new SoundEffectsManager();}
        return reference;
    }

    // Make constructor which creates background music
    public void initalizeMediaPlayer(Context context, int soundID){
        soundEffects = MediaPlayer.create(context, soundID);
        soundEffects.setLooping(false);

    }

    @Override
    public void start() {
        soundEffects.start();
        soundEffects.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }

    @Override
    public void stop() {soundEffects.stop();}
}
