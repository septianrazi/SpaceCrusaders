package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Septian Razi on 19/04/2018.
 * Edited by Jasper McNiven 10/05/2018
 * Obstacle objects that the player will attempt to dodge
 */

public class Obstacle extends GameObject {

    private Paint p;
    private Bounds[] allBounds;
    private Bitmap top_image, bottom_image;

    /**
     *
     * @param context
     * @param attrs
     * @param top_image The image for the top part of the obstacle
     * @param bottom_image The image for the bottom part of the obstacle
     * @param allBounds An array with the bounds of the empty space/ gap at index 0, then index 1 = top part
     *               index 2 = bottom part
     */
    public Obstacle(Context context, @Nullable AttributeSet attrs, Bitmap top_image, Bitmap bottom_image, Bounds[] allBounds) {
        super(context, attrs, allBounds[0]);
        this.top_image = top_image;
        this.bottom_image = bottom_image;
        this.allBounds = allBounds;
        this.p = new Paint();
        p.setColor(Color.MAGENTA);
        p.setStrokeWidth(3);
    }

    @Override
    public void update() {
        // Check if the obstacle is still on the screen, if not delete it and make another
        if ((bounds.GetX() + bounds.getWidth() / 2) < 0)
        {
            //GameView.gameObjects.remove(this);
            ObstacleGenerator.ResetObstacle(this); // Replace the old obstacle with a new one
        }
        // Move the obstacle across the screen
        for(int i = 0; i < allBounds.length; i++)
            allBounds[i].SetX(allBounds[i].GetX() - GlobalGameVariables.scrollSpeed);
    }

    @Override
    protected void OnDraw(Canvas canvas) {
        // Draw the top part of the obstacle
        int left = (int) (allBounds[1].GetX() - allBounds[1].getWidth()/2);
        int right = (int) (allBounds[1].GetX() + allBounds[1].getWidth()/2);
        int top = (int) (allBounds[1].GetY() - allBounds[1].getHeight()/2);
        int bottom = (int) (allBounds[1].GetY() + allBounds[1].getHeight()/2);
        Rect rect = new Rect(left, top, right, bottom);
        //canvas.drawRect(left, top, right, bottom, p);
        canvas.drawBitmap(top_image, null, rect, null);

        // Draw the bottom part of the obstacle
        left = (int) (allBounds[2].GetX() - allBounds[2].getWidth()/2);
        right = (int) (allBounds[2].GetX() + allBounds[2].getWidth()/2);
        top = (int) (allBounds[2].GetY() - allBounds[2].getHeight()/2);
        bottom = (int) (allBounds[2].GetY() + allBounds[2].getHeight()/2);
        rect = new Rect(left, top, right, bottom);
        //canvas.drawRect(left, top, right, bottom, p);
        canvas.drawBitmap(bottom_image, null, rect, null);
    }

}
