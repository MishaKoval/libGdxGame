package com.miko.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.miko.game.controller.PlayerController;
import com.miko.game.model.Player;

public class GdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	PlayerView playerView;
	Player player;
	PlayerController playerController;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		player = new Player();
		playerView = new PlayerView(player);
		playerController = new PlayerController(player);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		playerController.Update();
		playerView.drawPlayer(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		playerView.dispose();
	}
}
