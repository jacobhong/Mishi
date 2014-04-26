package com.hongj.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.hongj.Entity.Mishi;
import com.hongj.Entity.Mishi.PlayerState;
import com.hongj.World.World;
import com.hongj.World.World.GameState;
import com.hongj.mishi.Assets;

public class InputHandler implements InputProcessor {
	/*
	 * handles all the input from user touch events
	 */
	private World world;
	private Mishi mishi;

	// map screen coord to world coord
	float scaleX;
	float scaleY;

	public InputHandler(World world) {
		this.world = world;
		mishi = world.getMishi();
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
		// coordinates come in pixels so convert to world units
		scaleX = screenX / (Gdx.graphics.getWidth() / 10f);
		scaleY = screenY / (Gdx.graphics.getHeight() / 7f);

		if (world.getState() == GameState.READY) {
			// if user clicks then proceed to running

			Gdx.input.isTouched();
			Assets.click.play();
			world.setState(GameState.RUNNING);
		}

		// listen for touches coming from the user and
		// perform action depending on game state
		if (world.getState() == GameState.GAMEOVER) {

			if (scaleX >= 0 && scaleX <= 3.5) {
				Assets.click.play();
				world.setState(GameState.RESTART);
			}
			if (scaleX >= 5.5) {
				Assets.click.play();
				world.setState(GameState.MENU);
			}
		}
		if (world.getState() == GameState.RUNNING) {
			if (scaleX < 1 && scaleX > 0 && scaleY < 1 && scaleY > 0) {
				Assets.click.play();
				world.setState(GameState.PAUSED);
			}
		}
		if (world.getState() == GameState.PAUSED) {
			if (scaleX > 3.5 && scaleY < 4 && scaleX < 6 && scaleY > 3.3) {
				Assets.click2.play();
				world.setState(GameState.MENU);
			}
			if (scaleX > 3.5 && scaleY < 2.6 && scaleX < 6 && scaleY > 2) {
				Assets.click2.play();
				world.setState(GameState.RUNNING);
			}
		}
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// if user releases touch then reset settings to stop movement
		mishi.getAcceleration().x = 0;
		mishi.getVelocity().x = 0;
		mishi.getAcceleration().y = 0;
		mishi.getVelocity().y = 0;
		mishi.setRotation(0);
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {

		float newx = screenX / (Gdx.graphics.getWidth() / 10f);
		float newy = screenY / (Gdx.graphics.getHeight() / 7f);

		Vector2 dir = new Vector2(newx - scaleX, newy - scaleY).nor();

		// left
		if (dir.x < -.45f) {
			mishi.getAcceleration().x = -13;
		}
		// right
		if (dir.x > .45f) {
			mishi.getAcceleration().x = 13;
		}
		// up
		if (dir.y < -.45) {
			mishi.getAcceleration().y = 13;
		}
		// down
		if (dir.y > .45) {
			mishi.getAcceleration().y = -13;
		}

		return true;

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
