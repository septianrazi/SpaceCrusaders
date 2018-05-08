package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.media.MediaPlayer;

/*    Created and edited by Kriti Tripathi, 08/05/2018
      This class allows the background music and sounds to be easily handled.
 */

public abstract class Manager {


    // Make constructor which creates background music
    public void initalizeMediaPlayer(Context context, int musicId){
    }

    // Play the music

    public abstract void start();


    // Stop it
    public abstract void stop();

}
