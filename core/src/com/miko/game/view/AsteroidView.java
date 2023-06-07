package com.miko.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.miko.game.model.Asteroid;

import java.util.Random;

public class AsteroidView {

    private final String brownBigTexturePath = "space-shooter-spritepack/PNG/Meteors/meteorBrown_big1.png";

    private final String greyBigTexturePath = "space-shooter-spritepack/PNG/Meteors/meteorGrey_big2.png";

    private final String brownMedTexturePath = "space-shooter-spritepack/PNG/Meteors/meteorBrown_med3.png";

    private Asteroid asteroid;
    private Texture texture;
    private Image asteroidImage;

    public AsteroidView(Asteroid asteroid)
    {
        this.asteroid = asteroid;
        texture = new Texture(randomizeTexturePath());
        asteroidImage = new Image(texture);
        asteroidImage.setOrigin(texture.getWidth()/2.0f,texture.getHeight()/2.0f);
        asteroidImage.setPosition(asteroid.getPos().x,asteroid.getPos().y);
        asteroid.SetBorders(asteroid.getPos().x - texture.getWidth() / 2.0f,asteroid.getPos().y - texture.getHeight() / 2.0f,texture.getWidth(),texture.getHeight());
    }

    public void drawAsteroid()
    {
        asteroidImage.setPosition(asteroid.getPos().x - texture.getWidth() / 2.0f,asteroid.getPos().y - texture.getHeight() / 2.0f);
    }

    private String randomizeTexturePath()
    {
        Random random = new Random();
        int rand = random.nextInt(3);
        switch (rand)
        {
            case 0:
                return brownBigTexturePath;
            case 1:
                return greyBigTexturePath;
            case 2:
                return brownMedTexturePath;
        }
        return null;
    }

    public Image getAsteroidImage()
    {
       return asteroidImage;
    }

    public void dispose()
    {
        texture.dispose();
        asteroidImage.remove();
    }
}
