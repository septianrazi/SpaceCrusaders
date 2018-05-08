package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.media.MediaPlayer;

public class MusicManager extends Manager {

    private static MusicManager reference = null;
    MediaPlayer backgroundMusic;

    // Initialise if empty
    public static MusicManager getInstance(){
        if (reference == null){reference = new MusicManager();}
        return reference;
    }

    // Make constructor which creates background music
    public void initalizeMediaPlayer(Context context, int musicId){
        backgroundMusic = MediaPlayer.create(context, musicId);
        backgroundMusic.setLooping(true);
    }

    @Override
    public void start() {backgroundMusic.start();}

    @Override
    public void stop() {backgroundMusic.stop();}
}
