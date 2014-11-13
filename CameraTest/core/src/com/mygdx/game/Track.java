package com.mygdx.game;


import com.badlogic.gdx.math.Vector3;

public class Track extends GameObject {

	
	public Track(float x, float y, float z) {
		super(Utils.TEXTURE_TRACK, Utils.WIDTH_TRACK, x, y, z);
	}
	
	public Track(Vector3 pos) {
		this(pos.x, pos.y, pos.z);
	}
	
	public Track() {
		this(Vector3.Zero);
	}
	
	
}
