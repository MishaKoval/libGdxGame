package com.miko.game.view;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.miko.game.controller.PlayerController;
import com.miko.game.model.Player;

public class GameView extends ApplicationAdapter {

	public final static float SCALE = 1f;
	public final static float INV_SCALE = 1.f/SCALE;
	public final static float VP_WIDTH = 1280 * INV_SCALE;
	public final static float VP_HEIGHT = 720 * INV_SCALE;

	private PlayerView playerView;
	private Player player;
	private PlayerController playerController;

	private Background backGround;

	private Stage stage;

	private Vector3 worldSpaceMousePos = new Vector3();

	private OrthographicCamera camera;

	private ExtendViewport viewport;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(VP_WIDTH, VP_HEIGHT, camera);
		stage = new Stage(viewport);
		backGround = new Background();
		player = new Player();
		playerView = new PlayerView(player);
		stage.addActor(backGround.GetBackGroundImage());
		stage.addActor(playerView.getPlayerImage());
		playerController = new PlayerController(player);
		Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Crosshair);
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		SetWorldMousePos(Gdx.input.getX(),Gdx.input.getY());
		playerController.Update();
		playerView.drawPlayer();
		stage.draw();
	}

	@Override
	public void pause () {

	}

	@Override
	public void resize (int width, int height) {
		viewport.update(width, height, true);
	}

	@Override
	public void resume () {

	}
	
	@Override
	public void dispose () {
		playerView.dispose();
	}

	private void SetWorldMousePos(float screenX,float screenY)
	{
		worldSpaceMousePos = camera.unproject(new Vector3(screenX,screenY,0));
		playerController.CalculateRotation(worldSpaceMousePos.x,worldSpaceMousePos.y);
	}

}
