package com.hongj.Entity;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Block {

	private Vector2 position;
	private Rectangle bounds;
	public static final float SIZE = 1f;

	public Block(Vector2 position) {
		this.position = position;
		this.bounds = new Rectangle();
		this.bounds.width = SIZE;
		this.bounds.height = SIZE;
	}
	public Vector2 getPosition(){
		return position;
	}
	public Rectangle getBounds() {
		return bounds;
	}
}
