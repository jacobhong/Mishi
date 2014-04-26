package com.hongj.mishi.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Mishi extends MoveableEntity {
	// main character model
	public static final float MAX_VEL = 6f;
	Vector2 acceleration;
	float rotation;
	PlayerState state;

	public enum PlayerState {
		// handles dead player
		IDLE, DEAD
	}

	public Mishi(Vector2 position, Vector2 velocity, float width, float height) {
		super(position, velocity, width, height);
		acceleration = new Vector2();
		rotation = 0;
		state = PlayerState.IDLE;
		bounds = new Rectangle(position.x, position.y, .5f, .5f);
	}

	@Override
	public void update() {
		// move player and keep in bounds
		velocity.add(acceleration.cpy().mul(Gdx.graphics.getDeltaTime()));
		if (velocity.x > MAX_VEL) {
			velocity.x = MAX_VEL;
		}
		if (velocity.x < -MAX_VEL) {
			velocity.x = -MAX_VEL;
		}
		if (velocity.y > MAX_VEL) {
			velocity.y = MAX_VEL;
		}
		if (velocity.y < -MAX_VEL) {
			velocity.y = -MAX_VEL;
		}
		if (velocity.y > 0) {
			rotation = 25;
		}
		if (velocity.y < 0) {
			rotation = -25;
		}
		if (position.x < 0) {
			position.x = 0;
		}
		if (position.x + width > 10) {
			position.x = 10 - width;
		}
		if (position.y + height > 7) {
			position.y = 7 - height;
		}
		if (position.y < 0) {
			position.y = 0;
		}

		position.add(velocity.cpy().mul(Gdx.graphics.getDeltaTime()));

		bounds.x = position.x;
		bounds.y = position.y;

	}

	public Vector2 getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Vector2 acceleration) {
		this.acceleration = acceleration;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public void setState(PlayerState state) {
		this.state = state;
	}

	public PlayerState getState() {
		return state;
	}

}
