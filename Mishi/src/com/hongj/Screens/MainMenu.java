package com.hongj.Screens;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.hongj.Tween.ActorTween;
import com.hongj.mishi.Assets;
import com.hongj.mishi.BackgroundActor;
import com.hongj.mishi.MishiActor;
import com.hongj.mishi.MishiGame;

public class MainMenu implements Screen {

	private MishiGame game;
	private Stage stage;
	private Table table;

	private Skin skin;

	private TweenManager manager;

	private BackgroundActor backgroundActor;
	private Image sound;
	private Music music;
	private boolean isSound;

	public MainMenu(MishiGame mishi) {
		this.game = mishi;
		backgroundActor = new BackgroundActor();
		music = Assets.music;
		music.play();
		isSound = true;

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		stage.draw();
		manager.update(delta);
	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(800, 480, false);
		table.invalidateHierarchy();
	}

	@Override
	public void show() {
		MishiActor a = new MishiActor();

		stage = new Stage();

		Gdx.input.setInputProcessor(stage);

		skin = new Skin(Gdx.files.internal("data/menuSkin.json"),
				new TextureAtlas("data/texture.pack"));

		Label heading = new Label(MishiGame.TITLE, skin);
		heading.setFontScale(2f);

		sound = new Image(Assets.sound);
		sound.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				System.out.println("tes");
				isSound = isSound == true ? false : true;
				if (isSound) {
					if (!music.isPlaying()) {
						music.play();
					}
				} else {
					music.stop();
				}
			}

		});

		TextButton buttonPlay = new TextButton("Play", skin);
		buttonPlay.pad(20);

		buttonPlay.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				Assets.click.play();
				game.setScreen(new GameScreen(game));
			}
		});

		table = new Table(skin);
		table.setFillParent(true);
		table.add(backgroundActor);
		table.row();
		table.add(heading);
		table.getCell(heading).spaceBottom(250);
		table.row();
		table.add(buttonPlay);
		table.row();
		table.add(a);
		table.row();
		table.row();
		table.add(sound).bottom().left().expandX();
		stage.addActor(table);

		manager = new TweenManager();

		Tween.registerAccessor(Actor.class, new ActorTween());
		Timeline.createSequence().beginSequence()
				.push(Tween.to(heading, ActorTween.RGB, .5f).target(0, 0, 1))
				.push(Tween.to(heading, ActorTween.RGB, .5f).target(0, 1, 0))
				.push(Tween.to(heading, ActorTween.RGB, .5f).target(1, 0, 0))
				.push(Tween.to(heading, ActorTween.RGB, .5f).target(1, 0, 0))
				.push(Tween.to(heading, ActorTween.RGB, .5f).target(1, 1, 0))
				.push(Tween.to(heading, ActorTween.RGB, .5f).target(1, 1, 1))
				.push(Tween.to(heading, ActorTween.RGB, .5f).target(1, 0, 1))
				.push(Tween.to(heading, ActorTween.RGB, .5f).target(0, 1, 1))
				.end().start(manager);
		// heading and buttons fade in
		Timeline.createSequence().beginSequence()
				.push(Tween.set(buttonPlay, ActorTween.ALPHA).target(0))
				.push(Tween.to(heading, ActorTween.ALPHA, .25f).target(1))
				.push(Tween.to(buttonPlay, ActorTween.ALPHA, .25f).target(1))
				.end().start(manager);

		// table fade in
		Tween.from(table, ActorTween.ALPHA, .5f).target(0).start(manager);
		Tween.from(table, ActorTween.Y, .5f)
				.target(Gdx.graphics.getHeight() / 2).start(manager);
		manager.update(Float.MIN_VALUE);
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
		// TODO Auto-generated method stub

	}

}
