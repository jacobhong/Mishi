package com.hongj.mishi;

import com.badlogic.gdx.Game;
import com.hongj.mishi.Screens.SplashScreen;

/*
 * starting point of game,
 * load all assets and set screen to Splash Screen
 */
public class MishiGame extends Game {
	public static final String TITLE = "Mishi  v.0.1";

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
