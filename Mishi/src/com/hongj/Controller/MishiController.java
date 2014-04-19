package com.hongj.Controller;

import com.badlogic.gdx.Gdx;
import com.hongj.Entity.Mishi;
import com.hongj.World.World;

public class MishiController {
	Mishi mishi;

	public MishiController(World world) {
		this.mishi = world.getMishi();
	}

	public void moveLeft() {
		mishi.getVelocity().x = 1;
	}

	public void moveRight() {

	}

	public void moveDown() {

	}

	public void moveUp() {

	}


}
