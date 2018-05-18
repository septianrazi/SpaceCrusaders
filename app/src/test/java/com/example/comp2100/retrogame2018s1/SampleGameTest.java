/**
 * This test is a simple integration test that checks the whole game logic code by use of a
 * simulated play session
 */
package com.example.comp2100.retrogame2018s1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SampleGameTest {

    @Test
    public void simulateGameTest()
    {
        // Initialise game logic
        GlobalGameVariables.windowWidth = 800;
        GlobalGameVariables.windowHeight = 1200;
        GlobalGameVariables.obstacleVariation = GlobalGameVariables.windowHeight / 3;
        GameView gameView = new GameView(null, null);
        GlobalGameVariables.gameRunning = GameState.RUNNING;

        // Check that the game objects (coins and obstacles) were initialised correctly
        assertEquals(7, GameView.gameObjects.size());
        checkObstacles();
        checkCoins();

        // Run the game for 10 frames (0.166 seconds) and check if the player has moved
        // Test fails if the player hasn't moved
        int oldPlayerY = (int) gameView.spaceship.bounds.y;
        for (int i = 0; i < 60; i++)
            gameView.spaceship.update();
        assertNotEquals(oldPlayerY, (int) gameView.spaceship.bounds.y);

        // Try the pause feature
        GlobalGameVariables.gameRunning = GameState.PAUSED;

        // Run the game for 10 frames (0.166 seconds) test fails if anything has moved
        oldPlayerY = (int) gameView.spaceship.bounds.y;
        for (int i = 0; i < 60; i++)
            GameView.gameObjects.Update();
        assertTrue(oldPlayerY == (int) gameView.spaceship.bounds.y);

        // Test collision with an obstacle
        GlobalGameVariables.gameRunning = GameState.RUNNING;
        GlobalGameVariables.gravity = 0;
        gameView.spaceship.bounds.SetY(50);

        // Run game for 30 seconds (1800 frames)
        for (int i = 0; i < 1800; i++)
            {
            GameView.gameObjects.Update();
            gameView.spaceship.update();
            }
        //Check if we have collided with an obstacle
        assertTrue(GlobalGameVariables.gameRunning == GameState.OVER);

    }

    private void checkObstacles()
    {
        // Check that all 3 obstacles are of the screen at the start
        for (int i = 0; i < 3; i++)
            assertTrue((GameView.gameObjects.get(i).bounds.GetX() > GlobalGameVariables.windowWidth));
    }

    private void checkCoins()
    {
        // Check that all the coins are of the screen initially
        for (int i = 0; i < 3; i++)
            assertTrue((GameView.gameObjects.get(i).bounds.GetX() > GlobalGameVariables.windowWidth));
    }

}

