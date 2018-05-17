package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import java.util.Random;

public class CoinGenerator {

    private static final int OBSTACLE_SPACING = 4 * GlobalGameVariables.windowWidth / 5;
    private static final int COIN_WIDTH = GlobalGameVariables.windowWidth / 7;
    private static final int COIN_HEIGHT = GlobalGameVariables.windowHeight / 7;
    private static Context context;
    private static AttributeSet attrs;

    public static Bitmap coinImage;

    public static void newGame(Context game_context, AttributeSet game_attrs) {
        context = game_context;
        attrs = game_attrs;
        coinImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.coin);
        int coinCount = 3;
        Random rand = new Random();
        int xPos = GlobalGameVariables.windowWidth + OBSTACLE_SPACING * 2;
        for (int i = 0; i < coinCount; i++)
        {
            int yPos = rand.nextInt(GlobalGameVariables.obstacleVariation) + (GlobalGameVariables.windowHeight / 2) - (GlobalGameVariables.obstacleVariation / 2);
            Bounds bounds = new Bounds(xPos + OBSTACLE_SPACING / 2, yPos, COIN_WIDTH, COIN_HEIGHT);
            // Make the new coin with the bounds above
            Coin tmpCoin = new Coin(context, attrs, bounds);
            GameView.gameObjects.add(tmpCoin);
            xPos += OBSTACLE_SPACING;
        }
    }

    public static void resetCoin(Coin coin) {
        Random rand = new Random();
        int xPos = GlobalGameVariables.windowWidth = OBSTACLE_SPACING * 3;
        int yPos = rand.nextInt(GlobalGameVariables.obstacleVariation) + (GlobalGameVariables.windowHeight / 2) - (GlobalGameVariables.obstacleVariation / 2);
        Bounds bounds = new Bounds(xPos + OBSTACLE_SPACING / 2, yPos, COIN_WIDTH, COIN_HEIGHT);
        // Make the new coin with the bounds above
        Coin tmpCoin = new Coin(context, attrs, bounds);
        int index = GameView.gameObjects.indexOf(coin);
        GameView.gameObjects.set(index, tmpCoin);
    }

}
