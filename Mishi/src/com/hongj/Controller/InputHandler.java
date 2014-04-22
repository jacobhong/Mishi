package com.hongj.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.hongj.Entity.Mishi;
import com.hongj.Entity.Mishi.PlayerState;
import com.hongj.World.World;

public class InputHandler implements InputProcessor {

	private World world;
	private Mishi mishi;

	public InputHandler(World world) {
		this.world = world;
		mishi = world.getMishi();
	}

	public InputHandler(com.badlogic.gdx.physics.box2d.World world2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean keyDown(int keycode) {
		if (mishi.getState() != PlayerState.DEAD) {
			if (keycode == Keys.LEFT) {
				mishi.setState(PlayerState.LEFT);
				mishi.getAcceleration().x = -5;
			}
			if (keycode == Keys.RIGHT) {
				mishi.getAcceleration().x = 5;
			}
			if (keycode == Keys.DOWN) {
				mishi.getAcceleration().y = -5;
			}
			if (keycode == Keys.UP) {
				mishi.getAcceleration().y = 5;
			}
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.LEFT) {
			mishi.getAcceleration().x = 0;
			mishi.getVelocity().x = 0;
			mishi.setRotation(0);
		}
		if (keycode == Keys.RIGHT) {
			mishi.getAcceleration().x = 0;
			mishi.getVelocity().x = 0;
			mishi.setRotation(0);

		}
		if (keycode == Keys.DOWN) {
			mishi.getAcceleration().y = 0;
			mishi.getVelocity().y = 0;
			mishi.setRotation(0);

		}
		if (keycode == Keys.UP) {
			mishi.getAcceleration().y = 0;
			mishi.getVelocity().y = 0;
			mishi.setRotation(0);

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
