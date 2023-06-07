package com.miko.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.miko.game.model.Asteroid;

public class AsteroidView {
    private Asteroid asteroid;
    private Texture texture;
    private Image asteroidImage;
    public AsteroidView(Asteroid asteroid)
    {
        this.asteroid = asteroid;
        texture = new Texture("space-shooter-spritepack/PNG/Meteors/meteorBrown_big1.png");
        asteroidImage = new Image(texture);
        asteroidImage.setOrigin(texture.getWidth()/2.0f,texture.getHeight()/2.0f);
        asteroidImage.setPosition(asteroid.getPos().x,asteroid.getPos().y);
    }

    public void drawAsteroid()
    {
        asteroidImage.setPosition(asteroid.getPos().x - texture.getWidth() / 2.0f,asteroid.getPos().y - texture.getHeight() / 2.0f);
        //asteroidImage.setRotation(asteroid.GetRotation());
    }

    public Image getAsteroidImage()
    {
       return asteroidImage;
    }
}
