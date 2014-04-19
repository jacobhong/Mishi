package com.hongj.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.hongj.Controller.InputHandler;
import com.hongj.Entity.Block;
import com.hongj.Entity.Mishi;
import com.hongj.mishi.MishiGame;

public class World {
	MishiGame game;
	Mishi mishi;
	Array<Block> blocks = new Array<Block>();

	public World(MishiGame game) {
		mishi = new Mishi(new Vector2(7, 2));
		for (int i = 0; i < 10; i++) {
			blocks.add(new Block(new Vector2(i, 0)));
			blocks.add(new Block(new Vector2(i, 6)));

			if (i > 2) {
				blocks.add(new Block(new Vector2(i, 1)));
			}

		}

		blocks.add(new Block(new Vector2(9, 2)));
		blocks.add(new Block(new Vector2(9, 3)));
		blocks.add(new Block(new Vector2(9, 4)));
		blocks.add(new Block(new Vector2(9, 5)));

		blocks.add(new Block(new Vector2(6, 3)));
		blocks.add(new Block(new Vector2(6, 4)));
		blocks.add(new Block(new Vector2(6, 5)));
		
		Gdx.input.setInputProcessor(new InputHandler(this));

	}

	public void update() {
		mishi.update();

	}

	public Mishi getMishi() {
		return mishi;
	}

	public Array<Block> getBlocks() {
		return blocks;
	}

}
