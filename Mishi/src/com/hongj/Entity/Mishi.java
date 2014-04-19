package com.hongj.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Mishi {
	Vector2 position, velocity, acceleration;
	float x, y, width, height, rotation;

	Rectangle bounds;

	public Mishi(Vector2 position) {
		this.velocity = new Vector2(position.x, position.y);
		this.acceleration = new Vector2(5, 5);
		this.position = position;
		rotation = 0;
		width = 2.0f;
		height = 2.0f;

		bounds = new Rectangle(position.x, position.y, width, height);
	}

	public void update() {
		acceleration.mul(Gdx.graphics.getDeltaTime());
		velocity.add(acceleration);
		position.set(velocity);
		
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
	

}
