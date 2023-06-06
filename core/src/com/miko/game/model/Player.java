package com.miko.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;

public class Player
{
    private float moveSpeed;
    private Texture texture;
    private Vector2 pos;

    private float rotationAngle;
    public Player()
    {
        moveSpeed = 100;
        texture = new Texture("space-shooter-spritepack/PNG/playerShip2_red.png");
        pos = new Vector2(Gdx.graphics.getWidth()/2.0f,Gdx.graphics.getHeight()/2.0f);
    }

    public void SetMoveSpeed(float newSpeed)
    {
        moveSpeed = newSpeed;
    }
    public Vector2 getPos()
    {
        return pos;
    };

    public float GetRotation()
    {
        return rotationAngle;
    }

    public void setPos(Vector2 newPos)
    {
        pos = newPos;
    }

    public Texture getTexture()
    {
        return texture;
    };

    public void Move(Vector2 dir)
    {
        float multiplier = moveSpeed * Gdx.graphics.getDeltaTime();
        pos.add(dir.scl(multiplier));
    }

    public void Rotate(float angle)
    {
        rotationAngle = angle;
    }
}
