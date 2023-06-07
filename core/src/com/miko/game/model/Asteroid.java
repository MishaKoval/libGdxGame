package com.miko.game.model;

import com.badlogic.gdx.math.Vector2;

public class Asteroid {

    private Vector2 pos;
    private float rotationAngle;

    public Asteroid(float x,float y)
    {
        pos = new Vector2(x,y);
    }

    public Vector2 getPos() {
        return pos;
    }

    public void CalcCollideWithPlayer()
    {

    }
}
