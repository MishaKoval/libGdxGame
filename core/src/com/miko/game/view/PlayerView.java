package com.miko.game.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.miko.game.model.Player;

public class PlayerView {
    private Player player;
    private Image playerImage;
    public PlayerView(Player player)
    {
        this.player = player;
        playerImage = new Image(player.getTexture());
        playerImage.setPosition(player.getPos().x,player.getPos().y);
        playerImage.setRotation(45);
    }

    public Image getPlayerImage()
    {
        return playerImage;
    }

    public int angle = 0;

    public void drawPlayer(/*SpriteBatch batch*/)
    {
        playerImage.setPosition(player.getPos().x,player.getPos().y);
        playerImage.setRotation(player.GetRotation());
        //Vector2 playerPos = player.getPos();
        //Texture texture = player.getTexture();
        //batch.draw(texture,playerPos.x,playerPos.y,texture.getWidth(),texture.getHeight());
    }

    public void dispose()
    {
        player.getTexture().dispose();
    }
}
