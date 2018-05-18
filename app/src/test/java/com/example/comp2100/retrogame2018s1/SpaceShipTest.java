package com.example.comp2100.retrogame2018s1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by u6086829 on 18/05/18.
 */

public class SpaceShipTest {

    @Test
    public void collisionTest() {
        // Set some values needed for the code to work
        GlobalGameVariables.windowHeight = 1200;
        GlobalGameVariables.windowWidth = 800;
        GlobalGameVariables.obstacleVariation = GlobalGameVariables.windowHeight / 3;
        Bounds spBounds = new Bounds(50, 50, 100, 100);
        SpaceShip sp = new SpaceShip(null, spBounds, null);

        Obstacle testObstacle;
        Bounds[] obstacleBounds = new Bounds[3];
        obstacleBounds[0] = new Bounds(50, 50, 100, 400);
        obstacleBounds[1] = new Bounds(50, 450, 100, 400);
        obstacleBounds[2] = new Bounds(50, -350, 100, 400);
        testObstacle = new Obstacle(null, null, 0, 0, obstacleBounds);

        GameView.gameObjects.add(testObstacle);

        GlobalGameVariables.gameRunning = GameState.RUNNING;
        sp.update();

        // There should be no collision with the above parameters so the game should still be running
        assertEquals(GameState.RUNNING, GlobalGameVariables.gameRunning);

        obstacleBounds[0] = new Bounds(50, 450, 100, 400);
        obstacleBounds[1] = new Bounds(50, 50, 100, 400);
        obstacleBounds[2] = new Bounds(50, -350, 100, 400);
        testObstacle = new Obstacle(null, null, 0, 0, obstacleBounds);
        GameView.gameObjects.clear();
        GameView.gameObjects.add(testObstacle);

        sp.update();

        // There should be collision with the above parameters so the game should be over
        assertEquals(GameState.OVER, GlobalGameVariables.gameRunning);
    }
}