package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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

    /**
     *
     * @param context
     * @param attrs
     * @param image1 The image for the top part of the obstacle
     * @param image2 The image for the bottom part of the obstacle
     * @param bounds An array with the bounds of the empty space at index 0, then index 1 = top part
     *               index 2 = bottom part
     */
    public Obstacle(Context context, @Nullable AttributeSet attrs, Bitmap image1, Bitmap image2, Bounds[] bounds) {
        super(context, attrs, bounds[0]);

        this.allBounds = bounds;
        this.p = new Paint();
        p.setColor(Color.MAGENTA);
        p.setStrokeWidth(3);
    }

    @Override
    public void update() {
        for(int i = 0; i < allBounds.length; i++)
            allBounds[i].SetX(allBounds[i].GetX() - GlobalGameVariables.scrollSpeed);
        bounds.SetX(bounds.GetX() - GlobalGameVariables.scrollSpeed);
    }

    @Override
    protected void OnDraw(Canvas canvas) {
        for (int i = 0; i < allBounds.length; i++)
        {
            if (i == 1 || i == 2)
            {
                p.setColor(Color.MAGENTA);
            }
            else
            {
                p.setColor(Color.YELLOW);
            }
            float left = allBounds[i].GetX() - allBounds[i].getWidth()/2;
            float right = allBounds[i].GetX() + allBounds[i].getWidth()/2;
            float top = allBounds[i].GetY() - allBounds[i].getHeight()/2;
            float bottom = allBounds[i].GetY() + allBounds[i].getHeight()/2;
            canvas.drawRect(left, top, right, bottom, p);
        }
    }
}
