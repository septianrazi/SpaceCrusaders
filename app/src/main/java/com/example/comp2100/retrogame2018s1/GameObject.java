package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/*
    Created by Jasper McNiven, 19/04/2018
    This class is the base class for all the visible objects in the game.
    e.g. the player or obstacles
 */

public abstract class GameObject extends View
{

    Bounds bounds;
    float xVel, yVel;

    public GameObject(Context context, @Nullable AttributeSet attrs, Bounds bounds) {
        super(context, attrs);
        this.bounds = bounds;
        this.xVel = 0;
        this.yVel = 0;
    }

    public abstract void update();
    protected abstract void OnDraw(Canvas canvas);
}