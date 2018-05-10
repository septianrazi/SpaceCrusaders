package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Septian Razi on 19/04/2018.
 * Edited by Jasper McNiven 10/05/2018
 * Obstacle objects that the player will attempt to dodge
 */

public class Obstacle extends GameObject {

    public Obstacle(Context context, Bitmap image, Bounds bounds, @Nullable AttributeSet attrs) {
        super(context, image, bounds, attrs);
    }

    @Override
    public void update() {

    }

    @Override
    protected void OnDraw(Canvas canvas) {

    }
}
