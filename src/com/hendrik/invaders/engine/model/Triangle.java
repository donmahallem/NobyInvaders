package com.hendrik.invaders.engine.model;

import org.lwjgl.opengl.GL11;

/**
 * Created by Don on 24/03/2015.
 */
public class Triangle extends View {
    private float mProgress = 0;

    @Override
    public void render(float deltaT) {
        this.mProgress += deltaT;
        GL11.glBegin(GL11.GL_TRIANGLES);

        GL11.glColor3f(1f, 0f, 0f);
        GL11.glVertex2f(0f, 1f);

        GL11.glColor3f(0f, 1f, 0f);
        GL11.glVertex2f((float) (2f + Math.sin(this.mProgress)), 1f);

        GL11.glColor3f(0f, 0f, 1f);
        GL11.glVertex2f(1f, -1f);

        GL11.glEnd();
    }
}
