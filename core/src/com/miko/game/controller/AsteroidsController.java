package com.miko.game.controller;

import com.miko.game.model.Asteroid;
import com.miko.game.view.AsteroidView;

import java.util.ArrayList;

public class AsteroidsController {
    private ArrayList<Asteroid> asteroids = new ArrayList<>();

    private ArrayList<AsteroidView> asteroidViews = new ArrayList<>();

    public void SpawnAsteroid()
    {
        Asteroid asteroid = new Asteroid(1,1);
        asteroids.add(asteroid);
        AsteroidView asteroidView = new AsteroidView(asteroid);
        asteroidViews.add(asteroidView);
    }

    private void DestroyAsteroid(Asteroid asteroid)
    {
        asteroids.remove(asteroid);
    }

    public void CalcCollides()
    {
        for (int i = 0;i < asteroids.size();i++)
        {
            asteroids.get(i).CalcCollideWithPlayer();
        }
    }
}
