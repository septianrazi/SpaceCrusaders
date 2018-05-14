package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * Created by Septian Razi on 19-Apr-18.
 * Object for spaceship - character that the player controls
 */

public class SpaceShip extends GameObject {

    float speed = 0.0f;
    float yMax;

    float radius;
    Paint p;
    public SpaceShip(Context context, Bitmap image, Bounds bounds, @Nullable AttributeSet attrs) {
        super(context, attrs, bounds);


        this.radius = bounds.getWidth()/2;

        this.p = new Paint();
        p.setColor(Color.GREEN);
        p.setStrokeWidth(3);
    }

    @Override
    public void update() {
        speed += GlobalGameVariables.gravity;

        if (bounds.GetY() >= yMax-100.0f)
        {
            speed = 0;
            p.setColor(Color.BLACK);
        } else {
            bounds.SetY(bounds.GetY()+speed);
            p.setColor(Color.RED);
        }

        if (bounds.GetY() <= 50.0f) {
            bounds.SetY(50.0f);
            speed = 0;
            p.setColor(Color.BLUE);
        };

        for (GameObject o : GameView.gameObjects){
            if (collision(o)){
                p.setColor(Color.CYAN);
            }
        }
    }

    @Override
    protected void OnDraw(Canvas canvas) {

        yMax = canvas.getHeight();
        canvas.drawCircle(this.bounds.GetX(),this.bounds.GetY(),this.bounds.getWidth(), p);

    }

    /**
     * Function to determine if spaceship character has collided with a given object
     * @param o The object we are detecting collision with
     * @return True if collision has been detected
     */
    public boolean collision (GameObject o){
        float distanceX = Math.abs(this.bounds.GetX() - o.bounds.GetX());
        float distanceY = Math.abs(this.bounds.GetY() - o.bounds.GetY());

        if (distanceX <= (o.bounds.width/2) + radius)
        {
            if (distanceY < ((o.bounds.getHeight() / 2) - radius))
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }
//        if (distanceX > (o.bounds.getWidth()/2 + radius)) { return false; }
//        if (distanceY > (o.bounds.getHeight()/2 + radius)){ return false;}
//
//        if (distanceX <= (o.bounds.width/2)) { return true; }
//        if (distanceY <= (o.bounds.height/2)) { return true; }
//
//        float distanceToCorner = ((distanceX - o.bounds.getWidth()/2)*(distanceX - o.bounds.getWidth()/2))+
//                ((distanceY - o.bounds.getHeight()/2)*(distanceY - o.bounds.getHeight()/2));

        //return (distanceToCorner <= (radius*radius));
    }

}












