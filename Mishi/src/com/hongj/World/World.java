package com.hongj.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.hongj.Controller.InputHandler;
import com.hongj.Entity.Block;
import com.hongj.Entity.Mishi;
import com.hongj.Entity.Octopus;
import com.hongj.mishi.MishiGame;

public class World {
	MishiGame game;
	Mishi mishi;
	Octopus octo;
	GameState state;

	public enum GameState {
		MENU, READY, RUNNING, GAMEOVER;
	}

	public World(MishiGame game) {
		state = GameState.MENU;

		mishi = new Mishi(new Vector2(7, 2));
		octo = new Octopus(new Vector2(6, 3));

		Gdx.input.setInputProcessor(new InputHandler(this));

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
		// TODO Auto-generated method stub
		
	}

	private void updateRunning() {
		if (state != GameState.GAMEOVER) {
			mishi.update();
			octo.update();
			if (mishi.getBounds().overlaps(octo.getBounds())) {
				state = GameState.GAMEOVER;
			}
		}

	}

	private void updateReady() {
		if(Gdx.input.isTouched()){
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

}

// for (int i = 0; i < 10; i++) {
// blocks.add(new Block(new Vector2(i, 0)));
// blocks.add(new Block(new Vector2(i, 6)));
//
// if (i > 2) {
// blocks.add(new Block(new Vector2(i, 1)));
// }
//
// }

// blocks.add(new Block(new Vector2(9, 2)));
// blocks.add(new Block(new Vector2(9, 3)));
// blocks.add(new Block(new Vector2(9, 4)));
// blocks.add(new Block(new Vector2(9, 5)));
//
// blocks.add(new Block(new Vector2(6, 3)));
// blocks.add(new Block(new Vector2(6, 4)));
// blocks.add(new Block(new Vector2(6, 5)));