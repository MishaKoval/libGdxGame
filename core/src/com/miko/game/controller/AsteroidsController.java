package com.miko.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.miko.game.model.Asteroid;
import com.miko.game.model.Player;
import com.miko.game.view.AsteroidView;

import java.util.ArrayList;

public class AsteroidsController {

    private static final int maxAsteroidsCount = 1;

    private static final int offsetFromPlayer = 50;

    private final Player player;

    private final ArrayList<AsteroidController> asteroidControllers = new ArrayList<>();

    private final ArrayList<AsteroidView> asteroidViews = new ArrayList<>();
    public AsteroidsController(Player player)
    {
        this.player = player;
    }

    public void reset()
    {
        for (int i = 0;i < asteroidControllers.size();i++)
        {
            asteroidViews.get(i).dispose();
        }
        asteroidControllers.clear();
        asteroidViews.clear();
    }

    public void update()
    {
        for (int i = 0;i < asteroidControllers.size();i++)
        {
            asteroidControllers.get(i).update();
            asteroidViews.get(i).drawAsteroid();
        }
    }

    public void init(Stage stage)
    {
        for (int i =0;i< maxAsteroidsCount;i++)
        {
            Asteroid asteroid = new Asteroid(getRandomPoint());
            AsteroidView asteroidView = new AsteroidView(asteroid);
            AsteroidController asteroidController = new AsteroidController(asteroid);
            asteroidControllers.add(asteroidController);
            asteroidViews.add(asteroidView);
            stage.addActor(asteroidView.getAsteroidImage());
        }
    }

    public boolean checkCollisions()
    {
        for (int i = 0;i< asteroidControllers.size();i++)
        {
            if (asteroidControllers.get(i).isCollideWithPlayer(player.getPos()))
            {
                return true;
            }
        }
        return false;
    }

    private Vector2 getRandomPoint()
    {
        float randX;
        float randY;
        do {
            randX = MathUtils.random(1,Gdx.graphics.getWidth()-1);
            randY = MathUtils.random(1, Gdx.graphics.getHeight()-1);
        }
        while ((Math.abs(randX - player.getPos().x) < offsetFromPlayer) && (Math.abs(randY - player.getPos().y) < offsetFromPlayer));
        return new Vector2(randX,randY);
    }

    public void dispose()
    {
        for (int i = 0;i < asteroidControllers.size();i++)
        {
            asteroidViews.get(i).dispose();
        }
    }
}
