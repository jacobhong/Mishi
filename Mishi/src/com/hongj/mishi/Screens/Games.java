package com.hongj.mishi.Screens;
//package com.hongj.Screens;
//
//import com.badlogic.gdx.Gdx;
//import com.badlogic.gdx.Input.Keys;
//import com.badlogic.gdx.Screen;
//import com.badlogic.gdx.graphics.GL20;
//import com.badlogic.gdx.graphics.OrthographicCamera;
//import com.badlogic.gdx.math.Vector2;
//import com.badlogic.gdx.physics.box2d.BodyDef;
//import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
//import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
//import com.badlogic.gdx.physics.box2d.ChainShape;
//import com.badlogic.gdx.physics.box2d.CircleShape;
//import com.badlogic.gdx.physics.box2d.FixtureDef;
//import com.badlogic.gdx.physics.box2d.World;
//import com.hongj.Controller.InputHandler;
//import com.hongj.mishi.MishiGame;
//
//public class Games implements Screen {
//	private World world;
//	private Box2DDebugRenderer debugRenderer;
//	private OrthographicCamera cam;
//	private float TIMESTEP = 1 / 60f;
//	private int VELOCITYITERATIONS = 8;
//	private int POSITIONITERATIONS = 3;
//	protected MishiGame game;
//
//	public Games(MishiGame game) {
//		this.game = game;
//	}
//
//	@Override
//	public void render(float delta) {
//		Gdx.gl.glClearColor(0, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//		debugRenderer.render(world, cam.combined);
//		world.step(TIMESTEP, VELOCITYITERATIONS, POSITIONITERATIONS);
//
//	}
//
//	@Override
//	public void resize(int width, int height) {
//		cam.viewportWidth =  25;
//		cam.viewportHeight = 15;
//
//		cam.update();
//	}
//
//	@Override
//	public void show() {
//		Gdx.input.setInputProcessor(new InputHandler(world) {
//			@Override
//			public boolean keyDown(int keycode) {
//				if (keycode == Keys.ESCAPE) {
//					game.setScreen(new LevelScreen());
//				}
//				return true;
//			}
//		});
//		world = new World(new Vector2(0, -9.81f), true);
//		debugRenderer = new Box2DDebugRenderer();
//		cam = new OrthographicCamera();
//
//		BodyDef body = new BodyDef();
//		body.type = BodyType.DynamicBody;
//		body.position.set(0, 10);
//
//		CircleShape circle = new CircleShape();
//		circle.setRadius(.5f);
//
//		FixtureDef fix = new FixtureDef();
//		fix.shape = circle;
//		fix.density = 2.5f;
//		fix.friction = .25f;
//		fix.restitution = .75f;
//		world.createBody(body).createFixture(fix);
//		circle.dispose();
//
//		body.type = BodyType.StaticBody;
//		body.position.set(0, 0);
//
//		ChainShape ground = new ChainShape();
//		ground.createChain(new Vector2[] { new Vector2(-50, 0),
//				new Vector2(50, 0) });
//
//		fix.shape = ground;
//		fix.friction = .5f;
//		fix.restitution = 0;
//		world.createBody(body).createFixture(fix);
//		ground.dispose();
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
//		world.dispose();
//		debugRenderer.dispose();
//
//	}
//
//}
