package com.hongj.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.hongj.mishi.Mishi;
import com.hongj.mishi.MishiActor;

public class MainMenu implements Screen {

	private Mishi mishi;
	private Stage stage;
	private Table table;
	private TextButton buttonPlay, buttonExit;
	private Label heading;
	private Skin skin;
	private BitmapFont white, black;
	private TextureAtlas atlas;
	private TextButtonStyle textButtonStyle;
	private ShapeRenderer backgroudColor;

	public MainMenu(Mishi mishi) {
		this.mishi = mishi;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		backgroudColor.begin(ShapeType.FilledRectangle);
		backgroudColor.setColor(65, 105, 255, 1);
		backgroudColor.filledRect(0, 0, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		backgroudColor.end();

		Table.drawDebug(stage);

		stage.act(delta);
		stage.draw();

	}

	@Override
	public void resize(int width, int height) {
		stage.setViewport(800, 480, true);
		//
	}

	@Override
	public void show() {
		backgroudColor = new ShapeRenderer();
		stage = new Stage();
		MishiActor a = new MishiActor();

		Gdx.input.setInputProcessor(stage);

		atlas = new TextureAtlas("data/button.pack");
		skin = new Skin(atlas);

		white = new BitmapFont(Gdx.files.internal("data/white.fnt"), false);
		black = new BitmapFont(Gdx.files.internal("data/black.fnt"), false);

		LabelStyle headingStyle = new LabelStyle(white, Color.WHITE);
		heading = new Label(Mishi.TITLE, headingStyle);

		textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.getDrawable("buttonnormal");
		textButtonStyle.down = skin.getDrawable("buttonpressed");
		textButtonStyle.pressedOffsetX = 1;
		textButtonStyle.pressedOffsetY = -1;
		textButtonStyle.font = black;

		buttonExit = new TextButton("Play", textButtonStyle);
		buttonExit.pad(20);

		table = new Table(skin);
		table.setFillParent(true);
		table.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		table.add(heading);
		table.row();
		table.add(buttonExit);

		table.debug();
		stage.addActor(table);
		stage.addActor(a);
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
		// TODO Auto-generated method stub

	}

}
