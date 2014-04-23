package com.hongj.Screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.hongj.World.World;
import com.hongj.World.WorldRenderer;
import com.hongj.mishi.Assets;
import com.hongj.mishi.MishiGame;

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
		music.play();

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
