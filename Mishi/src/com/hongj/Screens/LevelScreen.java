//package com.hongj.Screens;
//
//import aurelienribon.tweenengine.Tween;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.g2d.TextureAtlas;
//import com.badlogic.gdx.scenes.scene2d.InputEvent;
//import com.badlogic.gdx.scenes.scene2d.Stage;
//import com.badlogic.gdx.scenes.scene2d.ui.List;
//import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
//import com.badlogic.gdx.scenes.scene2d.ui.Skin;
//import com.badlogic.gdx.scenes.scene2d.ui.Table;
//import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
//import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
//import com.hongj.Tween.ActorTween;
//import com.hongj.mishi.MishiGame;
//
//public class LevelScreen implements Screen {
//
//	Stage stage;
//	Table table;
//	Skin skin;
//	private MishiGame game;
//
//	public LevelScreen(MishiGame mishi) {
//		this.game = mishi;
//	}
//
//	public LevelScreen() {
//		// TODO Auto-generated constructor stub
//	}
//
//	@Override
//	public void render(float delta) {
//
//		Gdx.gl.glClearColor(0, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//		stage.act(delta);
//		Table.drawDebug(stage);
//		stage.draw();
//
//	}
//
//	@Override
//	public void resize(int width, int height) {
//		stage.setViewport(800, 480, false);
//		table.invalidateHierarchy();
//	}
//
//	@Override
//	public void show() {
//
//		stage = new Stage();
//		Gdx.input.setInputProcessor(stage);
//
//		skin = new Skin(Gdx.files.internal("data/menuSkin.json"),
//				new TextureAtlas("data/atlas.pack"));
//
//		table = new Table(skin);
//		table.setFillParent(true);
//
//		table.debug();
//
//		List list = new List(
//				new String[] { "xxxxsdfasdfsdfsdfdsfsdfsdfsdfsdfdsfsdfsdfsdfsdfsdfsdfsdfsd" },
//				skin);
//
//		ScrollPane pane = new ScrollPane(list, skin);
//
//		TextButton play = new TextButton("Play", skin);
//		TextButton back = new TextButton("back", skin);
//
//		play.pad(15);
//		back.pad(10);
//		back.addListener(new ClickListener() {
//			@Override
//			public void clicked(InputEvent event, float x, float y) {
//				game.setScreen(new Games(game));
//
//			}
//		});
//
//		table.add("SELECT LEVEL").colspan(3).expandX().spaceBottom(50).row();
//
//		table.add(pane).left().expandY().uniformX();
//		table.add(play).uniformX();
//		table.add(back).bottom().right().uniformX();
//		
//		
//		
//		stage.addActor(table);
//
//	}
//
//	@Override
//	public void hide() {
//		dispose();
//
//	}
//
//	@Override
//	public void pause() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void resume() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void dispose() {
//		stage.dispose();
//		skin.dispose();
//
//	}
//
//}
