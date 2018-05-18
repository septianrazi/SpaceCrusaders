/**
 * Created by Jasper McNiven on 15/05/2018
 * This class holds all the data necessary for displaying a coin on the screen
 */

package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import static com.example.comp2100.retrogame2018s1.GlobalGameVariables.effectsOn;

public class Coin extends GameObject {

    private int coinScoreValue = 5;

    /**
     * This constructor deals withs its parameters by passing them to the view it extends through GameObject
     * @param context The context in which this coin exists
     * @param attrs The attributes of the context
     * @param bounds The bounds within which to draw the coin
     */
    public Coin(Context context, @Nullable AttributeSet attrs, Bounds bounds)
    {
        super(context, attrs, bounds);
    }

    /**
     * This method is called when the players spaceship collides with this coin
     * in which case a sound effect is played, the score is incremented and the
     * coin is reset to a new position by the CoinGenerator
     */
    public void collided()
    {
        Scoring.incrementCurrentScore(coinScoreValue);
        if (effectsOn) {SoundEffectsManager.getInstance().initalizeMediaPlayer(this.getContext(), R.raw.coin);
            SoundEffectsManager.getInstance().start();}
        CoinGenerator.resetCoin(this);
    }

    /**
     * This methods is called by the main game loop and moves the coin across the screen
     * and resets it if its off the left side of the screen
     */
    @Override
    public void update() {
        bounds.SetX(bounds.GetX() - GlobalGameVariables.scrollSpeed);
        if ((bounds.GetX() + bounds.getWidth() / 2) < 0)
        {
            CoinGenerator.resetCoin(this); // Replace the old coin with a new one
        }
    }

    /**
     * This method is called by the main game loop and draws the coin to the screen
     * using canvas
     * @param canvas The canvas object with which to draw the coin
     */
    @Override
    protected void OnDraw(Canvas canvas) {
        int left = (int) (bounds.GetX() - bounds.getWidth()/2);
        int right = (int) (bounds.GetX() + bounds.getWidth()/2);
        int top = (int) (bounds.GetY() - bounds.getHeight()/2);
        int bottom = (int) (bounds.GetY() + bounds.getHeight()/2);
        Rect rect = new Rect(left, top, right, bottom);
        canvas.drawBitmap(CoinGenerator.coinImage, null, rect, null);
    }
}
