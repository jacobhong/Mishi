package com.hongj.mishi.Model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/*
 * super class of moving objects
 */
public abstract class MoveableEntity {
	protected Vector2 velocity, position;
	protected Rectangle bounds;
	protected float width, height;

	public MoveableEntity(Vector2 position, Vector2 velocity, float width,
			float height) {
		this.position = position;
		this.velocity = velocity;
		this.width = width;
		this.height = height;
	}

	abstract void update();

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public void setHeight(float height) {
		this.height = height;
	}
}
