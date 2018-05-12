package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class ObstacleGenerator {

    private static final int OBSTACLE_SPACING = GlobalGameVariables.windowWidth;
    private static final int OBSTACLE_WIDTH = GlobalGameVariables.windowWidth / 4;
    private static Context context;
    private static AttributeSet attrs;

    // Set up initial obstacles

    public static void NewGame(Context GameView_context, @Nullable AttributeSet GameView_attrs)
    {
        context = GameView_context;
        attrs = GameView_attrs;
        int obstacleCount = 3;
        int xPos = GlobalGameVariables.windowWidth + OBSTACLE_SPACING;
        for (int i = 0; i < obstacleCount; i++)
        {
            Bounds[] bounds = new Bounds[3];
            bounds[0] = new Bounds(xPos, GlobalGameVariables.windowHeight/2, OBSTACLE_WIDTH, GlobalGameVariables.windowHeight/5);
            bounds[1] = new Bounds(xPos, 0, OBSTACLE_WIDTH, (GlobalGameVariables.windowHeight/5)*2);
            bounds[2] = new Bounds(xPos, (GlobalGameVariables.windowHeight/5)*3, OBSTACLE_WIDTH, (GlobalGameVariables.windowHeight/5)*2);
            Obstacle tmpOb = new Obstacle(context, attrs, null, null, bounds);
            GameView.gameObjects.add(tmpOb);
            xPos += OBSTACLE_SPACING;
        }
    }

    public Obstacle CreateObstacle()
    {
        return null;
    }

}
