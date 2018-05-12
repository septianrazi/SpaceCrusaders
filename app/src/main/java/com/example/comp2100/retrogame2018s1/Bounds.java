package com.example.comp2100.retrogame2018s1;

/**
 * Created by Jasper McNiven on 19/04/2018.
 * Used to store data on the x, y, width and height of an object
 */

public class Bounds {

    float x, y; // CENTRE Coordinates of Object
    float width, height; // Width and Height of Object

    public Bounds(float x, float y, float width, float height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void SetBounds(float x, float y, float width, float height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public float[] GetBounds()
    {
        float[] bounds = {x, y, width, height};
        return bounds;
    }

    public float GetX(){ return x; }
    public float GetY(){ return y; }
    public float getWidth(){ return width; }
    public float getHeight(){ return height; }

    public void SetPosition(float x, float y){ SetX(x); SetY(y);}
    public void SetX(float x){ this.x = x; }
    public void SetY(float y){ this.y = y; }
    public void SetWidth(float width){ this.width = width; }
    public void SetHeight(float height){ this.height = height; }

}
