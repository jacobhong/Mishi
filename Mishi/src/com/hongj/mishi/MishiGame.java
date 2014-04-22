package com.hongj.mishi;

import com.badlogic.gdx.Game;
import com.hongj.Screens.MainMenu;

public class MishiGame extends Game {
public static final String TITLE = "mishi .0.1";
	@Override
	public void create() {
		Assets.load();
		setScreen(new MainMenu(this));

	}
	@Override
	public void dispose(){
		Assets.dispose();
	}

}
