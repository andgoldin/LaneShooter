package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;

public class CameraTest extends Game {

	private FPSLogger fps;
	
	@Override
	public void create () {
		fps = new FPSLogger();
		this.setScreen(new MainScreen());
	}

	@Override
	public void render () {
		this.getScreen().render(Gdx.graphics.getDeltaTime());
		//fps.log();
	}
}
