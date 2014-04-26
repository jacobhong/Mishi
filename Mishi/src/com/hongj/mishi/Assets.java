package com.hongj.mishi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Assets {
	/*
	 * loads all the assets once and call them statically
	 */
	public static Animation mishiAnimation, octAnimation;
	public static TextureRegion background, menu, mishi, mishi2, mishi3,
			mishi4, mishi5, oct, oct2, oct3, gameover, pause, paused, ready,
			retry, returnmenu, sound, soundoff, turtle;
	public static Texture mishiTexture, splashscreen, texture, texture2;
	public static BitmapFont font;
	public static Music music;
	public static Sound click, click2;

	public static void load() {
		font = new BitmapFont(Gdx.files.internal("data/white.fnt"), false);

		texture = new Texture(Gdx.files.internal("data/texture.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		texture2 = new Texture(Gdx.files.internal("data/texture2.png"));
		texture2.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		splashscreen = new Texture(Gdx.files.internal("data/splashscreen.png"));
		splashscreen.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		mishiTexture = new Texture(Gdx.files.internal("data/mishi.png"));
		mishiTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		background = new TextureRegion(texture2, 1, 483, 800, 480);
		gameover = new TextureRegion(texture, 1, 227, 412, 78);
		menu = new TextureRegion(texture2, 1, 1, 800, 480);
		pause = new TextureRegion(texture, 609, 133, 80, 70);
		paused = new TextureRegion(texture, 415, 205, 180, 100);
		retry = new TextureRegion(texture2, 803, 863, 200, 100);
		returnmenu = new TextureRegion(texture2, 803, 761, 200, 100);
		ready = new TextureRegion(texture, 1, 152, 412, 73);
		sound = new TextureRegion(texture, 507, 34, 80, 67);
		soundoff = new TextureRegion(texture, 609, 64, 80, 67);
		turtle = new TextureRegion(texture, 405, 1, 100, 100);

		mishi = new TextureRegion(mishiTexture, 1, 1, 200, 150);
		mishi2 = new TextureRegion(mishiTexture, 203, 1, 200, 150);
		mishi3 = new TextureRegion(mishiTexture, 405, 1, 200, 150);
		mishi4 = new TextureRegion(mishiTexture, 607, 1, 200, 150);
		mishi5 = new TextureRegion(mishiTexture, 809, 1, 200, 150);

		oct = new TextureRegion(texture, 597, 205, 100, 100);
		oct2 = new TextureRegion(texture, 405, 103, 100, 100);
		oct3 = new TextureRegion(texture, 507, 103, 100, 100);

		TextureRegion[] mishis = { mishi, mishi2, mishi3, mishi4, mishi5 };
		mishiAnimation = new Animation(.1f, mishis);
		mishiAnimation.setPlayMode(Animation.LOOP);

		TextureRegion[] octos = { oct, oct2, oct3 };
		octAnimation = new Animation(.1f, octos);
		octAnimation.setPlayMode(Animation.LOOP);

		music = Gdx.audio.newMusic(Gdx.files.internal("data/music.ogg"));
		music.setLooping(true);
		music.setVolume(1);

		click = Gdx.audio.newSound(Gdx.files.internal("data/click1.ogg"));
		click2 = Gdx.audio.newSound(Gdx.files.internal("data/click2.ogg"));
	}

	public static void dispose() {
		click.dispose();
		click2.dispose();
		music.dispose();
		texture.dispose();
		texture2.dispose();

	}
}
