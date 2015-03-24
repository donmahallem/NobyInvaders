package com.hendrik.invaders;

/**
 * Created by Don on 24/03/2015.
 */
public class Log {

    private final static String DEFAULT_TAG = "NobyInvaders";

    public static final void d(String message) {
        d(DEFAULT_TAG, message);
    }

    public static final void d(String tag, String message) {
        System.out.println(System.currentTimeMillis() + " - " + tag + " : " + message);
    }
}
