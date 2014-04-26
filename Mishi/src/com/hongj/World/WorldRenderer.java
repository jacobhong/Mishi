package com.hongj.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.hongj.Entity.Mishi;
import com.hongj.Entity.Octopus;
import com.hongj.Entity.Turtle;
import com.hongj.Entity.TurtleHandler;
import com.hongj.World.World.GameState;
import com.hongj.mishi.Assets;

public class WorldRenderer {
	private World world;
	private OrthographicCamera cam, scoreCam;
	private Mishi mishi;
	private SpriteBatch batch, scoreBatch;
	private Octopus oct;
	private Sprite background, gameover, pause, paused, ready, retry,
			returnmenu, turtle;
	private Animation mishiAnimation, octAnimation;
	private TurtleHandler turtleHandler;
	float scalex, scaley;

	private int score;
	private BitmapFont font;

	private ShapeRenderer shape;

	public WorldRenderer(World world) {
		this.world = world;
		loadAssets();
		mishi = world.getMishi();
		oct = world.getOctopus();

		cam = new OrthographicCamera(10, 7);
		cam.setToOrtho(false, 10, 7);
		cam.update();

		scoreCam = new OrthographicCamera(800, 480);
		scoreCam.setToOrtho(false, 800, 480);
		scoreCam.update();

		scalex = Gdx.graphics.getWidth() / 800f;
		scaley = Gdx.graphics.getHeight() / 480f;

		shape = new ShapeRenderer();
		shape.setProjectionMatrix(cam.combined);

		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);

		scoreBatch = new SpriteBatch();
		scoreBatch.setProjectionMatrix(scoreCam.combined);

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
			batch.draw(turtle, turtleBlock.getPosition().x,
					turtleBlock.getPosition().y, 1f, 1f);
			shape.begin(ShapeType.FilledRectangle);
			shape.setColor(Color.RED);
			shape.filledRect(turtleBlock.getPosition().x,
					turtleBlock.getPosition().y, turtleBlock.getBounds().x,
					turtleBlock.getBounds().y);
			shape.end();
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
		batch.draw(pause, 0, 6.3f, .7f, .6f);
		batch.draw(mishiAnimation.getKeyFrame(runTime), mishi.getPosition().x,
				mishi.getPosition().y, mishi.getBounds().width / 2,
				mishi.getBounds().height / 2, mishi.getWidth(),
				mishi.getHeight(), 1, 1, mishi.getRotation());

		shape.begin(ShapeType.FilledRectangle);
		shape.setColor(Color.RED);
		System.out.println(mishi.getBounds().x + " " + mishi.getBounds().y);
		shape.filledRect(mishi.getPosition().x, mishi.getPosition().y,
				mishi.getBounds().x, mishi.getBounds().y);
		shape.end();

		batch.draw(octAnimation.getKeyFrame(runTime), oct.getPosition().x,
				oct.getPosition().y, oct.getSize(), oct.getSize());
	}

	private void drawGameOver() {
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
