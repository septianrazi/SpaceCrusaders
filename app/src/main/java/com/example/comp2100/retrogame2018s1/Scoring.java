/**
 * Created by Jasper McNiven on 13/05/2018
 * This class takes care of the loading and storing of all scores for the game
 */

package com.example.comp2100.retrogame2018s1;

import java.util.ArrayList;

public class Scoring {

    private static int currentGameScore = 0;
    private static int scoreThresholdsCrossed = 0;
    private static ArrayList<Integer> scores = new ArrayList<>();

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

    /**
     * This function resets the current score and increments the amount of scores achieved in this
     * game session
     */
    public static void resetCurrentScore() {
        scores.add(currentGameScore);
        currentGameScore = 0;
    }

    /**
     * This function returns the high score
     * @return high score (int)
     */
    public static int getHighScore() {
        Integer highScore = null;
        for (int i = 0; i < scores.size(); i++)
        {
            if (highScore == null || highScore < scores.get(i))
                highScore = scores.get(i);
        }
        return highScore;
    }

    /**
     * This function adds the current score to the list of old scores
     */
    public static void addCurrentScore() { scores.add(currentGameScore); }

    /**
     * Returns the current score
     * @return the current score
     */
    public static int getCurrentScore() {return currentGameScore; }

}
