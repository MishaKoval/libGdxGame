package com.miko.game.controller;

import com.badlogic.gdx.math.Vector2;
import com.miko.game.model.Asteroid;
import com.miko.game.view.AsteroidView;

public class AsteroidController
{
    private Asteroid asteroid;

    private AsteroidView asteroidView;

    public AsteroidController(Asteroid asteroid,AsteroidView asteroidView)
    {
        this.asteroid = asteroid;
        this.asteroidView = asteroidView;
    }

    public boolean isCollideWithPlayer(Vector2 playerPos)
    {
        return asteroid.getBorders().contains(playerPos);
    }

    public void dispose()
    {
        asteroidView.dispose();
    }
}
