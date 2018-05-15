package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class ScoreView extends GameObject {

    private int currentScore = 0;
    private Paint paint;

    public ScoreView(Context context, @Nullable AttributeSet attrs, Bounds bounds)
    {
        super(context, attrs, bounds);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(50);
    }

    @Override
    public void update() {
        currentScore = Scoring.getCurrentScore();
    }

    @Override
    protected void OnDraw(Canvas canvas) {
        canvas.drawText(Integer.toString(currentScore), bounds.GetX(), bounds.GetY(), paint);
    }
}
