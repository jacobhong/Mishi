package com.hongj.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.hongj.World.World;

public class InputHandler implements InputProcessor {

	private World world;
	private MishiController mishiController;

	public InputHandler(World world) {
		this.world = world;
		mishiController = new MishiController(world);
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.LEFT) {
			mishiController.moveLeft();
			System.out.println("left");
		}
		if (keycode == Keys.RIGHT) {

		}
		if (keycode == Keys.DOWN) {

		}
		if (keycode == Keys.UP) {

		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.LEFT) {
			
		}
		if (keycode == Keys.RIGHT) {

		}
		if (keycode == Keys.DOWN) {

		}
		if (keycode == Keys.UP) {

		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (screenX < Gdx.graphics.getWidth() / 2
				&& screenY > Gdx.graphics.getHeight() / 2) {

		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
