package com.miko.game.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Player
{
        private float moveSpeed;
        private Texture texture;
        private Vector2 pos;
        public Player()
        {
            pos = new Vector2();
            moveSpeed = 100;
            texture = new Texture("space-shooter-spritepack/PNG/playerShip2_red.png");
        }

        public void SetMoveSpeed(float newSpeed)
        {
            moveSpeed = newSpeed;
        }

        public Vector2 getPos()
        {
            return pos;
        };

        public void setPos(Vector2 newPos)
        {
            pos = newPos;
        }

        public Texture getTexture()
        {
            return texture;
        };

        public void Move(Vector2 dir)
        {
            float multiplier = moveSpeed * Gdx.graphics.getDeltaTime();
            pos.add(dir.scl(multiplier));
        }
}
