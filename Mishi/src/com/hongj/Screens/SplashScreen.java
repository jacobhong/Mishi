package com.hongj.Screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.physics.box2d.Shape;
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
		manager.update(delta);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		backgroud.begin(ShapeType.FilledRectangle);
		backgroud.setColor(147, 112, 219, .4f);
		backgroud.filledRect(0, 0, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());

		backgroud.end();
		batch.begin();

		leftLogo.draw(batch);

		batch.end();

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

		float scalex = Gdx.app.getGraphics().getWidth() / 800;
		float scaley = Gdx.app.getGraphics().getHeight() / 480;

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
		Tween.to(leftLogo, SpriteTween.ALPHA, .6f).target(0)
				.ease(TweenEquations.easeInOutQuad).delay(.8f).setCallback(cb)
				.setCallbackTriggers(TweenCallback.COMPLETE).start(manager);
		Tween.from(leftLogo, SpriteTween.ZOOM, .4f)
				.target(99,92).start(manager);

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

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
