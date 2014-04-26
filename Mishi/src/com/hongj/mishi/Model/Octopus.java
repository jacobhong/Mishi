package com.hongj.mishi.Model;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/*
 * Moving enemy with simple ai
 */
public class Octopus extends MoveableEntity {

	// need instance of main character for coordinates
	private Mishi mishi;

	public Octopus(Vector2 position, Vector2 velocity, float width,
			float height, Mishi mishi) {
		super(position, velocity, width, height);
		this.mishi = mishi;
		bounds = new Rectangle(position.x, position.y, width, height);
	}

	@Override
	public void update() {
		// this gives the octopus a simple ai to chase the main character
		position.lerp(mishi.getPosition(), .003f);

		bounds.x = position.x;
		bounds.y = position.y;
	}
}
