package com.hendrik.invaders.engine.util;

/**
 * Created by Don on 24/03/2015.
 */
public class Rect {
    public float x, y, width, height;

    public boolean intercect(final Rect rect) {
        if (rect == null)
            throw new IllegalArgumentException("Rect parameter must not be null");
        if (rect.x > x && rect.x < this.x + this.width) {
        }
        return true;

    }
}
