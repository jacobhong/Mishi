package com.hongj.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Mishi {

	Vector2 position, velocity, acceleration;
	float x, y, width, height, rotation;
	Rectangle bounds;
	PlayerState state;

	public enum PlayerState {
		IDLE, DEAD, LEFT, RIGHT, UP, DOWN
	}

	public Mishi(Vector2 position) {

		this.velocity = new Vector2();
		this.acceleration = new Vector2();
		this.position = position;
		state = PlayerState.IDLE;
		rotation = 0;
		width = 1.0f;
		height = 1.0f;

		bounds = new Rectangle(position.x, position.y, .75f	, .75f);
	}

	public void update() {
		if (state == PlayerState.DEAD) {
			velocity.set(0, -9);
		}
		
		velocity.add(acceleration.cpy().mul(Gdx.graphics.getDeltaTime()));
		
		if (velocity.y > 1) {
			rotation = 45;
		}
		if (velocity.y < -1) {
			rotation = -45;
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

	public Rectangle getBounds() {
		return bounds;
	}

	public Vector2 getPosition() {
		return position;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public Vector2 getAcceleration() {
		return acceleration;
	}

	public void setAcceleration(Vector2 acceleration) {
		this.acceleration = acceleration;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
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
