package com.miko.game.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class BackGround {
    private Image background;

    public BackGround()
    {
        Texture texture = new Texture("space-shooter-spritepack/Backgrounds/darkPurple.png");
        texture.setWrap(Texture.TextureWrap.MirroredRepeat,Texture.TextureWrap.MirroredRepeat);

        TextureRegion textureRegion = new TextureRegion(texture);
        textureRegion.setRegion(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

        background = new Image(textureRegion);
        background.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        background.setPosition(0,0);
        background.setRotation(0);
    }

    public Image GetBackGroundImage()
    {
        return background;
    }

}