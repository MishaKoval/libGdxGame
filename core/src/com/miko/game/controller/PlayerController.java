package com.miko.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.miko.game.model.Player;

public class PlayerController
{
    private final Player player;

    private Vector2 inputAxis;

    private float rotateAngle;

    public PlayerController(Player player)
    {
        inputAxis = new Vector2();
        this.player = player;
    }

    public void update()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.A))
        {
            inputAxis.x = -1.0f;
            inputAxis.y = 0.0f;
        }else if (Gdx.input.isKeyPressed(Input.Keys.D))
        {
            inputAxis.x = 1.0f;
            inputAxis.y = 0.0f;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.W))
        {
            inputAxis.x = 0.0f;
            inputAxis.y = 1.0f;
        }
        else
        {
            inputAxis = Vector2.Zero;
        }
        player.move(inputAxis);
        player.rotate(rotateAngle);
        calcOutOfBorders();
    }

    public void calculateRotation(float worldMousePosX,float worldMousePosY)
    {
        double degrees = Math.atan2(
                player.getPos().y - worldMousePosY,
                player.getPos().x - worldMousePosX
        ) * 180.0d / Math.PI;
        int rotateOffset = 90;
        rotateAngle = (float) degrees + rotateOffset;
    }

    private void calcOutOfBorders()
    {
        Vector2 currentPos = player.getPos();

        if(currentPos.x > Gdx.graphics.getWidth())
        {
            Vector2 newPos = new Vector2(0,currentPos.y);
            player.setPos(newPos);
        }

        if(currentPos.x < 0)
        {
            Vector2 newPos = new Vector2(Gdx.graphics.getWidth()-1,currentPos.y);
            player.setPos(newPos);
        }

        if(currentPos.y > Gdx.graphics.getHeight())
        {
            Vector2 newPos = new Vector2(currentPos.x,0);
            player.setPos(newPos);
        }

        if(currentPos.y < 0)
        {
            Vector2 newPos = new Vector2(currentPos.x,Gdx.graphics.getHeight() - 1);
            player.setPos(newPos);
        }
    }
}
