package com.hongj.mishi.Screens;

import aurelienribon.tweenengine.Timeline;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
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
import com.hongj.mishi.Assets;
import com.hongj.mishi.MishiGame;
import com.hongj.mishi.Tween.ActorTween;
import com.hongj.mishi.Tween.MishiActor;

public class MainMenu implements Screen {

	private MishiGame game;
	private Stage stage;
	private Table table;
	private Skin skin;
	private TweenManager manager;
	private Image sound;
	private Sprite menu;
	private SpriteBatch batch;
	private Music music;
	private boolean isSound;

	public MainMenu(MishiGame mishi) {
		this.game = mishi;
		isSound = true;
		music = Assets.music;
		music.play();

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(menu, 0, 0);
		batch.end();
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
		menu = new Sprite(Assets.menu);
		batch = new SpriteBatch();

		MishiActor mishiActor = new MishiActor();

		stage = new Stage();

		Gdx.input.setInputProcessor(stage);

		skin = new Skin(Gdx.files.internal("data/menuSkin.json"),
				new TextureAtlas("data/texture.pack"));

		Label heading = new Label(MishiGame.TITLE, skin);
		heading.setFontScale(2f);

		// toggle music on or off
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
				// changes boolean value per click
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

		TextButton playButton = new TextButton("Play", skin);

		// if play button clicked then go to game
		playButton.addListener(new InputListener() {
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

		// if exit button clicked then exit app
		TextButton exitButton = new TextButton("Exit", skin);
		exitButton.addListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				return true;
			}

			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				Gdx.app.exit();
			}
		});

		// basic table setup
		table = new Table(skin);
		table.setFillParent(true);
		table.row();
		table.add(heading);
		table.getCell(heading).spaceBottom(115);
		table.row();
		table.add(playButton).spaceBottom(15).row();
		table.add(exitButton);
		table.row();
		table.add(mishiActor);
		table.row();
		table.row();
		table.add(sound).bottom().left().expandX();
		stage.addActor(table);

		manager = new TweenManager();

		// animate actors using tween
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
				.push(Tween.set(playButton, ActorTween.ALPHA).target(0))
				.push(Tween.to(heading, ActorTween.ALPHA, .25f).target(1))
				.push(Tween.to(playButton, ActorTween.ALPHA, .25f).target(1))
				.push(Tween.to(mishiActor, ActorTween.ALPHA, .25f).target(1))
				.end().start(manager);

		// table fade in
		Tween.from(table, ActorTween.ALPHA, .5f).target(0).start(manager);
		Tween.from(table, ActorTween.Y, .9f)
				.target(Gdx.graphics.getHeight() / 4).start(manager);
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
		music.dispose();
		skin.dispose();
		stage.dispose();

	}

}
