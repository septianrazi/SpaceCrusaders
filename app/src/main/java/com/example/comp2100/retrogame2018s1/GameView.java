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
 *
 * View used for GameActivity, contains the main game loop and central game logic
 */

public class GameView extends View implements View.OnTouchListener, Runnable {
    public Context context;

    private final int REFRESH_TIME = 16; // In milliseconds, e.g. 16 ~= 60Hz (60 fps)
    float yMax;

    SpaceShip spaceship;

    Paint p;
    Handler timer;
    static GameObjectList gameObjects = new GameObjectList();

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

        // Initialise the players spaceship
        float spaceshipX = 2 * GlobalGameVariables.windowWidth / 5;
        float spaceshipY = GlobalGameVariables.windowHeight / 2;
        spaceship = new SpaceShip(context, null, new Bounds(spaceshipX, spaceshipY, 50,50), attrs);

        // Initialise the obstacles
        ObstacleGenerator.NewGame(context, attrs);

        // Initialise the score view
        float scoreViewX = GlobalGameVariables.windowWidth / 2;
        float scoreViewY = GlobalGameVariables.windowHeight / 6;
        gameObjects.add(new ScoreView(context, attrs, new Bounds(scoreViewX, scoreViewY, 0, 0)));
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

        // Prevent game from starting when its game over
        if (GlobalGameVariables.gameRunning == GameState.OVER) {
            return false;
        }

        // Un-pause the game if its paused
        if (GlobalGameVariables.gameRunning != GameState.RUNNING) {
            GlobalGameVariables.gameRunning = GameState.RUNNING;
            timer.postDelayed(this,10);
        }

        if (GlobalGameVariables.gameRunning == GameState.RUNNING)
        { // Run normal on touch/tap code if the games not paused
            spaceship.speed =  -GlobalGameVariables.jumpSpeed;
            this.invalidate();
            System.out.println(effectsOn);
            System.out.println(context);
            if (effectsOn) {SoundEffectsManager.getInstance().initalizeMediaPlayer(context, R.raw.jump);
                SoundEffectsManager.getInstance().start();}
        }
        return false;
    }

    // The below code is called by the handler and is the basis of this programs game loop
    @Override
    public void run() { // run/ gameloop are the same thing from our point of view

        // Update all the GameObjects
        gameObjects.Update();
        spaceship.update();

        this.invalidate();
        if (GlobalGameVariables.gameRunning == GameState.RUNNING)
            timer.postDelayed(this,REFRESH_TIME);
    }
}