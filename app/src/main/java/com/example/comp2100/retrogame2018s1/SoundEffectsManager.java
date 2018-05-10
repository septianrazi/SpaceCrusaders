package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;

public class SoundEffectsManager extends Manager {
    private static SoundEffectsManager reference = null;
    public int soundID;

    SoundPool soundPool;
    SoundPool.Builder soundpoolBuilder;
    AudioAttributes audioAttributes;
    AudioAttributes.Builder aabuilder;

    // Initialise if empty
    public static SoundEffectsManager getInstance(){
        if (reference == null){reference = new SoundEffectsManager();}
        return reference;
    }

    // Make constructor which creates background music
    public void initalizeSoundPool(Context context, int soundID){
        aabuilder = new AudioAttributes.Builder();
        aabuilder.setUsage(AudioAttributes.USAGE_GAME);
        aabuilder.setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION);
        audioAttributes = aabuilder.build();
        soundpoolBuilder = new SoundPool.Builder();
        soundpoolBuilder.setAudioAttributes(audioAttributes);
        soundPool = soundpoolBuilder.build();
        this.soundID = soundID;

    }

    public void play(){soundPool.play(soundID, 10, 10, 1, 0, 1);}

    @Override
    public void start() {}

    @Override
    public void stop() {}
}
