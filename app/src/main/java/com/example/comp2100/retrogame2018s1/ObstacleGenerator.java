package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import java.util.Random;

public class ObstacleGenerator {

    private static final int OBSTACLE_SPACING = 4 * GlobalGameVariables.windowWidth / 5;
    private static final int OBSTACLE_WIDTH = GlobalGameVariables.windowWidth / 3;
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
        int xPos = GlobalGameVariables.windowWidth + OBSTACLE_SPACING * 2;
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
            // Load the obstacles images
            Bitmap top_image = decodeSampledBitmapFromResource(context.getResources(), R.drawable.obstacle, OBSTACLE_WIDTH, boundsHeight12);
            Bitmap bottom_image = decodeSampledBitmapFromResource(context.getResources(), R.drawable.obstacle, OBSTACLE_WIDTH, boundsHeight12);
            // Make the new obstacle with the bounds and images calculated above
            Obstacle tmpOb = new Obstacle(context, attrs, top_image, bottom_image, bounds);
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
        // Load the obstacles images
        Bitmap top_image = decodeSampledBitmapFromResource(context.getResources(), R.drawable.obstacle, OBSTACLE_WIDTH, boundsHeight12);
        Bitmap bottom_image = decodeSampledBitmapFromResource(context.getResources(), R.drawable.obstacle, OBSTACLE_WIDTH, boundsHeight12);
        // Make the new obstacle with the bounds and images calculated above
        Obstacle tmpOb = new Obstacle(context, attrs, top_image, bottom_image, bounds);
        int index = GameView.gameObjects.indexOf(obstacle);
        GameView.gameObjects.set(index, tmpOb);
    }

    // The following code was not written by any members of our team, it is the property of Android Dev
    // The full code sample can be found at https://developer.android.com/topic/performance/graphics/load-bitmap
    // Used under the following licence: https://creativecommons.org/licenses/by/3.0/
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
}
