package com.mygdx.game;


import aurelienribon.tweenengine.Tween;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.PerspectiveCamera;

public class InputController implements InputProcessor {

	private PerspectiveCamera camera;
	private World world;
	
	public InputController(World world, PerspectiveCamera camera) {
		this.camera = camera;
		this.world = world;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		
		if (keycode == Keys.DPAD_LEFT && world.player.sprite.getX() > -4) {
			// if pressed left and not already moving, move left via tween
			if (!Utils.tweenManager.containsTarget(world.player)) {
				Tween.to(world.player, GameObjectTweenAccessor.POSITION, 0.05f)
					.target(world.player.sprite.getX() - 2, world.player.sprite.getY(), world.player.sprite.getZ())
					.start(Utils.tweenManager);
			}
			
		}
		else if (keycode == Keys.DPAD_RIGHT && world.player.sprite.getX() < 4) {
			// if pressed right and not already moving, move right via tween
			if (!Utils.tweenManager.containsTarget(world.player)) {
				Tween.to(world.player, GameObjectTweenAccessor.POSITION, 0.05f)
					.target(world.player.sprite.getX() + 2, world.player.sprite.getY(), world.player.sprite.getZ())
					.start(Utils.tweenManager);
			}
			
		}
		
		
		if (keycode == Keys.SPACE) {
			world.bullets.add(new Bullet(world.player.sprite.getPosition()));
		}
		
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		// left
		if (screenX < Utils.QUARTER_SCREEN && world.player.sprite.getX() > -4) {
			// if pressed left and not already moving, move left via tween
			if (!Utils.tweenManager.containsTarget(world.player)) {
				Tween.to(world.player, GameObjectTweenAccessor.POSITION, 0.05f)
					.target(world.player.sprite.getX() - 2, world.player.sprite.getY(), world.player.sprite.getZ())
					.start(Utils.tweenManager);
			}
		}
		// right
		else if (screenX > 3 * Utils.QUARTER_SCREEN && world.player.sprite.getX() < 4) {
			// if pressed right and not already moving, move right via tween
			if (!Utils.tweenManager.containsTarget(world.player)) {
				Tween.to(world.player, GameObjectTweenAccessor.POSITION, 0.05f)
					.target(world.player.sprite.getX() + 2, world.player.sprite.getY(), world.player.sprite.getZ())
					.start(Utils.tweenManager);
			}
		}
		
		if (screenX >= Utils.QUARTER_SCREEN && screenX <= 3 * Utils.QUARTER_SCREEN) {
			world.bullets.add(new Bullet(world.player.sprite.getPosition()));
		}
		
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		
		return false;
	}
	
}
