package com.mygdx.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.math.Vector3;

public class GameObject {
	
	public Decal sprite;

	public GameObject(Texture tex, float width, float x, float y, float z) {
		sprite = Decal.newDecal(width,
				width * Utils.computeImageHeightWidthRatio(tex),
				new TextureRegion(tex), true);
		sprite.setPosition(x, y, z);
	}
	
	public GameObject(Texture tex, float width, Vector3 pos) {
		this(tex, width, pos.x, pos.y, pos.z);
	}
	
	public GameObject(Texture tex, float width) {
		this(tex, width, Vector3.Zero);
	}

}
