package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.media.MediaPlayer;

/*    Created and edited by Kriti Tripathi, 08/05/2018
      This class allows the background music and sounds to be easily handled.
 */

public class ManageMusic {
    private static ManageMusic reference = null;
    MediaPlayer backgroundMusic;

    public static ManageMusic getInstance(){
        if (reference == null){reference = new ManageMusic();}
        return reference;
    }

    public void initalizeMediaPlayer(Context context, int musicId){

        backgroundMusic = MediaPlayer.create(context, musicId);
        backgroundMusic.setLooping(true);
    }

    public void start(){backgroundMusic.start();}

    public void stop(){backgroundMusic.stop();}


}
