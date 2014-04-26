package com.hongj.Entity;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Octopus {

	private Vector2 velocity, position;

	private Rectangle bounds;
	private float size = 1f;

	// need instance of main character for coordinates
	private Mishi mishi;

	public Octopus(Vector2 position, Mishi mishi) {
		this.mishi = mishi;
		velocity = new Vector2();
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
		// this gives the octopus a simple ai to chase the main character
		position.lerp(mishi.getPosition(), .003f);

		bounds.x = position.x;
		bounds.y = position.y;
	}
}
