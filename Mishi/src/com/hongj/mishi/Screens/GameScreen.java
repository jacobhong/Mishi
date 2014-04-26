package com.hongj.mishi.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.FPSLogger;
import com.hongj.mishi.Assets;
import com.hongj.mishi.MishiGame;
import com.hongj.mishi.Controller.InputHandler;
import com.hongj.mishi.World.World;
import com.hongj.mishi.World.WorldRenderer;

/*
 * controller for game, updates View(renderer) and Model(world)
 */
public class GameScreen implements Screen {
	World world;
	WorldRenderer renderer;
	MishiGame game;
	private float stateTime;

	public GameScreen(MishiGame game) {
		this.game = game;
		world = new World(game);
		renderer = new WorldRenderer(world);
		Gdx.input.setInputProcessor(new InputHandler(world));

	}

	@Override
	public void render(float delta) {
		// need stateTime for animation
		stateTime += delta;
		world.update();
		renderer.render(stateTime);
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

}
