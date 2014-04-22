package com.hongj.mishi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	public static Animation mishiAnimation;
	public static TextureRegion mishi, mishi2, mishi3, mishi4, mishi5;
	public static Texture texture, splashscreen, oct, background, turtle;

	public static void load() {
		Texture.setEnforcePotImages(false);

		turtle = new Texture(Gdx.files.internal("data/turtle.png"));

		background = new Texture(Gdx.files.internal("data/background.png"));
		background.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		texture = new Texture(Gdx.files.internal("data/mishi.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		splashscreen = new Texture(Gdx.files.internal("data/splashscreen.png"));
		splashscreen.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		oct = new Texture(Gdx.files.internal("data/oct.png"));
		oct.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		mishi = new TextureRegion(texture, 1, 1, 200, 150);
		mishi2 = new TextureRegion(texture, 203, 1, 200, 150);
		mishi3 = new TextureRegion(texture, 405, 1, 200, 150);
		mishi4 = new TextureRegion(texture, 607, 1, 200, 150);
		mishi5 = new TextureRegion(texture, 809, 1, 200, 150);

		TextureRegion[] mishis = { mishi, mishi2, mishi3, mishi4, mishi5 };
		mishiAnimation = new Animation(.1f, mishis);
		mishiAnimation.setPlayMode(Animation.LOOP);
	}

	public static void dispose() {
		splashscreen.dispose();
		texture.dispose();
	}
}
