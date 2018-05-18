/**
 * Created By Jasper McNiven on 15/05/2018
 * This class holds the methods that generate and recycle coins for the game
 */

package com.example.comp2100.retrogame2018s1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;

import java.util.Random;

/**
 *
 */
public class CoinGenerator {

    private static final int COIN_SPACING = 4 * GlobalGameVariables.windowWidth / 5;
    private static final int COIN_WIDTH = GlobalGameVariables.windowWidth / 12;
    private static final int COIN_HEIGHT = COIN_WIDTH;
    private static int lastCoinX = 0;
    private static Context context = null;
    private static AttributeSet attrs = null;

    public static Bitmap coinImage;

    /**
     * This method is responsible for loading the image for the coins as well as setting the initial
     * coins for the game
     * @param game_context
     * @param game_attrs
     */
    public static void newGame(Context game_context, AttributeSet game_attrs) {
        context = game_context;
        attrs = game_attrs;

        //Load the image for the coins
        coinImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.coin);
        coinImage.prepareToDraw();

        // Generate the initial coins
        int coinCount = 3;
        Random rand = new Random();
        int xPos = GlobalGameVariables.windowWidth + COIN_SPACING * 3;
        for (int i = 0; i < coinCount; i++)
        {
            // Set the bounds of the coin(s)
            int yPos = rand.nextInt(GlobalGameVariables.obstacleVariation) + (GlobalGameVariables.windowHeight / 2) - (GlobalGameVariables.obstacleVariation / 2);
            Bounds bounds = new Bounds(xPos + COIN_SPACING / 2, yPos, COIN_WIDTH, COIN_HEIGHT);

            // Make the new coin with the bounds above
            Coin tmpCoin = new Coin(context, attrs, bounds);
            GameView.gameObjects.add(tmpCoin);
            xPos += COIN_SPACING * 3;
        }
        lastCoinX = xPos;
    }

    /**
     * This method takes in a coin that is either of the screen or has been collided with
     * and resets its data (positions etc)
     * @param coin the coin to be recycled
     */
    public static void resetCoin(Coin coin) {
        Random rand = new Random();
        int xPos = lastCoinX;
        int yPos = rand.nextInt(GlobalGameVariables.obstacleVariation) + (GlobalGameVariables.windowHeight / 2) - (GlobalGameVariables.obstacleVariation / 2);
        Bounds bounds = new Bounds(xPos + COIN_SPACING / 2, yPos, COIN_WIDTH, COIN_HEIGHT);

        // Make the new coin with the bounds above
        Coin tmpCoin = new Coin(context, attrs, bounds);
        int index = GameView.gameObjects.indexOf(coin);
        GameView.gameObjects.set(index, tmpCoin);
    }

}
