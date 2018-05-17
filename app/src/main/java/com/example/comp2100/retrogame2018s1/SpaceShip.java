package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Septian Razi on 19-Apr-18.
 * Some edits by Jasper McNiven 25th onwards
 * Object for spaceship - character that the player controls
 */

public class SpaceShip extends GameObject {

    float speed = 0.0f;
    float yMax;
    float radius;
    Bitmap[] spaceshipImages = new Bitmap[3];

    public SpaceShip(Context context, Bounds bounds, @Nullable AttributeSet attrs) {
        super(context, attrs, bounds);

        this.radius = bounds.getWidth()/2;
        this.yMax = GlobalGameVariables.windowHeight;

        //Load the images for the spaceship
        spaceshipImages[0] = BitmapFactory.decodeResource(context.getResources(), R.drawable.idle_ufo);
        spaceshipImages[1] = BitmapFactory.decodeResource(context.getResources(), R.drawable.ini_ufo);
        spaceshipImages[2] = BitmapFactory.decodeResource(context.getResources(), R.drawable.jump_ufo);
        spaceshipImages[0].prepareToDraw();
        spaceshipImages[1].prepareToDraw();
        spaceshipImages[2].prepareToDraw();
    }

    /**
     * Update the variables of the spaceship - called when run
     */
    @Override
    public void update() {
        speed += GlobalGameVariables.gravity;

        if (bounds.GetY() >= yMax) {
            GlobalGameVariables.gameRunning = GameState.OVER;
            speed = 0;
        } else {
            bounds.SetY(bounds.GetY()+speed);
        }

        if (bounds.GetY() <= 50.0f) {
            bounds.SetY(50.0f);
            speed = 0;
        };

        for (GameObject o : GameView.gameObjects){
            if (collision(o)){
                if (o instanceof Obstacle)
                    GlobalGameVariables.gameRunning = GameState.OVER;
                else if (o instanceof Coin)
                    ((Coin) o).collided();
            }
        }

    }

    /**
     * Function to draw the spaceship character
     * @param canvas Canvas to draw on
     */
    @Override
    protected void OnDraw(Canvas canvas) {
        //canvas.drawCircle(this.bounds.GetX(),this.bounds.GetY(),this.bounds.getWidth(), p);
        int left = (int) (bounds.GetX() - bounds.getWidth()/2);
        int right = (int) (bounds.GetX() + bounds.getWidth()/2);
        int top = (int) (bounds.GetY() - bounds.getHeight()/2);
        int bottom = (int) (bounds.GetY() + bounds.getHeight()/2);
        Rect rect = new Rect(left, top, right, bottom);
        if (speed <= 0)
            canvas.drawBitmap(spaceshipImages[0], null, rect, null);
        else if (speed > GlobalGameVariables.jumpSpeed / 2)
            canvas.drawBitmap(spaceshipImages[2], null, rect, null);
        else
            canvas.drawBitmap(spaceshipImages[1], null, rect, null);
    }

    /**
     * Function to determine if spaceship character has collided with a given object
     * @param o The object we are detecting collision with
     * @return True if collision has been detected
     */
    public boolean collision (GameObject o){

        float distanceX = Math.abs(this.bounds.GetX() - o.bounds.GetX());
        float distanceY = Math.abs(this.bounds.GetY() - o.bounds.GetY());

        if (o instanceof Obstacle)
        {
            if (distanceX <= (o.bounds.width/2) + radius)
            {
                if (distanceY < ((o.bounds.getHeight() / 2) - radius))
                    return false;
                else
                    return true;
            }
            else
                return false;
        }
        else // Detect collision with a coin
        {
            if (distanceX <= radius && distanceY <= radius)
                return true;
            else
                return false;
        }
    }
}












