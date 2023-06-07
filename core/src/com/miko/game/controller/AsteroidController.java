package com.miko.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.miko.game.model.Asteroid;

public class AsteroidController
{
    private Asteroid asteroid;

    public AsteroidController(Asteroid asteroid)
    {
        this.asteroid = asteroid;
    }

    public /*boolean*/ void isCollideWithPlayer(Vector2 playerPos)
    {
        /*return*/ if(asteroid.getBorders().contains(playerPos))
        {
            Gdx.app.log("Collide", "!!!");
        };
    }
}
