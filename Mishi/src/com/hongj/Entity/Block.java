package com.hongj.Entity;

import java.util.Random;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Block {

	private Vector2 position, velocity;
	private Rectangle bounds;
	private boolean isScrolledLeft;
	public static final float SIZE = 1f;
	private boolean isRising;
	private Random rand;

	public Block(Vector2 position) {
		velocity = new Vector2(-.05f, 0);
		this.position = position;
		this.bounds = new Rectangle(position.x, position.y, SIZE, SIZE);

	}

	boolean isScrolledLeft() {
		return isScrolledLeft;
	}

	public void update() {
		position.add(velocity);
		if (position.x + 1f < 0) {
			isScrolledLeft = true;

		}
	}

	public Vector2 getPosition() {
		return position;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void reset(Block block) {
		isScrolledLeft = false;
		float y = 0;
		rand = new Random();
		
		if (block.position.y == 6) {
			y = rand.nextInt(5) > 2 ? 6 : 5;
		}
		if (block.position.y == 5) {
			y = rand.nextInt(5) > 2 ? 6 : 4;
		}
		if (block.position.y == 4) {
			y = rand.nextInt(5) > 2 ? 5 : 3;
		}		
		
		
		if (block.position.y == 3) {
			y = rand.nextInt(5) > 2 ? 5 : 1;
		}
		
		

		if (block.position.y == 0) {
			y = rand.nextInt(5) > 2 ? 0 : 1;
		}
		if (block.position.y == 1) {
			y = rand.nextInt(5) > 2 ? 0 : 2;
		}
		if (block.position.y == 2) {
			y = rand.nextInt(5) > 2 ? 1 : 3;
		}

		position.set(10, y);
	}
}
