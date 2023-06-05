package com.miko.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.miko.game.model.Player;

import java.util.Vector;

public class PlayerController
{

    private Player player;

    private Vector2 inputAxis;

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
        else
        {
            inputAxis = Vector2.Zero;
        }
        player.Move(inputAxis);
    }
}
