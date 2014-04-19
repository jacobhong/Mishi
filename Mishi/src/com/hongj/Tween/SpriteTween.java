package com.hongj.Tween;

import com.badlogic.gdx.graphics.g2d.Sprite;

import aurelienribon.tweenengine.TweenAccessor;

public class SpriteTween implements TweenAccessor<Sprite> {
	public static final int ALPHA = 1, ZOOM = 2;

	@Override
	public int getValues(Sprite target, int tweenType, float[] returnValues) {
		switch (tweenType) {
		case ALPHA:
			returnValues[0] = target.getColor().a;
			return 1;
		case ZOOM:
			returnValues[0] = target.getX();
			returnValues[1] = target.getY();
			return 2;
		default:
			return 0;
		}
	}

	@Override
	public void setValues(Sprite target, int tweenType, float[] newValue) {
		switch (tweenType) {
		case ALPHA:
			target.setColor(target.getColor().r, target.getColor().g,
					target.getColor().b, newValue[0]);
			break;
		case ZOOM:
			target.setX(newValue[0]);
			target.setY(newValue[1]);
			break;
		}

	}

}
