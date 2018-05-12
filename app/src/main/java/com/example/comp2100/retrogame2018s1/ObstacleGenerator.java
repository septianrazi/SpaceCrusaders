package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class ObstacleGenerator {

    private static final int OBSTACLE_SPACING = GlobalGameVariables.windowWidth;
    private static final int OBSTACLE_WIDTH = GlobalGameVariables.windowWidth / 4;
    private static final int OBSTACLE_HEIGHT = GlobalGameVariables.windowHeight / 5;
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
            float bound0y = GlobalGameVariables.windowHeight/2;
            bounds[0] = new Bounds(xPos, bound0y, OBSTACLE_WIDTH, OBSTACLE_HEIGHT);
            float bound1height = GlobalGameVariables.windowHeight - bound0y - OBSTACLE_HEIGHT/2;
            bounds[1] = new Bounds(xPos, bound1height/2, OBSTACLE_WIDTH, bound1height);
            float bound2top = (bound0y + OBSTACLE_HEIGHT/2);
            float bound2height = GlobalGameVariables.windowHeight - bound2top;
            bounds[2] = new Bounds(xPos, bound2top + bound2height/2, OBSTACLE_WIDTH, bound2height);
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
