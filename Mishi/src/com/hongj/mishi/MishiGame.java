package com.hongj.mishi;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.hongj.Screens.SplashScreen;

/*
 * starting point of game,
 * load all assets and set screen to Splash Screen
 */
public class MishiGame extends Game {
	public static final String TITLE = "Mishi  v.0.1";
	private Music music;

	@Override
	public void create() {
		Assets.load();
		setScreen(new SplashScreen(this));

	}

	@Override
	public void dispose() {
		Assets.dispose();
	}

}
