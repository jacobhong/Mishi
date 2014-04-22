package com.hongj.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.hongj.Controller.InputHandler;
import com.hongj.Entity.Block;
import com.hongj.Entity.BlockHandler;
import com.hongj.Entity.Mishi;
import com.hongj.Entity.Octopus;
import com.hongj.Entity.ScrollHandler;
import com.hongj.Entity.Stalagmite;
import com.hongj.mishi.MishiGame;

public class World {
	MishiGame game;
	Mishi mishi;
	Octopus octo;
	GameState state;
	public Stalagmite s1, s2, s3;
	private ScrollHandler handler;
	private BlockHandler blockHandler;

	public enum GameState {
		MENU, READY, RUNNING, GAMEOVER;
	}

	public World(MishiGame game) {
		state = GameState.MENU;

		mishi = new Mishi(new Vector2(1, 2));
		octo = new Octopus(new Vector2(1, 3), mishi);

		Gdx.input.setInputProcessor(new InputHandler(this));
		blockHandler = new BlockHandler();

	}

	public void update() {

		switch (state) {
		case MENU:
			updateReady();
			break;
		case READY:

		case RUNNING:
			updateRunning();
			break;
		case GAMEOVER:
			updateGameOver();
			break;
		}

	}

	private void updateGameOver() {
		state = GameState.GAMEOVER;

	}

	private void updateRunning() {
		state = GameState.RUNNING;
		blockHandler.update();
		
		if (state != GameState.GAMEOVER) {
			mishi.update();
			octo.update();
			if (mishi.getBounds().overlaps(octo.getBounds())) {
				state = GameState.GAMEOVER;
			}
		}
	}

	private void updateReady() {
		state = GameState.READY;
		if (Gdx.input.isTouched()) {
			System.out.println("ready");
			updateRunning();
		}

	}

	public Mishi getMishi() {
		return mishi;
	}

	public Octopus getOctopus() {
		return octo;
	}

	public BlockHandler getHandler() {
		return blockHandler;
	}

}