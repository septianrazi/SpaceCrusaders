package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class ScoreView extends GameObject {

    private boolean displayScoreChange = false;

    private final int SCORE_CHANGED_DISPLAY_TIME = 60; // 60 ~= 1 second
    private int timeSinceScoreChange = 0;
    private int scoreChange = 0;
    private int currentScore = 0;
    private int lastScore = currentScore;
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
     * Also checks if the score has changed and if it has switches displayScoreChange to true
     * thus displaying the score change to the player
     */
    public void update() {
        lastScore = currentScore;
        currentScore = Scoring.getCurrentScore();

        if (currentScore - lastScore != 0) {
            displayScoreChange = true;
            scoreChange = currentScore - lastScore;
            timeSinceScoreChange = 0;
        }

        if (displayScoreChange)
            timeSinceScoreChange++;

        if (timeSinceScoreChange > SCORE_CHANGED_DISPLAY_TIME)
            displayScoreChange = false;
    }

    /**
     * Draws the score on the screen
     * @param canvas The object with which to draw the score
     */
    @Override
    protected void OnDraw(Canvas canvas) {
        String str = Integer.toString(currentScore) + (displayScoreChange ? " + " + Integer.toString(scoreChange):"");
        canvas.drawText(str, bounds.GetX(), bounds.GetY(), paint);
    }
}
