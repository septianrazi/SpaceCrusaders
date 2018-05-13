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

    private final int REFRESH_TIME = 16; // In milliseconds, e.g. 16 ~= 60Hz (60 fps)
    float yMax;

    float rectx = 1000;
    float recty = 670;
    int w;
    int h;

    SpaceShip spaceship;

    Paint p;
    Handler timer;
    static GameObjectList gameObjects = new GameObjectList();
    Obstacle obstacle;

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

        float spaceshipX = 2 * GlobalGameVariables.windowWidth / 5;
        float spaceshipY = 2 * GlobalGameVariables.windowHeight / 5;
        spaceship = new SpaceShip(context, null, new Bounds(spaceshipX, spaceshipY, 50,50), attrs);
        ObstacleGenerator.NewGame(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Draw all the GameObjects
        gameObjects.Draw(canvas);

        yMax = canvas.getHeight();
        spaceship.OnDraw(canvas);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        spaceship.speed =  -GlobalGameVariables.jumpSpeed;
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
        spaceship.update();

//        speed += GlobalGameVariables.gravity;
//
//        if (yt >= yMax-100.0f)
//        {
//            speed = 0;
//            spaceship.p.setColor(Color.BLACK);
//        } else {
//            yt+= speed;
//            spaceship.p.setColor(Color.RED);
//        }
//
//        if (yt <= 50.0f)
//        {
//            yt = 50.0f;
//            speed = 0;
//            spaceship.p.setColor(Color.BLUE);
//        }
//        spaceship.bounds.SetPosition(xt, yt);
        this.invalidate();
        timer.postDelayed(this,REFRESH_TIME);
    }
}