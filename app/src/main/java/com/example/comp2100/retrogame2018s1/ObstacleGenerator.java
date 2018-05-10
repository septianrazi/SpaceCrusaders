package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class ObstacleGenerator {

    Context context;
    AttributeSet attrs;

    // Set up initial obstacles
    public ObstacleGenerator(Context context, @Nullable AttributeSet attrs)
    {
        this.context = context;
        this.attrs = attrs;
    }

    public Obstacle CreateObstacle()
    {
        return null;
    }

}
