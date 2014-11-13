package com.mygdx.game;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

public class Utils {

	public static TweenManager tweenManager;
	
	public static final int QUARTER_SCREEN = Gdx.graphics.getWidth() / 4;
	public static final int NUM_LANES = 4;
	
	public static final float WIDTH_BULLET = 0.25f;
	public static final float WIDTH_PLAYER = 1.25f;
	public static final float WIDTH_TRACK = 8.0f;
	public static final float WIDTH_TRACK_TILE = 11.0f;
		
	public static Texture TEXTURE_BULLET, TEXTURE_PLAYER, TEXTURE_TRACK, TEXTURE_TRACK_TILE;
	
	
	public static float computeImageHeightWidthRatio(Texture image) {
		return (float) image.getHeight() / image.getWidth();
	}
	
	
	public static void loadTextures() {
		TEXTURE_BULLET = new Texture("Shots.png");
		TEXTURE_BULLET.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TEXTURE_PLAYER = new Texture("Triard.png");
		TEXTURE_PLAYER.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TEXTURE_TRACK = new Texture("track.png");
		TEXTURE_TRACK.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		TEXTURE_TRACK_TILE = new Texture("tracktile.png");
		TEXTURE_TRACK_TILE.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	
	public static void loadTweenUtilities() {
		tweenManager = new TweenManager();
		Tween.registerAccessor(GameObject.class, new GameObjectTweenAccessor());
	}
	
}
