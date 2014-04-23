package com.hongj.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.hongj.Entity.Block;
import com.hongj.Entity.BlockHandler;
import com.hongj.Entity.Mishi;
import com.hongj.Entity.Octopus;
import com.hongj.World.World.GameState;
import com.hongj.mishi.Assets;

public class WorldRenderer {
	private World world;
	private OrthographicCamera cam, scoreCam;
	private Mishi mishi;
	private SpriteBatch batch, scoreBatch;
	private Octopus oct;
	private Sprite background, gameover, turtle, ready;
	private Animation mishiAnimation, octAnimation;
	private BlockHandler blockHandler;
	private ShapeRenderer renderer;
	private int score;
	private BitmapFont font;

	public WorldRenderer(World world) {
		this.world = world;
		mishi = world.getMishi();
		oct = world.getOctopus();

		cam = new OrthographicCamera(10, 7);
		cam.setToOrtho(false, 10, 7);
		cam.update();

		scoreCam = new OrthographicCamera(800, 480);
		scoreCam.setToOrtho(false, 800, 480);
		scoreCam.update();

		scoreBatch = new SpriteBatch();
		scoreBatch.setProjectionMatrix(scoreCam.combined);

		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);

		mishiAnimation = Assets.mishiAnimation;
		octAnimation = Assets.octAnimation;

		background = new Sprite(Assets.background);
		gameover = new Sprite(Assets.gameover);
		ready = new Sprite(Assets.ready);

		turtle = new Sprite(Assets.turtle);

		blockHandler = world.getHandler();

		renderer = new ShapeRenderer();
		renderer.setProjectionMatrix(cam.combined);

		font = Assets.font;
		font.setColor(Color.YELLOW);
		font.setScale(1.5f);
	}

	public void render(float runTime) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		mishi = world.getMishi();

		score = world.getScore();

		batch.begin();
		batch.disableBlending();
		batch.draw(background, 0, 0, 10, 7);
		batch.end();

		batch.begin();
		batch.enableBlending();

		batch.draw(mishiAnimation.getKeyFrame(runTime), mishi.getPosition().x,
				mishi.getPosition().y, mishi.getBounds().width / 2,
				mishi.getBounds().height / 2, mishi.getWidth(),
				mishi.getHeight(), 1, 1, mishi.getRotation());
		batch.end();

		if (world.getState() == GameState.READY) {
			drawReady();
		}
		if (world.getState() == GameState.RUNNING) {
			drawRunning(runTime);
		}
		scoreBatch.begin();
		font.draw(scoreBatch, score + "", 400	, 400);
		scoreBatch.end();

		if (world.getState() == GameState.GAMEOVER) {
			drawGameOver();
		}
	}

	private void drawReady() {
		batch.begin();
		batch.draw(ready, 3, 3, 3, 3);
		batch.end();
	}

	private void drawRunning(float runTime) {
		batch.begin();
		for (Block block : blockHandler.getBlocks()) {
			batch.draw(turtle, block.getPosition().x, block.getPosition().y,
					1f, 1f);
			batch.draw(octAnimation.getKeyFrame(runTime), oct.getPosition().x,
					oct.getPosition().y, oct.getSize(), oct.getSize());

		}
		batch.end();
	}

	private void drawGameOver() {
		renderer.begin(ShapeType.FilledRectangle);
		renderer.setColor(com.badlogic.gdx.graphics.Color.BLUE);
		renderer.filledRect(2.6f, 1.0f, 5f, 6f);
		renderer.end();
		batch.begin();
		batch.draw(gameover, 2.6f, 1.0f, 5f, 6f);
		batch.end();

	}
}
