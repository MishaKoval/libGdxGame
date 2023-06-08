package com.miko.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.miko.game.model.Asteroid;

public class AsteroidController
{
    private final Asteroid asteroid;

    public AsteroidController(Asteroid asteroid)
    {
        this.asteroid = asteroid;
    }

    public void update()
    {
        asteroid.move();
        calcOutOfBorders();
    }

    public boolean isCollideWithPlayer(Vector2 playerPos)
    {
        return asteroid.getBorders().contains(playerPos);
    }

    private void calcOutOfBorders()
    {
        Vector2 currentPos = asteroid.getPos();

        if(currentPos.x > Gdx.graphics.getWidth())
        {
            Vector2 newPos = new Vector2(0,currentPos.y);
            asteroid.setPos(newPos);
        }

        if(currentPos.x < 0)
        {
            Vector2 newPos = new Vector2(Gdx.graphics.getWidth()-1,currentPos.y);
            asteroid.setPos(newPos);
        }

        if(currentPos.y > Gdx.graphics.getHeight())
        {
            Vector2 newPos = new Vector2(currentPos.x,0);
            asteroid.setPos(newPos);
        }

        if(currentPos.y < 0)
        {
            Vector2 newPos = new Vector2(currentPos.x,Gdx.graphics.getHeight() - 1);
            asteroid.setPos(newPos);
        }
    }
}
