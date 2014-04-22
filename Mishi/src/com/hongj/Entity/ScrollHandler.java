package com.hongj.Entity;

import com.badlogic.gdx.math.Vector2;
import com.hongj.World.World;
import com.hongj.mishi.MishiGame;

public class ScrollHandler {
	private Stalagmite stalagmite, stalagmite2, stalagmite3;

	private MishiGame game;
	private World world;

	public ScrollHandler(World world) {
		this.world = world;
		stalagmite = new Stalagmite(new Vector2(4, 2));
		stalagmite2 = new Stalagmite(new Vector2(stalagmite.getTail() + 2, 3));
		stalagmite3 = new Stalagmite(new Vector2(stalagmite2.getTail() + 2, 4));
	}

	public void update() {
		stalagmite.update();
		stalagmite2.update();
		stalagmite3.update();
		if (stalagmite.isScrolledLeft()) {
			stalagmite.reset(stalagmite3.getTail() + 2);
		} else if (stalagmite2.isScrolledLeft()) {
			stalagmite2.reset(stalagmite.getTail() + 2);

		} else if (stalagmite3.isScrolledLeft()) {
			stalagmite3.reset(stalagmite2.getTail() + 2);
		}
	}

	public Stalagmite getStalagmite() {
		return stalagmite;
	}

	public void setStalagmite(Stalagmite stalagmite) {
		this.stalagmite = stalagmite;
	}

	public Stalagmite getStalagmite2() {
		return stalagmite2;
	}

	public void setStalagmite2(Stalagmite stalagmite2) {
		this.stalagmite2 = stalagmite2;
	}

	public Stalagmite getStalagmite3() {
		return stalagmite3;
	}

	public void setStalagmite3(Stalagmite stalagmite3) {
		this.stalagmite3 = stalagmite3;
	}

}
