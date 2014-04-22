package com.hongj.Entity;

import java.awt.geom.Point2D;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Octopus {

	private Vector2 velocity, position;

	private Rectangle bounds;
	private float size = 1f;

	private Mishi m;

	public Octopus(Vector2 position, Mishi mishi) {
		m = mishi;
		velocity = new Vector2(1,0);
		this.position = position;
		bounds = new Rectangle(position.x, position.y, size, size);
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public void update() {
		//position.lerp(m.getPosition(), Gdx.graphics.getDeltaTime());
//		if (Point2D.distance(m.getPosition().x, m.getPosition().y, position.x,
//				position.y) < 3) {
//			if (m.getPosition().x > position.x) {
//				position.x += .01f;
//			} else {
//				position.x -= .01f;
//
//			}
//			if (m.getPosition().y > position.y) {
//				position.y += .01f;
//			} else {
//				position.y -= .01f;
//
//			}
//		} else {
//			position.add(velocity.cpy().mul(Gdx.graphics.getDeltaTime()));
//		}

		bounds.x = position.x;
		bounds.y = position.y;
	}
}
