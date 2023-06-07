package com.miko.game.controller;

import com.miko.game.model.Player;

import java.util.ArrayList;

public class AsteroidsController {

    private Player player;

    private final ArrayList<AsteroidController> asteroidControllers = new ArrayList<>();
    public AsteroidsController(Player player)
    {
        this.player = player;
    }

    public void reset()
    {

    }

    public void spawnAsteroid()
    {

    }

    public void checkCollisions()
    {
        for (int i = 0;i< asteroidControllers.size();i++)
        {
            if (asteroidControllers.get(i).isCollideWithPlayer(player.getPos()))
            {
                player.reset();
                reset();
            }
        }
    }

    private void destroyAsteroid(AsteroidController asteroidController)
    {

    }
}
