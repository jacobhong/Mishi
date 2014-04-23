package com.hongj.mishi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {

	public static Animation mishiAnimation, octAnimation;
	public static TextureRegion mishi, mishi2, mishi3, mishi4, mishi5, oct,
			oct2, oct3, splashscreen, background, gameover, turtle;
	public static Texture texture, mishiTexture, ready;
	public static BitmapFont font;
	public static Music music;

	public static void load() {
		font = new BitmapFont(Gdx.files.internal("data/white.fnt"), false);

		texture = new Texture(Gdx.files.internal("data/texture.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		ready = new Texture(Gdx.files.internal("data/ready.png"));
		ready.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		mishiTexture = new Texture(Gdx.files.internal("data/mishi.png"));
		mishiTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		background = new TextureRegion(texture, 1, 206, 800, 480);
		gameover = new TextureRegion(texture, 1, 4, 400, 200);
		splashscreen = new TextureRegion(texture, 403, 4, 400, 200);
		turtle = new TextureRegion(texture, 905, 280, 100, 100);

		mishi = new TextureRegion(mishiTexture, 1, 1, 200, 150);
		mishi2 = new TextureRegion(mishiTexture, 203, 1, 200, 150);
		mishi3 = new TextureRegion(mishiTexture, 405, 1, 200, 150);
		mishi4 = new TextureRegion(mishiTexture, 607, 1, 200, 150);
		mishi5 = new TextureRegion(mishiTexture, 809, 1, 200, 150);

		oct = new TextureRegion(texture, 803, 382, 100, 100);
		oct2 = new TextureRegion(texture, 803, 280, 100, 100);
		oct3 = new TextureRegion(texture, 905, 382, 100, 100);

		TextureRegion[] mishis = { mishi, mishi2, mishi3, mishi4, mishi5 };
		mishiAnimation = new Animation(.1f, mishis);
		mishiAnimation.setPlayMode(Animation.LOOP);

		TextureRegion[] octos = { oct, oct2, oct3 };
		octAnimation = new Animation(.1f, octos);
		octAnimation.setPlayMode(Animation.LOOP);

		music = Gdx.audio.newMusic(Gdx.files.internal("data/music.mp3"));
		music.setLooping(true);
		music.setVolume(1);
		
	}

	public static void dispose() {
		texture.dispose();

	}
}
