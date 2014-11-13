package com.mygdx.game;


import com.badlogic.gdx.math.Vector3;

public class Player extends GameObject {

	
	public Player(float x, float y, float z) {
		super(Utils.TEXTURE_PLAYER, Utils.WIDTH_PLAYER, x, y, z);
	}
	
	public Player(Vector3 pos) {
		this(pos.x, pos.y, pos.z);
	}
	
	public Player() {
		this(Vector3.Zero);
	}
	
	
}
