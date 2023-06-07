package com.miko.game.controller;

import com.miko.game.model.Asteroid;

import java.util.ArrayList;

public class AsteroidsController {
    private ArrayList<Asteroid> asteroids = new ArrayList<>();

    private void SpawnAsteroid()
    {
        asteroids.add(new Asteroid(1,1));
    }

    private void DestroyAsteroid(Asteroid asteroid)
    {
        asteroids.remove(asteroid);
    }
}
