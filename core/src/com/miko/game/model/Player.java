package com.miko.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Player
{
    private float moveSpeed;
    private Vector2 pos;
    private float rotationAngle;
    public Player()
    {
        moveSpeed = 100;
        pos = new Vector2(Gdx.graphics.getWidth()/2.0f,Gdx.graphics.getHeight()/2.0f);
    }

    public void reset()
    {
        pos = new Vector2(Gdx.graphics.getWidth()/2.0f,Gdx.graphics.getHeight()/2.0f);
        rotationAngle = 0;
    }

    public Vector2 getPos()
    {
        return pos;
    }
    public void setPos(Vector2 newPos)
    {
        pos = newPos;
    }

    public float getRotation()
    {
        return rotationAngle;
    }

    public void move(Vector2 dir)
    {
        float multiplier = moveSpeed * Gdx.graphics.getDeltaTime();
        pos.add(dir.scl(multiplier));
    }

    public void rotate(float angle)
    {
        rotationAngle = angle;
    }
}
