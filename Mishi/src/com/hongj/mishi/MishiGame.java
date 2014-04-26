package com.hongj.mishi;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.FPSLogger;
import com.hongj.mishi.Screens.SplashScreen;

/*
 * starting point of game,
 * load all assets and set screen to Splash Screen
 */
public class MishiGame extends Game {
	public static final String TITLE = "Mishi  v.0.1";
	private Music music;
	FPSLogger logger;

	@Override
	public void create() {
		Assets.load();
		logger = new FPSLogger();
		logger.log();
		setScreen(new SplashScreen(this));

	}

	@Override
	public void dispose() {
		Assets.dispose();
	}

	@Override
	public void render() {

		super.render();
		logger.log();

	}

}
