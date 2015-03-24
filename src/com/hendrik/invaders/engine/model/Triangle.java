package com.hendrik.invaders.engine.model;

import com.hendrik.invaders.engine.util.Point;
import org.lwjgl.opengl.GL11;

/**
 * Created by Don on 24/03/2015.
 */
public class Triangle extends View {

    private Point mPoint1 = new Point(0f, 1f), mPoint2 = new Point(1f, 0f), mPoint3 = new Point(-1f, 0f);

    public void setPoint1(final float x, final float y) {
        this.mPoint2.x = x;
        this.mPoint2.y = y;
        orderPoints();
    }

    public void setPoint2(final float x, final float y) {
        this.mPoint2.x = x;
        this.mPoint2.y = y;
        orderPoints();
    }

    public void setPoint3(final float x, final float y) {
        this.mPoint2.x = x;
        this.mPoint2.y = y;
        orderPoints();
    }

    private void orderPoints() {
        synchronized (this) {
            //TODO KREUZPRODUKT
        }
    }

    @Override
    public void render(float deltaT) {
        GL11.glBegin(GL11.GL_TRIANGLES);

        GL11.glColor3f(1f, 0f, 0f);
        GL11.glVertex2f(this.mPoint1.x, this.mPoint1.y);

        GL11.glColor3f(0f, 1f, 0f);
        GL11.glVertex2f(this.mPoint2.x, this.mPoint2.y);

        GL11.glColor3f(0f, 0f, 1f);
        GL11.glVertex2f(this.mPoint3.x, this.mPoint3.y);

        GL11.glEnd();
    }
}
