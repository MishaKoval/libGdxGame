package com.miko.game.view;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.miko.game.controller.PlayerController;
import com.miko.game.model.Player;

public class GameView extends ApplicationAdapter {
	//SpriteBatch batch;
	PlayerView playerView;
	Player player;
	PlayerController playerController;

	BackGround backGround;

	Stage stage;
	
	@Override
	public void create () {
		stage = new Stage(new ScreenViewport());
		//batch = new SpriteBatch();
		backGround = new BackGround();
		player = new Player();
		playerView = new PlayerView(player);
		stage.addActor(backGround.GetBackGroundImage());
		stage.addActor(playerView.getPlayerImage());
		playerController = new PlayerController(player);


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//ScreenUtils.clear(0, 0, 0, 1);
		//batch.begin();
		stage.act();
		playerController.Update();
		playerView.drawPlayer();
		stage.draw();

		//playerView.drawPlayer(batch);
		//batch.end();
	}

	@Override
	public void pause () {

	}

	@Override
	public void resize (int width, int height) {
	}

	@Override
	public void resume () {

	}
	
	@Override
	public void dispose () {
		//batch.dispose();
		//playerView.dispose();
	}
}
