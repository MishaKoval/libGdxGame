package com.miko.game.view;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.miko.game.controller.PlayerController;
import com.miko.game.model.Player;

public class GameView extends ApplicationAdapter implements InputProcessor {

	public final static float SCALE = 1f;
	public final static float INV_SCALE = 1.f/SCALE;
	// this is our "target" resolution, note that the window can be any size, it is not bound to this one
	public final static float VP_WIDTH = 1280 * INV_SCALE;
	public final static float VP_HEIGHT = 720 * INV_SCALE;




	//SpriteBatch batch;
	PlayerView playerView;
	Player player;
	PlayerController playerController;

	BackGround backGround;

	Stage stage;

	Vector3 worldSpaceMousePos = new Vector3();

	private OrthographicCamera camera;

	private ExtendViewport viewport;
	
	@Override
	public void create () {
		//stage = new Stage(new ScreenViewport());

		camera = new OrthographicCamera();
		viewport = new ExtendViewport(VP_WIDTH, VP_HEIGHT, camera);
		stage = new Stage(viewport);
		// pick a viewport that suits your thing, ExtendViewport is a good start

		//batch = new SpriteBatch();
		backGround = new BackGround();
		player = new Player();
		playerView = new PlayerView(player);
		stage.addActor(backGround.GetBackGroundImage());
		stage.addActor(playerView.getPlayerImage());
		playerController = new PlayerController(player);
		Gdx.input.setInputProcessor(this);
		Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Crosshair);
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
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
		viewport.update(width, height, true);
	}

	@Override
	public void resume () {

	}
	
	@Override
	public void dispose () {
		//batch.dispose();
		//playerView.dispose();
	}


	@Override
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
		worldSpaceMousePos = camera.project(new Vector3(screenX,screenY,0));
		playerController.CalculateRotation(worldSpaceMousePos.x,worldSpaceMousePos.y);
		//Gdx.app.log("MousePos :",worldSpaceMousePos.x + " " + worldSpaceMousePos.y);
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		worldSpaceMousePos = camera.project(new Vector3(screenX,screenY,0));
		playerController.CalculateRotation(screenX,screenY);
		return true;
	}
	@Override public boolean mouseMoved (int screenX, int screenY) {
		worldSpaceMousePos = camera.project(new Vector3(screenX,screenY,0));
		playerController.CalculateRotation(worldSpaceMousePos.x,worldSpaceMousePos.y);
		//Gdx.app.log("MousePos :",worldSpaceMousePos.x + " " + worldSpaceMousePos.y);
		return true;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}

}
