package com.miko.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.miko.game.controller.AsteroidsController;
import com.miko.game.controller.PlayerController;
import com.miko.game.model.Player;
import com.miko.game.view.Background;
import com.miko.game.view.PlayerView;

public class Game extends ApplicationAdapter {

	private PlayerView playerView;
	private Player player;
	private PlayerController playerController;
	private Background background;
	private Stage stage;
	private OrthographicCamera camera;
	private ExtendViewport viewport;

	//private Asteroid asteroid;

	//private AsteroidView asteroidView;

	//private AsteroidController asteroidController;

	private AsteroidsController asteroidsController;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
		stage = new Stage(viewport);
		background = new Background();
		player = new Player();
		playerView = new PlayerView(player);

		//asteroid = new Asteroid(100,100);
		//asteroidView = new AsteroidView(asteroid);
		//asteroidController = new AsteroidController(asteroid,asteroidView);



		stage.addActor(background.getBackgroundImage());
		asteroidsController = new AsteroidsController(player);
		asteroidsController.init(stage);
		stage.addActor(playerView.getPlayerImage());
		//stage.addActor(asteroidView.getAsteroidImage());
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
		playerController.update();
		playerView.drawPlayer();
		asteroidsController.update();
		if (asteroidsController.checkCollisions())
		{
			gameOver();
		}
		stage.draw();
	}

	@Override
	public void pause ()
	{

	}

	@Override
	public void resize (int width, int height)
	{
		viewport.update(width, height, true);
	}

	@Override
	public void resume ()
	{

	}
	
	@Override
	public void dispose ()
	{
		playerView.dispose();
		//asteroidView.dispose();
		background.dispose();
	}

	private void SetWorldMousePos(float screenX,float screenY)
	{
		Vector3 worldSpaceMousePos = camera.unproject(new Vector3(screenX,screenY,0));
		playerController.calculateRotation(worldSpaceMousePos.x,worldSpaceMousePos.y);
	}

	private void gameOver()
	{
		asteroidsController.reset();
		player.reset();
		asteroidsController.init(stage);
	}

}
