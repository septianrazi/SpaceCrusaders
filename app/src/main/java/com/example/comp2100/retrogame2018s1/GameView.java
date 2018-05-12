package com.example.comp2100.retrogame2018s1;

import android.app.Application;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

import static com.example.comp2100.retrogame2018s1.GlobalGameVariables.effectsOn;

/**
 * Created by Septian Razi on 19-Apr-18.
 * Edited by Jasper McNiven to include the game loop and GameObject list
 * View used for GameActivity, contains the main game loop and central game logic
 */

public class GameView extends View implements View.OnTouchListener, Runnable {
    public Context context;

    private final int REFRESH_TIME = 1; // In milliseconds, e.g. 10 == 100Hz (100 updates per second)
    float xt = 200.0f;
    float yt = 200.0f;
    float speed = 10.0f;
    float yMax;
    Paint p;
    Handler timer;
    GameObjectList gameObjects = new GameObjectList();

    /**
     *
     * @param context
     * @param attrs
     */
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setOnTouchListener(this);
        this.context = context;

        this.p = new Paint();
        p.setColor(Color.RED);
        p.setStrokeWidth(3);

        // Set up the game loop
        timer = new Handler();
        timer.postDelayed(this,10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Draw all the GameObjects
        gameObjects.Draw(canvas);

        yMax = canvas.getHeight();
        canvas.drawCircle(xt,yt,50, p);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        speed =  -GlobalGameVariables.jumpSpeed;
        this.invalidate();
        System.out.println(effectsOn);
        System.out.println(context);
        if (effectsOn) {SoundEffectsManager.getInstance().initalizeMediaPlayer(context, R.raw.jump);
        SoundEffectsManager.getInstance().start();}

        return false;
    }

    // The below code is called by the handler and is the basis of this programs game loop
    @Override
    public void run() { // run/ gameloop are the same thing from our point of view

        // Update all the GameObjects
        gameObjects.Update();

        speed += GlobalGameVariables.gravity;

        if (yt >= yMax-100.0f)
        {
            speed = 0;
            p.setColor(Color.BLACK);
        } else {
            yt+= speed;
            p.setColor(Color.RED);
        }

        if (yt <= 50.0f)
        {
            yt = 50.0f;
            speed = 0;
            p.setColor(Color.BLUE);
        }
        this.invalidate();
        timer.postDelayed(this,REFRESH_TIME);
    }
}