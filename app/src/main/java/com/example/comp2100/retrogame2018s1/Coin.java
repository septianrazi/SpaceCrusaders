package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class Coin extends GameObject {

    private int coinScoreValue = 5;

    public Coin(Context context, @Nullable AttributeSet attrs, Bounds bounds)
    {
        super(context, attrs, bounds);
    }

    public void collided()
    {
        Scoring.incrementCurrentScore(coinScoreValue);
    }

    @Override
    public void update() {
        bounds.SetX(bounds.GetX() - GlobalGameVariables.scrollSpeed);
    }

    @Override
    protected void OnDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(bounds.GetX(), bounds.GetY(), bounds.getWidth() / 2, paint);
    }
}
