package com.finallap.testgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	ShapeRenderer shapeRenderer;
	Player player;
	
	InputProcessor input;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		shapeRenderer = new ShapeRenderer();
		player = new Player(1);
		input = new InputProcessor() {
			public boolean keyDown(int keycode) {
				if (keycode == Keys.DPAD_LEFT && player.currentLane > 0) {
					player.setLane(player.currentLane - 1);
					System.out.println("KEY PRESSED");
				}
				else if (keycode == Keys.DPAD_RIGHT && player.currentLane < Utils.NUM_LANES - 1) {
					player.setLane(player.currentLane + 1);
					System.out.println("KEY PRESSED");
				}
				return false;
			}
			public boolean keyUp(int keycode) {
				return false;
			}
			public boolean keyTyped(char character) {
				return false;
			}
			public boolean touchDown(int screenX, int screenY, int pointer,
					int button) {
				return false;
			}
			public boolean touchUp(int screenX, int screenY, int pointer,
					int button) {
				return false;
			}
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				return false;
			}
			public boolean mouseMoved(int screenX, int screenY) {
				return false;
			}
			public boolean scrolled(int amount) {
				return false;
			}
		};
		Gdx.input.setInputProcessor(input);
	}
	
	
	public void update() {
		
	}

	@Override
	public void render () {
		
		update();
		
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.draw(img, 0, 0);
		batch.end();
		
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.CYAN);
		System.out.println(player.hitbox.x + ", " + player.hitbox.y);
		System.out.println("LANE: " + player.currentLane);
		//System.out.println(player.hitbox.width + ", " + player.hitbox.height);
		shapeRenderer.rect(player.hitbox.x, player.hitbox.y, player.hitbox.width, player.hitbox.height);
		shapeRenderer.end();
	}
}
