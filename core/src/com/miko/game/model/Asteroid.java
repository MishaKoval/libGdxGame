package com.miko.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {

    private Vector2 pos;

    private final float moveSpeed;

    private float width;

    private final Vector2 dir;

    private float height;

    public Asteroid(Vector2 pos)
    {
        this.pos = pos;
        moveSpeed = 75;
        float directionAngle = MathUtils.random(0, 359);
        float xOffset = (float) Math.sin(Math.toRadians(directionAngle));
        float yOffset = (float) Math.cos(Math.toRadians(directionAngle));
        dir = new Vector2(xOffset,yOffset);
    }

    public void move()
    {
        float multiplier = moveSpeed * Gdx.graphics.getDeltaTime();
        pos.add(dir.cpy().scl(multiplier));
    }

    public Rectangle getBorders()
    {
        return new Rectangle(pos.x - width / 2.0f,pos.y - height / 2.0f,width,height);
    };

    public void setBordersSize(int width,int height)
    {
        this.width = width;
        this.height = height;
    }
    public Vector2 getPos()
    {
        return pos;
    }

    public void setPos(Vector2 newPos)
    {
        pos = newPos;
    }
}
