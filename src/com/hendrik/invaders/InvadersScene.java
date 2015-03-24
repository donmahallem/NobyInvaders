package com.hendrik.invaders;

import com.hendrik.invaders.engine.Scene;
import com.hendrik.invaders.engine.model.Triangle;
import com.hendrik.invaders.engine.model.ViewGroup;

/**
 * Created by Don on 24/03/2015.
 */
public class InvadersScene extends Scene {
    private ViewGroup mViewGroup;
    private Triangle mTriangle = new Triangle();

    public InvadersScene() {
        this.mViewGroup = new ViewGroup();
        this.mViewGroup.addSprite(this.mTriangle);
    }

    @Override
    public void render(float deltaT) {
        Log.d("Delta: " + deltaT);
        this.mViewGroup.render(deltaT);
    }
}
