package com.hongj.mishi;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.hongj.mishi.MishiGame;

public class MainActivity extends AndroidApplication {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
		
		cfg.useGL20 = true;
		cfg.useAccelerometer = false;
		initialize(new MishiGame(), cfg);
	}
}