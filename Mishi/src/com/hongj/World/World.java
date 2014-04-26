package com.hongj.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Vector2;
import com.hongj.Entity.Mishi;
import com.hongj.Entity.Octopus;
import com.hongj.Entity.Turtle;
import com.hongj.Screens.GameScreen;
import com.hongj.Screens.MainMenu;
import com.hongj.mishi.Assets;
import com.hongj.mishi.MishiGame;
import com.hongj.Entity.TurtleHandler;

public class World {
	MishiGame game;
	Mishi mishi;
	Octopus octo;
	GameState state;
	int score, highscore;
	float time;
	private TurtleHandler TurtleHandler;
	Sound click;
	Preferences prefs;

	public enum GameState {
		MENU, READY, RESTART, RUNNING, PAUSED, GAMEOVER;
	}

	public World(MishiGame game) {
		state = GameState.READY;
		this.game = game;
		mishi = new Mishi(new Vector2(1, 2));
		octo = new Octopus(new Vector2(11, 7), mishi);
		TurtleHandler = new TurtleHandler();
		click = Assets.click;

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
			break;
		case GAMEOVER:
			updateGameOver();
			break;
		}

	}

	private void updateMenu() {
		game.setScreen(new MainMenu(game));
	}

	private void updateReady() {

	}

	private void updateRestart() {
		game.setScreen(new GameScreen(game));
	}

	private void updateRunning() {
		TurtleHandler.update();
		time += Gdx.graphics.getDeltaTime();
		if (time > 3) {
			score++;
			time = 0;
		}

		if (state == GameState.RUNNING) {
			mishi.update();
			octo.update();
			if (mishi.getBounds().overlaps(octo.getBounds())) {

				state = GameState.GAMEOVER;
			}
			for (Turtle block : TurtleHandler.getBlocks()) {
				if (block.getBounds().overlaps(mishi.getBounds())) {
					state = GameState.GAMEOVER;
				}
			}

		}

	}

	private void updatePause() {
		
		if (state == GameState.READY) {
			updateReady();
		}
	}

	private void updateGameOver() {
		prefs = Gdx.app.getPreferences("score");
		highscore = prefs.getInteger("score", 0);
		if (score > highscore) {
			prefs.putInteger("score", score);
			prefs.flush();
		}

	}

	public Mishi getMishi() {
		return mishi;
	}

	public Octopus getOctopus() {
		return octo;
	}

	public TurtleHandler getHandler() {
		return TurtleHandler;
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

	public int getHighScore() {
		return highscore;
	}
}