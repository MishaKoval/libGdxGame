package com.miko.game.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.miko.game.model.Player;

public class PlayerView {
    private Player player;
    public PlayerView(Player player)
    {
        this.player = player;
    }

    public void drawPlayer(SpriteBatch batch)
    {
        Vector2 playerPos = player.getPos();
        Texture texture = player.getTexture();
        batch.draw(texture,playerPos.x,playerPos.y,texture.getWidth(),texture.getHeight());
    }

    public void dispose()
    {
        player.getTexture().dispose();
    }
}
