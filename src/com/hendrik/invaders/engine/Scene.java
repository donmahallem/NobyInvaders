package com.hendrik.invaders.engine;

/**
 * Created by Don on 24/03/2015.
 */
public abstract class Scene {

    public void onCreate() {

    }

    public abstract void render(final float deltaT);

    public void onDestroy() {

    }
}
