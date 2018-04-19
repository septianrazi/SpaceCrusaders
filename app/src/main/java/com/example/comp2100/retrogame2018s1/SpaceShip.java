package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Septian Razi on 19-Apr-18.
 * Object for spaceship - character that the player controls
 */

public class SpaceShip extends GameObject {
    public SpaceShip(Context context, Bitmap image, Bounds bounds, @Nullable AttributeSet attrs) {
        super(context, image, bounds, attrs);
    }

    @Override
    protected void OnDraw(Canvas canvas) {

    }
}
