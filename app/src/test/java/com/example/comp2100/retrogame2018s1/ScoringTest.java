/**
 * This class tests that the scoring works properly for the game
 */

package com.example.comp2100.retrogame2018s1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ScoringTest {

    @Test
    public void testScoring()
    {
        // Check that the current score is 0
        assertEquals(0, Scoring.getCurrentScore());

        //Increment and retest the current score
        Scoring.incrementCurrentScore(5);
        assertEquals(5, Scoring.getCurrentScore());

        //Increment and retest the current score
        Scoring.incrementCurrentScore(5);
        assertEquals(10, Scoring.getCurrentScore());

        //Increment and retest the current score
        Scoring.incrementCurrentScore(5);
        assertEquals(15, Scoring.getCurrentScore());

        // Reset the score and test
        Scoring.resetCurrentScore();
        assertEquals(0, Scoring.getCurrentScore());

        // Test the high score functionality
        Scoring.incrementCurrentScore(10);
        Scoring.addCurrentScore();
        Scoring.resetCurrentScore();
        Scoring.incrementCurrentScore(15);
        Scoring.addCurrentScore();
        Scoring.resetCurrentScore();
        assertEquals(15, Scoring.getHighScore());
    }

}
