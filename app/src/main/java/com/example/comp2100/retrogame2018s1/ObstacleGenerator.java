package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class ObstacleGenerator {

    private static final int OBSTACLE_SPACING = 200;
    private static final int OBSTACLE_WIDTH = 60;
    private static Context context;
    private static AttributeSet attrs;

    // Set up initial obstacles

    public static void NewGame(Context GameView_context, @Nullable AttributeSet GameView_attrs)
    {
        context = GameView_context;
        attrs = GameView_attrs;
        int obstacleCount = 3;
        int xPos = GlobalGameVariables.windowWidth; //+ OBSTACLE_SPACING;
        int yPos = 0;
        for (int i = 0; i < obstacleCount; i++)
        {
            Obstacle tmpOb = new Obstacle(context, null, new Bounds(xPos, yPos, OBSTACLE_WIDTH, GlobalGameVariables.windowHeight), attrs);
            GameView.gameObjects.add(tmpOb);
            xPos += OBSTACLE_SPACING;
        }
    }

    public Obstacle CreateObstacle()
    {
        return null;
    }

}
