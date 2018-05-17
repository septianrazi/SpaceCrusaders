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
        paint.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.ScoreFontSize));
    }

    @Override
    /**
     * Gets the current score and stores it locally
     * Also steps up the difficulty of the game according to the score
     */
    public void update() {
        currentScore = Scoring.getCurrentScore();
        if (currentScore >= 50)
        {
            GlobalGameVariables.scrollSpeed = GlobalGameVariables.scrollSpeed * 2.0f;
            GlobalGameVariables.gravity = GlobalGameVariables.gravity * 1.3f;
            GlobalGameVariables.jumpSpeed = GlobalGameVariables.jumpSpeed * 1.3f;
        }
        else if (currentScore >= 100)
        {
            GlobalGameVariables.scrollSpeed = GlobalGameVariables.scrollSpeed * 1.5f;
            GlobalGameVariables.gravity = GlobalGameVariables.gravity * 1.1f;
            GlobalGameVariables.jumpSpeed = GlobalGameVariables.jumpSpeed * 1.1f;
        }
    }

    @Override
    protected void OnDraw(Canvas canvas) {
        canvas.drawText(Integer.toString(currentScore), bounds.GetX(), bounds.GetY(), paint);
    }
}
