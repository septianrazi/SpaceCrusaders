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

    float yMax;
    float radius;
    int currentImage = 0;
    Bitmap[] spaceshipImages = new Bitmap[3];

    /**
     * This constructor takes in the parameters and deals with them appropriately
     * It also loads and prepares the spaceship images
     * @param context
     * @param bounds
     * @param attrs
     */
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
     * Update the variables of the spaceship, check collision and set the appropriate image.
     * Called from the main game loop
     */
    @Override
    public void update() {

        // Update the speed of the spaceship and check the bottom of the screen hasn't been hit
        yVel += GlobalGameVariables.gravity;

        if (bounds.GetY() >= yMax) {
            GlobalGameVariables.gameRunning = GameState.OVER;
            yVel = 0;
        } else {
            bounds.SetY(bounds.GetY()+yVel);
        }

        if (bounds.GetY() <= 50.0f) {
            bounds.SetY(50.0f);
            yVel = 0;
        };

        // Check for collision with any GameObjects
        for (GameObject o : GameView.gameObjects){
            if (collision(o)){
                if (o instanceof Obstacle)
                    GlobalGameVariables.gameRunning = GameState.OVER;
                else if (o instanceof Coin)
                    ((Coin) o).collided();
            }
        }

        // Set the current spaceship image according to the yVel
        if (yVel <= 0)
            currentImage = 2;
        else if (yVel < GlobalGameVariables.jumpSpeed / 2)
            currentImage = 1;
        else
            currentImage = 0;

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
        canvas.drawBitmap(spaceshipImages[currentImage], null, rect, null);
    }

    /**
     * Function to determine if spaceship character has collided with a given object
     * @param o The object we are detecting collision with
     * @return True if collision has been detected
     */
    public boolean collision (GameObject o){

        // Get the distance to the center of the GameObject from the spaceship
        float distanceX = Math.abs(this.bounds.GetX() - o.bounds.GetX());
        float distanceY = Math.abs(this.bounds.GetY() - o.bounds.GetY());

        if (o instanceof Obstacle) // Detect collision with an obstacle
        {
            if (distanceX <= (o.bounds.width/2) + radius)
            {
                if (bounds.GetY() > o.bounds.GetY()) // Takes into account the empty space in the spaceship image
                {
                    float tmpRadius = 3.0f/10.0f * radius;
                    if (distanceY < ((o.bounds.getHeight() / 2) - tmpRadius))
                        return false;
                    else
                        return true;
                }
                else
                {
                    if (distanceY < ((o.bounds.getHeight() / 2) - radius))
                        return false;
                    else
                        return true;
                }
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












