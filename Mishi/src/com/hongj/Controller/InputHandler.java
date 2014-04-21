package com.hongj.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.hongj.Entity.Mishi;
import com.hongj.Entity.Mishi.State;
import com.hongj.World.World;

public class InputHandler implements InputProcessor {

	private World world;
	private Mishi mishi;

	public InputHandler(World world) {
		this.world = world;
		mishi = world.getMishi();
	}

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.LEFT) {
			mishi.getVelocity().x = mishi.getSpeed() * -1;
		}
		if (keycode == Keys.RIGHT) {
			mishi.getVelocity().x = mishi.getSpeed() * 1;
		}
		if (keycode == Keys.DOWN) {
			mishi.getVelocity().y = mishi.getSpeed() * -1;
		}
		if (keycode == Keys.UP) {
			mishi.getVelocity().y = mishi.getSpeed() * 1;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.LEFT) {
			mishi.getVelocity().x = 0;
		}
		if (keycode == Keys.RIGHT) {
			mishi.getVelocity().x = 0;
		}
		if (keycode == Keys.DOWN) {
			mishi.getVelocity().y = 0;
		}
		if (keycode == Keys.UP) {
			mishi.getVelocity().y = 0;
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
