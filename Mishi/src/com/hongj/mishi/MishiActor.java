package com.hongj.mishi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MishiActor extends Actor {

	private Animation mishiAnimation;
	private float stateTime;

	public MishiActor() {
		mishiAnimation = Assets.mishiAnimation;

	}

	@Override
	public void draw(SpriteBatch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		
		batch.draw(mishiAnimation.getKeyFrame(stateTime),
				Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		stateTime += delta;

	}

	@Override
	public void addAction(Action action) {
		// TODO Auto-generated method stub
		super.addAction(action);
	}

	@Override
	public Actor hit(float x, float y, boolean touchable) {
		// TODO Auto-generated method stub
		// if (touchable && getTouchable() != Touchable.enabled) return null;
		// return x >= 0 && x < width && y >= 0 && y < height ? this : null;
		return super.hit(x, y, touchable);
	}

}
