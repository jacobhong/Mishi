package com.hongj.Entity;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class BlockHandler {
	Array<Block> blocks;
	

	public BlockHandler() {
		blocks = new Array<Block>();
		for (int i = 0; i < 11; i++) {
			blocks.add(new Block(new Vector2(i, 0)));
			blocks.add(new Block(new Vector2(i, 6)));
		}
	}

	public Array<Block> getBlocks() {
		return blocks;
	}

	
	public void update() {
	
		for (Block block : getBlocks()) {
			block.update();
			if (block.isScrolledLeft()) {			
				block.reset(block);
			}
		}	

	}


}
