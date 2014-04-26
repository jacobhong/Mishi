package com.hongj.mishi;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/*
 * Needed to make the background an actor
 * so it can be animated with the screen
 */
public class BackgroundActor extends Actor {

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(Assets.menu, 0, 0, 800, 480);
	}

}
