/**
 * These tests makes sure that the coin generator works as its supposed to
 */

package com.example.comp2100.retrogame2018s1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CoinGeneratorTest {

    @Test
    public void testCoinGeneratorNewGame() {
        // Set some values needed for the code to work
        GlobalGameVariables.windowHeight = 1200;
        GlobalGameVariables.windowWidth = 800;
        GlobalGameVariables.obstacleVariation = GlobalGameVariables.windowHeight / 3;

        // Generate the coins
        CoinGenerator.newGame(null, null);

        // Check that 3 coins have been generated
        assertEquals(3, GameView.gameObjects.size());

        // Check that all the coins are of the screen initially
        for (int i = 0; i < 3; i++)
            assertTrue((GameView.gameObjects.get(i).bounds.GetX() > GlobalGameVariables.windowWidth));
    }

    @Test
    public void testCoinReset()
    {
        // Set some values needed for the code to work
        GlobalGameVariables.windowHeight = 1200;
        GlobalGameVariables.windowWidth = 800;
        GameView.gameObjects.clear();

        // Make a coin to test
        Coin testCoin;
        Bounds bounds = new Bounds(50, 50, 50, 50);
        testCoin = new Coin(null, null, bounds);
        GameView.gameObjects.add(testCoin);

        // Reset the coin
        CoinGenerator.resetCoin(testCoin);

        // Check that the reset coin is in the list
        assertEquals(1, GameView.gameObjects.size());

        // Check that the reset coin is off the screen
        assertTrue((GameView.gameObjects.get(0).bounds.GetX() > GlobalGameVariables.windowWidth));
    }

}
