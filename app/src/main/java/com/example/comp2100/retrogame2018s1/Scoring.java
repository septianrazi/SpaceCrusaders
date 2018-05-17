/**
 * Created by Jasper McNiven on 13/05/2018
 * This class takes care of the loading and storing of all scores for the game
 */

package com.example.comp2100.retrogame2018s1;

public class Scoring {

    private static int currentGameScore = 0;
    private static int scoreThresholdsCrossed = 0;

    /**
     * This methods takes in a value by which to increase the players score
     * Once the score crosses thresholds the difficulty increases
     * @param increment The value by which to increase the players score
     */
    public static void incrementCurrentScore(int increment) {
        currentGameScore = currentGameScore + increment;
        if (currentGameScore > 50 && scoreThresholdsCrossed == 0)
        {
            scoreThresholdsCrossed++;
            GlobalGameVariables.scrollSpeed = GlobalGameVariables.scrollSpeed * 1.3f;
            GlobalGameVariables.jumpSpeed = GlobalGameVariables.jumpSpeed * 1.3f;
            GlobalGameVariables.gravity = GlobalGameVariables.gravity * 1.3f;
            GlobalGameVariables.obstacleVariation = (int) (GlobalGameVariables.obstacleVariation * 1.3f);
        }
        else if (currentGameScore > 100 && scoreThresholdsCrossed == 1)
        {
            scoreThresholdsCrossed++;
            GlobalGameVariables.scrollSpeed = GlobalGameVariables.scrollSpeed * 1.3f;
            GlobalGameVariables.jumpSpeed = GlobalGameVariables.jumpSpeed * 1.3f;
            GlobalGameVariables.gravity = GlobalGameVariables.gravity * 1.3f;
            GlobalGameVariables.obstacleVariation = (int) (GlobalGameVariables.obstacleVariation * 1.3f);
        }
        else if (currentGameScore > 150 && scoreThresholdsCrossed == 2)
        {
            scoreThresholdsCrossed++;
            GlobalGameVariables.scrollSpeed = GlobalGameVariables.scrollSpeed * 1.3f;
            GlobalGameVariables.jumpSpeed = GlobalGameVariables.jumpSpeed * 1.3f;
            GlobalGameVariables.gravity = GlobalGameVariables.gravity * 1.3f;
            GlobalGameVariables.obstacleVariation = (int) (GlobalGameVariables.obstacleVariation * 1.3f);
        }
    }

    public static int getCurrentScore() {return currentGameScore; }
    public static void resetCurrentScore() { currentGameScore = 0; }

}
