package com.hongj.mishi.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hongj.mishi.Assets;
import com.hongj.mishi.Model.Mishi;
import com.hongj.mishi.Model.Octopus;
import com.hongj.mishi.Model.Turtle;
import com.hongj.mishi.Model.TurtleHandler;
import com.hongj.mishi.World.World.GameState;

/*
 * the main rendering class which displays
 * all the game entities according to the Game State
 */
public class WorldRenderer {
	private World world;
	private OrthographicCamera cam, scoreCam;
	private Mishi mishi;
	private Octopus oct;
	private TurtleHandler turtleHandler;
	private Animation mishiAnimation, octAnimation;
	private BitmapFont font;
	private SpriteBatch batch, scoreBatch;
	private Sprite background, gameover, pause, paused, ready, retry,
			returnmenu, turtle;

	private int score;
	private float scalex, scaley;

	public WorldRenderer(World world) {
		this.world = world;
		loadAssets();
		mishi = world.getMishi();
		oct = world.getOctopus();

		// world units in meters (10 by 7 )
		cam = new OrthographicCamera(10, 7);
		cam.setToOrtho(false, 10, 7);
		cam.update();
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);

		// need a second camera for pixel perfect font
		scoreCam = new OrthographicCamera(800, 480);
		scoreCam.setToOrtho(false, 800, 480);
		scoreCam.update();
		scoreBatch = new SpriteBatch();
		scoreBatch.setProjectionMatrix(scoreCam.combined);

		// get ratio of current device with virtual screen
		scalex = Gdx.graphics.getWidth() / 800f;
		scaley = Gdx.graphics.getHeight() / 480f;

		// font for high score and game over text
		font = Assets.font;
		font.setColor(Color.MAGENTA);
		font.getRegion().getTexture()
				.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}

	public void loadAssets() {
		mishiAnimation = Assets.mishiAnimation;
		octAnimation = Assets.octAnimation;

		background = new Sprite(Assets.background);
		gameover = new Sprite(Assets.gameover);
		pause = new Sprite(Assets.pause);
		paused = new Sprite(Assets.paused);
		ready = new Sprite(Assets.ready);
		retry = new Sprite(Assets.retry);
		returnmenu = new Sprite(Assets.returnmenu);
		turtle = new Sprite(Assets.turtle);
		turtleHandler = world.getHandler();
	}

	public void render(float runTime) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		score = world.getScore();

		batch.begin();
		batch.disableBlending();
		batch.draw(background, 0, 0, 10, 7);
		batch.end();

		batch.begin();
		batch.enableBlending();
		for (Turtle turtleBlock : turtleHandler.getBlocks()) {
			// draw turtle blocks
			batch.draw(turtle, turtleBlock.getPosition().x,
					turtleBlock.getPosition().y, turtleBlock.getWidth(),
					turtleBlock.getHeight());
		}
		if (world.getState() == GameState.READY) {
			drawReady();
		}
		if (world.getState() == GameState.RUNNING) {
			drawRunning(runTime);
		}

		if (world.getState() == GameState.PAUSED) {
			drawPaused();
		}
		batch.end();

		if (world.getState() == GameState.GAMEOVER) {
			drawGameOver();
		}

		// draw current score
		scoreBatch.begin();
		font.draw(scoreBatch, score + "",
				(Gdx.graphics.getWidth() / scalex) / 2,
				((Gdx.graphics.getHeight() / scaley) / 2) + 170);
		scoreBatch.end();
	}

	private void drawReady() {
		batch.draw(ready, 4, 3, 2f, 2f);
	}

	private void drawPaused() {
		batch.draw(paused, 4, 3, 2f, 2f);
	}

	private void drawRunning(float runTime) {
		// draw main character and enemy
		batch.draw(pause, 0, 6.3f, .7f, .6f);
		batch.draw(mishiAnimation.getKeyFrame(runTime), mishi.getPosition().x,
				mishi.getPosition().y, mishi.getBounds().width / 2,
				mishi.getBounds().height / 2, mishi.getWidth(),
				mishi.getHeight(), 1, 1, mishi.getRotation());

		batch.draw(octAnimation.getKeyFrame(runTime), oct.getPosition().x,
				oct.getPosition().y, oct.getWidth(), oct.getHeight());
	}

	private void drawGameOver() {
		// draw high score and game over screen
		int highscore = world.getHighScore();
		batch.begin();
		batch.draw(gameover, 3.5f, 2f, 3f, 3f);
		batch.draw(retry, 0, 3, 3, 3);
		batch.draw(returnmenu, 7, 3, 3, 3);
		batch.end();
		scoreBatch.begin();
		font.draw(scoreBatch, "Highscore " + highscore,
				(Gdx.graphics.getWidth() / scalex) / 2 - 50,
				((Gdx.graphics.getHeight() / scaley) / 2) + 145);
		scoreBatch.end();

	}
}
