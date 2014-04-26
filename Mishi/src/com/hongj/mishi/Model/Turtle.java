package com.hongj.mishi.Model;

import java.util.Random;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Turtle extends MoveableEntity {
	// model for turtle tiles that the player avoids

	private boolean isScrolledLeft; // if goes off screen
	private Random rand;

	public Turtle(Vector2 position, Vector2 velocity, float width, float height) {
		super(position, velocity, width, height);

		this.bounds = new Rectangle(position.x, position.y, .4f, .4f);

	}

	boolean isScrolledLeft() {
		return isScrolledLeft;
	}

	public void update() {
		position.add(velocity);
		bounds.set(position.x, position.y, .4f, .4f);
		if (position.x + 1f < 0) {
			// if position of right side of turtle goes left off screen
			isScrolledLeft = true;
		}
	}

	public void reset(Turtle block) {
		// logic for randomizing the tiles, hard coded values from testing

		isScrolledLeft = false;
		rand = new Random();

		float y = 0;
		if (block.position.y == 6) {
			y = rand.nextInt(5) > 2 ? 6 : 3;
		}
		if (block.position.y == 5) {
			y = rand.nextInt(5) > 2 ? 5 : 4;
		}
		if (block.position.y == 4) {
			y = rand.nextInt(5) > 2 ? 3 + rand.nextInt(2) : 6;
		}
		if (block.position.y == 3) {
			y = rand.nextInt(5) > 2 ? 5 : 0;
		}
		if (block.position.y == 0) {
			y = rand.nextInt(5) > 2 ? 0 : 1;
		}
		if (block.position.y == 1) {
			y = rand.nextInt(5) > 2 ? 0 + rand.nextInt(2) : 2;
		}
		if (block.position.y == 2) {
			y = rand.nextInt(5) > 2 ? 2 + rand.nextInt(2) : 5;
		}
		position.set(10, y);

	}
}
