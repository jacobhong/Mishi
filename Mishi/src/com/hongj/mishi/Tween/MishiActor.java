package com.hongj.mishi.Tween;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.hongj.mishi.Assets;

/*
 * draw main character animated on the menu screen
 */
public class MishiActor extends Actor {

	private Animation mishiAnimation;
	private float stateTime;

	public MishiActor() {
		mishiAnimation = Assets.mishiAnimation;

	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(mishiAnimation.getKeyFrame(stateTime), 200, 200);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		stateTime += delta;

	}

}
