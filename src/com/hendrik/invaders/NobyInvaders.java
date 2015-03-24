package com.hendrik.invaders;

import com.hendrik.invaders.engine.NobyEngine;

/**
 * Created by Don on 24/03/2015.
 */
public class NobyInvaders {
    private static NobyEngine mNobeEngine = new NobyEngine();

    public static void main(String... args) {
        mNobeEngine.setScene(new InvadersScene());
        mNobeEngine.run();
    }
}
