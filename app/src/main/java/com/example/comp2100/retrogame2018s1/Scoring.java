package com.example.comp2100.retrogame2018s1;

public class Scoring {

    private static int currentGameScore = 0;

    public static void incrementCurrentScore(int increment) { currentGameScore = currentGameScore + increment; }
    public static int getCurrentScore() {return currentGameScore; }
    public static void resetCurrentScore() { currentGameScore = 0; }

}
