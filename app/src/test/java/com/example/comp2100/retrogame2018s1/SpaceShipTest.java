package com.example.comp2100.retrogame2018s1;

import org.junit.Test;

/**
 * Created by u6086829 on 18/05/18.
 */

public class SpaceShipTest {

    @Test
    public void collisionTest(){
        Bounds bounds = new Bounds(50,50,100,100);
        SpaceShip sp = new SpaceShip(null, bounds, null);
        ObstacleGenerator.NewGame(null,null);
        //assertTrue
    }
}
