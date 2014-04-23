package com.hongj.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.hongj.Entity.Mishi;
import com.hongj.Entity.Mishi.PlayerState;
import com.hongj.World.World;
import com.hongj.World.World.GameState;

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
				mishi.getAcceleration().x = -13;
			}
			if (keycode == Keys.RIGHT) {
				mishi.getAcceleration().x = 13;
			}
			if (keycode == Keys.DOWN) {
				mishi.getAcceleration().y = -13;
			}
			if (keycode == Keys.UP) {
				mishi.getAcceleration().y = 13;
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
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		float x = screenX / (Gdx.graphics.getWidth() / 10);
		float y = screenY / (Gdx.graphics.getHeight() / 7);
		if (world.getState() == GameState.GAMEOVER) {
			if (x >= 2 && x <= 5 && y >= 1 && y <= 2.5) {
				world.setState(GameState.RESTART);
			}
			if (x >= 4 && x <= 5 && y >= 4 && y <= 5) {
				world.setState(GameState.MENU);
			}
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
