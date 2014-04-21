package com.hongj.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.hongj.Entity.Block;
import com.hongj.Entity.Mishi;
import com.hongj.mishi.Assets;

public class WorldRenderer {
	private World world;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	private Mishi mishi;
	private SpriteBatch batch;
	private Texture blockTexture;
	private Animation mishiAnimation;
	private float scalex, scaley; // pixels per unit

	public WorldRenderer(World world) {
		this.world = world;
		mishi = world.getMishi();

		cam = new OrthographicCamera(10, 7);
		cam.position.set(5, 3.5f, 0);
		cam.update();

		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(cam.combined);

		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		batch.enableBlending();

		mishiAnimation = Assets.mishiAnimation;

		scalex = Gdx.graphics.getWidth() / 10f;
		scaley = Gdx.graphics.getHeight() / 7f;
	}

	public void render(World world, float runTime) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		shapeRenderer.begin(ShapeType.Rectangle);

		for (Block block : world.getBlocks()) {
			Rectangle rect = block.getBounds();
			float x = block.getPosition().x;
			float y = block.getPosition().y;
			shapeRenderer.setColor(1, 0, 0, 1);
			shapeRenderer.rect(x, y, rect.width, rect.height);

		}
		shapeRenderer.end();
		Mishi mishi = world.getMishi();

		float x = mishi.getPosition().x;
		float y = mishi.getPosition().y;
		batch.begin();
		batch.draw(mishiAnimation.getKeyFrame(runTime), mishi.getPosition().x,
				mishi.getPosition().y, mishi.getBounds().width,
				mishi.getBounds().height, mishi.getWidth(), mishi.getHeight(),
				1, 1, 0);
		batch.end();

		Rectangle rect = mishi.getBounds();
		shapeRenderer.begin(ShapeType.Rectangle);
		shapeRenderer.setColor(0, 1, 0, 1);
		shapeRenderer.rect(x, y, rect.width, rect.height);
		shapeRenderer.end();
	}
}
