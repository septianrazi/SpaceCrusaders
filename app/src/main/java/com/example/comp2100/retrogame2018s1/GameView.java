package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Septian Razi on 19-Apr-18.
 * View used for GameActivity
 */

public class GameView extends View implements View.OnTouchListener, Runnable {
    float xt = (float) 200.0;
    float yt = (float) 200.0;
    float speed = (float) 10.0;
    float yMax;
    Paint p;
    Handler timer;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setOnTouchListener(this);
        timer = new Handler();
        timer.postDelayed(this,10);

        this.p = new Paint();
        p.setColor(Color.RED);
        p.setStrokeWidth(3);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        yMax = canvas.getHeight();
        canvas.drawCircle(xt,yt,50, p);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        speed =  -100.0f;

        //this.invalidate();

        return false;
    }

    @Override
    public void run() {
        speed += GlobalGameVariables.gravity;

        if (yt >= yMax-100.0f)
        {
            speed = 0;
            p.setColor(Color.BLACK);
        } else {
            yt+= speed;
            p.setColor(Color.RED);
        }


        if (yt <= 50.0f)
        {
            yt = 50.0f;
            speed = 0;
            p.setColor(Color.BLUE);
        }

        this.invalidate();
        timer.postDelayed(this,1);
    }
}