package com.miko.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.miko.game.model.Player;

public class PlayerView {
    private final Player player;
    private final Texture texture;
    private final Image playerImage;
    public PlayerView(Player player)
    {
        this.player = player;
        texture = new Texture("space-shooter-spritepack/PNG/playerShip2_red.png");
        playerImage = new Image(texture);
        playerImage.setOrigin(texture.getWidth()/2.0f,texture.getHeight()/2.0f);
        playerImage.setPosition(player.getPos().x,player.getPos().y);
    }

    public Image getPlayerImage()
    {
        return playerImage;
    }

    public void drawPlayer()
    {
        playerImage.setPosition(player.getPos().x - texture.getWidth() / 2.0f,player.getPos().y - texture.getHeight() / 2.0f);
        playerImage.setRotation(player.getRotation());
    }

    public void dispose()
    {
        texture.dispose();
        playerImage.remove();
    }
}
