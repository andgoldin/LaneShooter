package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.decals.CameraGroupStrategy;
import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;
import com.badlogic.gdx.math.Matrix3;
import com.badlogic.gdx.math.Matrix4;

public class MainScreen implements Screen {

	/** view and transform matrix for text rendering and transforming 3D objects **/
	private final Matrix4 viewMatrix = new Matrix4();
	private final Matrix4 transform = new Matrix4();
	private final Matrix4 normal = new Matrix4();
	private final Matrix3 normal3 = new Matrix3();

	/** perspective camera: default set to origin, looking down -z **/
	private PerspectiveCamera camera;
	
	private SpriteBatch batch;
	private DecalBatch decalBatch;
	
	private BitmapFont font;
	
	private World world;
	
	public MainScreen() {
		
		Utils.loadTextures();
		Utils.loadTweenUtilities();
		
		batch = new SpriteBatch();
		viewMatrix.setToOrtho2D(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.setProjectionMatrix(viewMatrix);
		
		camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.translate(0, -18.25f, -13.8f);
		camera.rotate(camera.up.cpy().crs(camera.direction), -53);
		decalBatch = new DecalBatch(500, new CameraGroupStrategy(camera));

		font = new BitmapFont();
		
		world = new World();
		world.player.sprite.setPosition(0, -15, -17.9f);
		world.track.sprite.setPosition(0, 0, -18);
		world.fillMainTrack();
		
		Gdx.input.setInputProcessor(new InputController(world, camera));
		
	}
	
	public void update(float delta) {
		
		// camera control for debugging
		if (Gdx.input.isKeyPressed(Keys.W)) {
			camera.position.add(camera.direction.cpy().scl(10f * delta));
		}
		else if (Gdx.input.isKeyPressed(Keys.S)) {
			camera.position.add(camera.direction.cpy().scl(-10f * delta));
		}
		
		if (Gdx.input.isKeyPressed(Keys.A)) {
			camera.position.add(camera.up.cpy().crs(camera.direction).scl(10f * delta));
		}
		else if (Gdx.input.isKeyPressed(Keys.D)) {
			camera.position.add(camera.up.cpy().crs(camera.direction).scl(-10f * delta));
		}
		
		if (Gdx.input.isKeyPressed(Keys.DPAD_UP)) {
			camera.rotate(camera.up.cpy().crs(camera.direction).nor(), -40f * delta);
		}
		else if (Gdx.input.isKeyPressed(Keys.DPAD_DOWN)) {
			camera.rotate(camera.up.cpy().crs(camera.direction).nor(), 40f * delta);
		}

		Utils.tweenManager.update(delta);
		camera.position.x = world.player.sprite.getX() / 2.0f;
		
		// step world
		world.step(delta);
		
		//world.batchDecals(decalBatch);
		
	}
	
	public void draw(float delta) {
		Gdx.gl.glClearColor(0.05f, 0.13f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		Gdx.gl.glEnable(GL20.GL_DEPTH_TEST);

		
		//decalBatch.add(world.track.sprite);
		for (int i = world.mainTrack.size() - 1; i >= 0; i--) {
			decalBatch.add(world.mainTrack.get(i).sprite);
		}
		decalBatch.flush();
		camera.update();
		decalBatch.add(world.player.sprite);
		for (int i = world.bullets.size() - 1; i >= 0; i--) {
			decalBatch.add(world.bullets.get(i).sprite);
		}
		decalBatch.flush();
		camera.update();
		
		
		batch.begin();
		font.draw(batch, "FPS: " + Gdx.graphics.getFramesPerSecond(), 10, Gdx.graphics.getHeight() - 5);
		font.draw(batch, "CAMERA: " + camera.position.toString(), 10, Gdx.graphics.getHeight() - 25);
		//font.draw(batch, "ANGLE: " + camera.direction.toString(), 10, Gdx.graphics.getHeight() - 45);
		batch.end();
	}
	
	@Override
	public void render(float delta) {
		update(delta);
		draw(delta);
	}

	@Override
	public void resize(int width, int height) {
		camera.viewportHeight = Gdx.graphics.getHeight();
		camera.viewportWidth = Gdx.graphics.getWidth();
		viewMatrix.setToOrtho2D(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.setProjectionMatrix(viewMatrix);
	}

	@Override
	public void show() {
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		decalBatch.dispose();
		font.dispose();
	}
	
	
}
