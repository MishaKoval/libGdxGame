package com.miko.game.model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {

    private Vector2 pos;

    private Rectangle borders;

    public Asteroid(float x,float y)
    {
        pos = new Vector2(x,y);
    }

    public Rectangle getBorders()
    {
        return borders;
    };

    public void SetBorders(float x,float y,int width,int height)
    {
        borders = new Rectangle(x,y,width,height);
    }

    public Vector2 getPos()
    {
        return pos;
    }
}
