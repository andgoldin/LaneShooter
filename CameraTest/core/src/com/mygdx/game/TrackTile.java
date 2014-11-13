package com.mygdx.game;

import com.badlogic.gdx.math.Vector3;

public class TrackTile extends GameObject {

	public final GameObject[] elements = new GameObject[Utils.NUM_LANES];
	
	public TrackTile(float x, float y, float z) {
		super(Utils.TEXTURE_TRACK_TILE, Utils.WIDTH_TRACK_TILE, x, y, z);
	}
	
	public TrackTile(Vector3 pos) {
		this(pos.x, pos.y, pos.z);
	}
	
	public TrackTile() {
		this(Vector3.Zero);
	}
	
	public void updateTile(float dx, float dy, float dz) {
		this.sprite.translate(dx, dy, dx);
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != null) {
				elements[i].sprite.translate(dx, dy, dz);
			}
		}
	}
	
}
