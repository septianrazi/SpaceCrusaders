package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import java.util.Random;

public class ObstacleGenerator {

    private static final int OBSTACLE_SPACING = 4 * GlobalGameVariables.windowWidth / 5;
    private static final int OBSTACLE_WIDTH = GlobalGameVariables.windowWidth / 4;
    private static final int OBSTACLE_HEIGHT = GlobalGameVariables.windowHeight / 4;
    private static Context context;
    private static AttributeSet attrs;

    // Set up initial obstacles

    /**
     *
     * @param GameView_context The context within which all the obstacles will be drawn
     * @param GameView_attrs Required parameter for use of views
     */
    public static void NewGame(Context GameView_context, @Nullable AttributeSet GameView_attrs)
    {
        context = GameView_context;
        attrs = GameView_attrs;
        GlobalGameVariables.obstacleVariation = GlobalGameVariables.windowHeight / 4;
        Random rand = new Random();
        int obstacleCount = 3;
        int xPos = GlobalGameVariables.windowWidth; //+ OBSTACLE_SPACING;
        for (int i = 0; i < obstacleCount; i++)
        {
            Bounds[] bounds = new Bounds[3];
            // Bounds 0 = The empty space through which the player must move
            int boundsHeight0 = GlobalGameVariables.windowHeight/4;
            int yPos = rand.nextInt(GlobalGameVariables.obstacleVariation) + (GlobalGameVariables.windowHeight / 2) - (GlobalGameVariables.obstacleVariation / 2);
            bounds[0] = new Bounds(xPos, yPos, OBSTACLE_WIDTH, boundsHeight0);
            // Bounds 1 = Top part of the obstacle
            int boundsHeight12 = boundsHeight0 * 2;
            yPos = yPos - (boundsHeight0 / 2) - (boundsHeight12 / 2);
            bounds[1] = new Bounds(xPos, yPos, OBSTACLE_WIDTH, boundsHeight12);
            // Bounds 2 = Bottom part of the obstacle
            yPos = yPos + boundsHeight12 + boundsHeight0;
            bounds[2] = new Bounds(xPos, yPos, OBSTACLE_WIDTH, boundsHeight12);
            // Make the new obstacle with the bounds calculated above
            Obstacle tmpOb = new Obstacle(context, attrs, null, null, bounds);
            GameView.gameObjects.add(tmpOb);
            xPos += OBSTACLE_SPACING;
        }
    }

    /**
     * This function takes in an obstacle from the GameObject list and resets its data (positions, etc)
     * Basically recycles the obstacles
     * @param obstacle The obstacle to be recycled
     */
    public static void ResetObstacle(Obstacle obstacle)
    {
        Random rand = new Random();
        int xPos = GlobalGameVariables.windowWidth = OBSTACLE_SPACING * 3;
        Bounds[] bounds = new Bounds[3];
        // Bounds 0 = The empty space through which the player must move
        int boundsHeight0 = GlobalGameVariables.windowHeight/4;
        int yPos = rand.nextInt(GlobalGameVariables.obstacleVariation) + (GlobalGameVariables.windowHeight / 2) - (GlobalGameVariables.obstacleVariation / 2);
        bounds[0] = new Bounds(xPos, yPos, OBSTACLE_WIDTH, boundsHeight0);
        // Bounds 1 = Top part of the obstacle
        int boundsHeight12 = boundsHeight0 * 2;
        yPos = yPos - (boundsHeight0 / 2) - (boundsHeight12 / 2);
        bounds[1] = new Bounds(xPos, yPos, OBSTACLE_WIDTH, boundsHeight12);
        // Bounds 2 = Bottom part of the obstacle
        yPos = yPos + boundsHeight12 + boundsHeight0;
        bounds[2] = new Bounds(xPos, yPos, OBSTACLE_WIDTH, boundsHeight12);
        // Make the new obstacle with the bounds calculated above
        Obstacle tmpOb = new Obstacle(context, attrs, null, null, bounds);
        int index = GameView.gameObjects.indexOf(obstacle);
        GameView.gameObjects.set(index, tmpOb);
    }

}
