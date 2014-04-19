package com.hongj.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.hongj.World.World;
import com.hongj.World.WorldRenderer;
import com.hongj.mishi.MishiGame;

public class GameScreen implements Screen {
	World world;
	WorldRenderer renderer;
	MishiGame game;
	private float stateTime;

	public GameScreen(MishiGame game) {
		this.game = game;
		world = new World(game);
		renderer = new WorldRenderer(world);
	}

	@Override
	public void render(float delta) {

		stateTime += delta;
		world.update();
		renderer.render(world, stateTime);

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
