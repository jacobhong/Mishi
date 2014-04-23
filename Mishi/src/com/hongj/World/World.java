package com.hongj.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.hongj.Controller.InputHandler;
import com.hongj.Entity.Block;
import com.hongj.Entity.BlockHandler;
import com.hongj.Entity.Mishi;
import com.hongj.Entity.Octopus;
import com.hongj.Screens.GameScreen;
import com.hongj.Screens.MainMenu;
import com.hongj.mishi.MishiGame;

public class World {
	MishiGame game;
	Mishi mishi;
	Octopus octo;
	GameState state;
	int score;
	float time;
	private BlockHandler blockHandler;

	public enum GameState {
		MENU, READY, RESTART, RUNNING, PAUSED, GAMEOVER;
	}

	public World(MishiGame game) {
		state = GameState.READY;
		this.game = game;
		mishi = new Mishi(new Vector2(1, 2));
		octo = new Octopus(new Vector2(11, 7), mishi);

		Gdx.input.setInputProcessor(new InputHandler(this));

		blockHandler = new BlockHandler();

	}

	public void update() {

		switch (state) {
		case MENU:
			updateMenu();
			break;
		case READY:
			updateReady();
			break;
		case RESTART:
			updateRestart();
			break;
		case RUNNING:
			updateRunning();
			break;
		case PAUSED:
			updatePause();
		case GAMEOVER:
			updateGameOver();
			break;
		}

	}

	private void updateMenu() {
		game.setScreen(new MainMenu(game));
	}

	private void updateReady() {
		if (Gdx.input.justTouched()) {
			state = GameState.RUNNING;
		}
	}

	private void updateRestart() {
		game.setScreen(new GameScreen(game));
	}

	private void updateRunning() {
		blockHandler.update();
		time += Gdx.graphics.getDeltaTime();
		if (time > 3) {
			score++;
			System.out.println(score);
			time = 0;
		}

		if (state != GameState.GAMEOVER) {
			float x = Gdx.input.getAccelerometerX();
			float y = Gdx.input.getAccelerometerY();
			float z = Gdx.input.getAccelerometerZ();
			mishi.update();
			octo.update();
			if (mishi.getBounds().overlaps(octo.getBounds())) {
				state = GameState.GAMEOVER;
			}
			for (Block block : blockHandler.getBlocks()) {
				if (block.getBounds().overlaps(mishi.getBounds())) {
					state = GameState.GAMEOVER;
				}
			}
		}
	}

	private void updatePause() {
		System.out.println("pause");

	}

	private void updateGameOver() {
		state = GameState.GAMEOVER;

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

	public GameState getState() {
		return state;
	}

	public void setState(GameState state) {
		this.state = state;
	}

	public int getScore() {
		return score;
	}
}