package com.mygdx.game;


import com.badlogic.gdx.math.Vector3;

public class Bullet extends GameObject {
	
	public Bullet(float x, float y, float z) {
		super(Utils.TEXTURE_BULLET, Utils.WIDTH_BULLET, x, y, z);
	}
	
	public Bullet(Vector3 pos) {
		this(pos.x, pos.y, pos.z);
	}
	
	public Bullet() {
		this(Vector3.Zero);
	}
	
	
}
