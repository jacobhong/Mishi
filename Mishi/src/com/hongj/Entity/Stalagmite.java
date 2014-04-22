package com.hongj.Entity;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Stalagmite {

	private Vector2 position, velocity;
	private float width = 1f, height = 1f;
	private Rectangle bounds;
	private boolean isScrolledLeft;

	public boolean isScrolledLeft() {
		return isScrolledLeft;
	}

	public void setScrolledLeft(boolean isScrolledLeft) {
		this.isScrolledLeft = isScrolledLeft;
	}

	public Stalagmite(Vector2 position) {
		this.position = position;
		velocity = new Vector2(-0.01f, 0);
		bounds = new Rectangle(position.x, position.y, width, height);
		isScrolledLeft = false;
	}

	public void update() {
		position.add(velocity);
		bounds.set(position.x, position.y, width, width);
		if (position.x + width < 0) {
			isScrolledLeft = true;
		}
	}

	public Vector2 getPosition() {
		return position;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void reset(float newX) {
		position.x = newX;
		height = (int) (Math.random() * 4);
		isScrolledLeft = false;
	}

	public float getTail() {
		return position.x + width;
	}
}
