package com.hendrik.invaders.engine.model;

import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Don on 24/03/2015.
 */
public class ViewGroup extends View {
    private List<View> mSprites = new ArrayList<View>();

    public void addSprite(final View sprite) {
        synchronized (this) {
            if (this.mSprites.contains(sprite) || sprite == null)
                return;
            sprite.setParent(this);
            this.mSprites.add(sprite);
        }
    }

    public void remove(final View sprite) {
        synchronized (this) {
            if (sprite != null && this.mSprites.contains(sprite)) {
                sprite.removeSelf();
            }
        }
    }

    @Override
    public void render(final float deltaT) {
        synchronized (this) {
            for (View sprite : this.mSprites) {
                GL11.glTranslatef(this.mX, this.mY, this.mZ);
                sprite.render(deltaT);
                GL11.glTranslatef(-this.mX, -this.mY, -this.mZ);
            }
        }
    }
}
