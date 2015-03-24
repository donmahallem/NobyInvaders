package com.hendrik.invaders.engine.model;

/**
 * Created by Don on 24/03/2015.
 */
public abstract class View implements Renderable {
    protected float mX, mY, mZ = 0;
    protected float mRotationX = 0, mRotationY = 0, mRotationZ = 0;
    protected float mWidth, mHeight;
    private ViewGroup mParent;

    public float getX() {
        return this.mX;
    }

    public void setX(final float x) {
        this.mX = x;
    }

    public float getY() {
        return this.mY;
    }

    public void setY(final float y) {
        this.mY = y;
    }

    public float getZ() {
        return mZ;
    }

    public void setZ(float z) {
        mZ = z;
    }

    public float getRotationX() {
        return mRotationX;
    }

    public void setRotationX(float rotationX) {
        mRotationX = rotationX;
    }

    public float getRotationY() {
        return mRotationY;
    }

    public void setRotationY(float rotationY) {
        mRotationY = rotationY;
    }

    public float getRotationZ() {
        return mRotationZ;
    }

    public void setRotationZ(float rotationZ) {
        mRotationZ = rotationZ;
    }

    void setParent(final ViewGroup viewGroup) {
        if (this.mParent != null)
            throw new IllegalArgumentException("View has already a parent");
        this.mParent = viewGroup;
    }

    public void removeSelf() {
        if (this.mParent == null)
            return;
        this.mParent.remove(this);
        this.mParent = null;
    }
}
