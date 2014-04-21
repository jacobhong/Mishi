package com.hongj.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.hongj.mishi.MishiGame;

public class LevelScreen implements Screen {

	Stage stage;
	Table table;
	TextureAtlas atlas;
	Skin skin;
	List list;
	ScrollPane pane;
	TextButton play, back;
	private MishiGame game;

	public LevelScreen(MishiGame mishi) {
		this.game = mishi;
	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(delta);
		Table.drawDebug(stage);
		stage.draw();

	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(800, 480, false);
	}

	@Override
	public void show() {

		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		atlas = new TextureAtlas("data/atlas.pack");
		skin = new Skin(Gdx.files.internal("data/menuSkin.json"), atlas);

		table = new Table(skin);
		table.setFillParent(true);

		table.setBounds(0, 0, 800, 480);

		table.debug();

		list = new List(new String[] { "xxxx" }, skin);

		pane = new ScrollPane(list, skin);

		play = new TextButton("Play", skin);
		back = new TextButton("back", skin);

		play.pad(15);
		back.pad(10);
		back.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				game.setScreen(new MainMenu(game));

			}
		});

		table.add().width(table.getWidth() / 3);
		table.add("SELECT LEVEL").width(table.getWidth() / 3);
		table.add().width(table.getWidth() / 3).row();
		table.add(pane).left().expandY();
		table.add(play);
		table.add(back).bottom().right();

		stage.addActor(table);

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
		stage.dispose();
		atlas.dispose();
		skin.dispose();

	}

}
