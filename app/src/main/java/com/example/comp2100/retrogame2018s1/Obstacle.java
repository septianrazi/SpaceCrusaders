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

    Paint p;
    public Obstacle(Context context, Bitmap image, Bounds bounds, @Nullable AttributeSet attrs) {
        super(context, image, bounds, attrs);


        this.p = new Paint();
        p.setColor(Color.MAGENTA);
        p.setStrokeWidth(3);
    }

    @Override
    public void update() {
        bounds.SetX(bounds.GetX() - 5);
    }

    @Override
    protected void OnDraw(Canvas canvas) {
        float left = bounds.GetX() - bounds.getWidth()/2;
        float right = bounds.GetX() + bounds.getWidth()/2;
        float top = bounds.GetY() - bounds.getHeight()/2;
        float bottom = bounds.GetY() + bounds.getHeight()/2;
        canvas.drawRect(left, top, right, bottom, p);
    }
}
