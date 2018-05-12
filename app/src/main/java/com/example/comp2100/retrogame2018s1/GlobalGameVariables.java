package com.example.comp2100.retrogame2018s1;

/**
 * Created by Jasper McNiven on 19/04/2018.
 * This class contains a list of variables which are used throughout the various game classes
 */


public class GlobalGameVariables {
    public static float gravity = 3.7f; // The speed at which objects falls
    public static float jumpSpeed = 40.0f; // The velocity applied to any jumping object/ character
    public static float scrollSpeed = 2.0f; // The speed at which the screen scrolls
    public static boolean soundOn = true; // This is the user setting which is true if the sound swith is on in the options menu and false otherwise
    public static boolean effectsOn = true; // Sound effects setting being stored
    public static int characterRadius = 50; // The radius of the character used for collision
    public static int windowWidth; // The width of the window
    public static int windowHeight; // The height of the window
}
