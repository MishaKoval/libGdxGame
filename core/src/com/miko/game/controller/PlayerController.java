package com.miko.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.miko.game.model.Player;

public class PlayerController /*implements InputProcessor*/
{
    private Player player;

    private Vector2 inputAxis;

    private float rotateAngle;

    public PlayerController(Player player)
    {
        inputAxis = new Vector2();
        this.player = player;
    }

    public void Update()
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
        player.Move(inputAxis);
        player.Rotate(rotateAngle);
    }

    public void CalculateRotation(float mousePosX,float mousePosY)
    {
        Vector2 playerPos = player.getPos();
        //Gdx.app.log("PlayerPos :",playerPos.x + " " + playerPos.y);

        double degrees = Math.atan2(
                playerPos.x - mousePosX,
                playerPos.y - mousePosY
        ) * 180.0d / Math.PI;
        rotateAngle = (float) degrees;
    }

    /*@Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        CalculateRotation(screenX,screenY);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        CalculateRotation(screenX,screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        CalculateRotation(screenX,screenY);
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }*/
}
