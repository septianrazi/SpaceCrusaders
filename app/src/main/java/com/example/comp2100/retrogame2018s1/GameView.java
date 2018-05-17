/**
 * Created by Septian Razi on 19-Apr-18.
 * Edited by Jasper McNiven to include the game loop and GameObject list
 * View used for GameActivity, contains the main game loop and central game logic
 */

package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import static com.example.comp2100.retrogame2018s1.GlobalGameVariables.effectsOn;

public class GameView extends View implements View.OnTouchListener, Runnable {

    private final int REFRESH_TIME = 16; // In milliseconds, e.g. 16 ~= 60Hz (60 fps)



    SpaceShip spaceship;
    Handler timer;
    static GameObjectList gameObjects = new GameObjectList();

    /**
     * This constructor passes its parameters to the view it extends and runs all the code
     * necessary to initialise the game
     * @param context The context in which this view is located
     * @param attrs The arrtibutes of the context and activity
     */
    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setOnTouchListener(this);

        // Set up the game loop
        timer = new Handler();

        gameObjects.clear();

        // Initialise the players spaceship
        float spaceshipX = 2 * GlobalGameVariables.windowWidth / 5;
        float spaceshipY = GlobalGameVariables.windowHeight / 2;
        float spaceshipSize = GlobalGameVariables.windowWidth / 6;
        GlobalGameVariables.jumpSpeed = 16*GlobalGameVariables.gravity;//(float) Math.sqrt(2.0 * GlobalGameVariables.gravity * (GlobalGameVariables.windowHeight * (2/5)));
        spaceship = new SpaceShip(context, new Bounds(spaceshipX, spaceshipY, spaceshipSize,spaceshipSize), attrs);

        // Initialise the obstacles
        ObstacleGenerator.NewGame(context, attrs);

        // Initialise the coins
        CoinGenerator.newGame(context, attrs);

        // Initialise the score view
        float scoreViewX = GlobalGameVariables.windowWidth / 2;
        float scoreViewY = GlobalGameVariables.windowHeight / 6;
        Scoring.resetCurrentScore();
        gameObjects.add(new ScoreView(context, attrs, new Bounds(scoreViewX, scoreViewY, 0, 0)));
    }

    /**
     * This method is responsible for calling the onDraw() methods of every single GameObject in
     * the game. It is called itself by the main game loop
     * @param canvas The object with which to draw all the GameObjects
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw all the GameObjects
        gameObjects.Draw(canvas);
        spaceship.OnDraw(canvas);
    }

    /**
     * This method captures the event which fires when the player taps the screen
     * and runs the appropriate code depending on the gamestate
     * @param view The view in which the event happened
     * @param motionEvent The details of the event
     * @return Returns a boolean
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        // Prevent game from starting when its game over
        if (GlobalGameVariables.gameRunning == GameState.OVER) {
            return false;
        }

        // Un-pause the game if its paused
        if (GlobalGameVariables.gameRunning == GameState.PAUSED) {
            GameActivity.button_pause.setText("Pause Game");
            GlobalGameVariables.gameRunning = GameState.RUNNING;
            timer.postDelayed(this, 10);
        }
        else if (GlobalGameVariables.gameRunning != GameState.RUNNING) {
            GlobalGameVariables.gameRunning = GameState.RUNNING;
            timer.postDelayed(this,10);
        }

        // Run normal on touch/tap code if the games not paused
        if (GlobalGameVariables.gameRunning == GameState.RUNNING)
        {
            spaceship.speed =  -GlobalGameVariables.jumpSpeed;
            this.invalidate();
            if (effectsOn) {SoundEffectsManager.getInstance().initalizeMediaPlayer(getContext(), R.raw.jump);
                SoundEffectsManager.getInstance().start();}
        }
        return false;
    }

    /**
     * This method is the main game loop which calls all of the game logic. The looping of this
     * game loop is facilitated by the use of a handler called timer
     */
    @Override
    public void run() {

        // Update all the GameObjects
        gameObjects.Update();
        spaceship.update();

        // Alert the runtime to redraw this view (calls onDraw())
        this.invalidate();

        // Continue the loop or pause/ game over
        if (GlobalGameVariables.gameRunning == GameState.RUNNING)
            timer.postDelayed(this,REFRESH_TIME);
        if (GlobalGameVariables.gameRunning == GameState.OVER){
            getContext().startActivity(new Intent(getContext(), GameOverActivity.class));

        }
    }
}
