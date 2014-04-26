package com.hongj.mishi.Model;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

/*
 * handles the creation of the turtles
 * and updates the status of them
 */
public class TurtleHandler {
	Array<Turtle> blocks;

	public TurtleHandler() {
		blocks = new Array<Turtle>();
		for (int i = 0; i < 11; i++) {
			blocks.add(new Turtle(new Vector2(i, 0)));
			blocks.add(new Turtle(new Vector2(i, 6)));
		}
	}

	public Array<Turtle> getBlocks() {
		return blocks;
	}

	public void update() {

		for (Turtle block : getBlocks()) {
			block.update();
			if (block.isScrolledLeft()) {
				block.reset(block);
			}
		}

	}

}
