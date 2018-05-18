/**
 * Created by Jasper McNiven to check that the generation of obstacles is as it should be
 */

package com.example.comp2100.retrogame2018s1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ObstacleGeneratorTest {

    @Test
    public void testObstacleNewGame()
    {
        // Set some values needed for the code to work
        GlobalGameVariables.windowHeight = 1200;
        GlobalGameVariables.windowWidth = 800;

        // Generate the obstacles
        ObstacleGenerator.NewGame(null, null);

        // Check that 3 obstacles have been generated
        assertEquals(3, GameView.gameObjects.size());

        // Check that all 3 obstacles are of the screen at the start
        for (int i = 0; i < 3; i++)
            assertTrue((GameView.gameObjects.get(i).bounds.GetX() > GlobalGameVariables.windowWidth));
    }

    @Test
    public void testObstacleReseting()
    {
        // Set some values needed for the code to work
        GlobalGameVariables.windowHeight = 1200;
        GlobalGameVariables.windowWidth = 800;

        // Generate a test obstacle
        Obstacle testObstacle;
        Bounds[] obstacleBounds = new Bounds[3];
        obstacleBounds[0] = new Bounds(50, 50, 100, 400);
        obstacleBounds[1] = new Bounds(50, 450, 100, 400);
        obstacleBounds[2] = new Bounds(50, -350, 100, 400);
        testObstacle = new Obstacle(null, null, 0, 0, obstacleBounds);
        GameView.gameObjects.add(testObstacle);

        // Reset the obstacle
        ObstacleGenerator.ResetObstacle(testObstacle);

        // Check that the list has the new obstacle in it
        assertEquals(1, GameView.gameObjects.size());

        // Check that the obstacle is off the screen
        assertTrue((GameView.gameObjects.get(0).bounds.GetX() > GlobalGameVariables.windowWidth));
    }

}
