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

public class GameScreen implements Screen {
	World world;
	WorldRenderer renderer;
	MishiGame game;
	private float stateTime;
	Music music;

	public GameScreen(MishiGame game) {
		this.game = game;
		world = new World(game);
		renderer = new WorldRenderer(world);
		Gdx.input.setInputProcessor(new InputHandler(world));
		music = Assets.music;

	}

	@Override
	public void render(float delta) {
	

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

	}

	@Override
	public void pause() {
		music.pause();
	}

	@Override
	public void resume() {
		music.play();

	}

	@Override
	public void dispose() {
		music.stop();
		music.dispose();

	}

}
