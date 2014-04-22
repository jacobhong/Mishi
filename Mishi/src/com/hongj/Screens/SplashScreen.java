package com.hongj.Screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.physics.box2d.Shape;
import com.hongj.Tween.ActorTween;
import com.hongj.Tween.SpriteTween;
import com.hongj.mishi.Assets;
import com.hongj.mishi.MishiGame;

public class SplashScreen implements Screen {
	MishiGame mishi;
	TweenManager manager;
	SpriteBatch batch;
	Sprite leftLogo;
	ShapeRenderer backgroud;

	public SplashScreen(MishiGame mishi) {
		this.mishi = mishi;
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		backgroud.begin(ShapeType.FilledRectangle);
		backgroud.setColor(147, 112, 219, 1);
		backgroud.filledRect(0, 0, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		
		backgroud.end();
		
		batch.begin();

		leftLogo.draw(batch);

		batch.end();

		manager.update(delta);
		
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		backgroud = new ShapeRenderer();
		manager = new TweenManager();
		batch = new SpriteBatch();
		leftLogo = new Sprite(Assets.splashscreen);

		float scalex = Gdx.graphics.getWidth() / 800;
		float scaley = Gdx.graphics.getHeight() / 480;

		leftLogo.setSize(leftLogo.getWidth() * scalex, leftLogo.getHeight()
				* scaley);
		leftLogo.setPosition(0, 0);
		leftLogo.setColor(1, 1, 1, 1);

		setupTween();

	}

	private void setupTween() {
		Tween.registerAccessor(Sprite.class, new SpriteTween());
		manager = new TweenManager();
		TweenCallback cb = new TweenCallback() {

			@Override
			public void onEvent(int arg0, BaseTween<?> arg1) {
				mishi.setScreen(new MainMenu(mishi));
			}

		};
		Timeline.createSequence()
				.beginSequence()
				.push(Tween.set(leftLogo, SpriteTween.ALPHA).target(1))
				.push(Tween.set(leftLogo, SpriteTween.ZOOM).target(0, 0))
				.pushPause(.2f)
				.push(Tween.to(leftLogo, SpriteTween.ZOOM, .8f).target(
						Gdx.graphics.getWidth() / 2, 0))
				.push(Tween.to(leftLogo, SpriteTween.ALPHA, .6f).target(0))
				.push(Tween.set(leftLogo, SpriteTween.ALPHA).target(1))
				.push(Tween.set(leftLogo, SpriteTween.ZOOM).target(
						Gdx.graphics.getWidth() / 2,
						Gdx.graphics.getHeight() - leftLogo.getHeight()))
				.push(Tween.to(leftLogo, SpriteTween.ZOOM, .6f).target(0,
						Gdx.graphics.getHeight() - leftLogo.getHeight()))
				.pushPause(1)
				.push(Tween.to(leftLogo, SpriteTween.ALPHA, .6f).target(0))
				.end().start(manager).setCallback(cb)
				.setCallbackTriggers(TweenCallback.COMPLETE);

	}

	@Override
	public void hide() {
		dispose();

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		batch.dispose();
		leftLogo.getTexture().dispose();
	}

}
