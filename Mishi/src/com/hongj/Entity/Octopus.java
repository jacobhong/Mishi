package com.hongj.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Octopus {

	private Vector2 velocity, position;

	private Rectangle bounds;
	private float size = 1f;

	public Octopus(Vector2 position) {
		velocity = new Vector2(-1, 0);
		this.position = position;

		bounds = new Rectangle(position.x, position.y, size, size);
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public void update() {
		position.add(velocity.cpy().mul(Gdx.graphics.getDeltaTime()));
		bounds.x = position.x;
		bounds.y = position.y;
	}
}
