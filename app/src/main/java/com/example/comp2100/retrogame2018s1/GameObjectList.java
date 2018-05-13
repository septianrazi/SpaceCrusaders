package com.example.comp2100.retrogame2018s1;

import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by Septian Razi on 21-Apr-18.
 * Class that holds all the game objects
 */

public class GameObjectList extends ArrayList<GameObject>{

    // Created by Jasper McNiven
    // Updates all the GameObjects held in the list
    public void Update()
    {
        for (GameObject gObject : this) {
            gObject.update();
        }
    }

    // Created by Jasper McNiven
    // Draws all the GameObjects held in the list
    public void Draw(Canvas canvas)
    {
        for (GameObject gObject : this) {
            gObject.OnDraw(canvas);
        }
    }

    // Created by Jasper McNiven
    // Returns all the obstacles in the GameObject list
    public GameObjectList GetObstacles()
    {
        GameObjectList obstacles = new GameObjectList();
        for (GameObject gObject : this){
            if (gObject instanceof Obstacle)
                obstacles.add(gObject);
        }
        return obstacles;
    }

}
