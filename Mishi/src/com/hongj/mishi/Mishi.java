package com.hongj.mishi;

import com.badlogic.gdx.Game;
import com.hongj.Screens.SplashScreen;

public class Mishi extends Game {
public static final String TITLE = "mishi .0.1";
	@Override
	public void create() {
		Assets.load();
		setScreen(new SplashScreen(this));

	}
	@Override
	public void dispose(){
		Assets.dispose();
	}

}
