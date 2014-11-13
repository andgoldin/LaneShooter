package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.decals.Decal;
import com.badlogic.gdx.graphics.g3d.decals.DecalMaterial;

public class AnimatedDecal extends Decal {
	
	private Animation animation;
	
	private float time;
	
	private boolean playing;
	
	private boolean constantSize;
	
	@Override
	protected void update() {
		this.update(Gdx.graphics.getDeltaTime());
		super.update();
	}
	
	public void update(float delta) {
		if (playing) {
			this.setTextureRegion(animation.getKeyFrame(time += delta));
			if (!constantSize) {
				TextureRegion tempRegion = this.getTextureRegion();
				this.setDimensions(tempRegion.getRegionWidth(), tempRegion.getRegionHeight());
			}
		}
	}
	
	public void setTime(float time) {
		this.time = time;
	}
	
	public float getTime() {
		return time;
	}
	
	public void setPlaying(boolean playing) {
		this.playing = playing;
	}
	
	public boolean isPlaying() {
		return playing;
	}
	
	public Animation getAnimation() {
		return animation;
	}
	
	public void setAnimation(Animation anim) {
		animation = anim;
	}
	
	public boolean keepsConstantSize() {
		return constantSize;
	}
	
	public void setKeepConstantSize(boolean keepSize) {
		constantSize = keepSize;
	}

	public static AnimatedDecal newAnimatedDecal(Animation animation) {
		return newAnimatedDecal(animation.getKeyFrame(0).getRegionWidth(),
				animation.getKeyFrame(0).getRegionHeight(),
				animation, DecalMaterial.NO_BLEND, DecalMaterial.NO_BLEND);
	}

	public static AnimatedDecal newDecal(Animation animation, boolean hasTransparency) {
		return newAnimatedDecal(animation.getKeyFrame(0).getRegionWidth(),
				animation.getKeyFrame(0).getRegionHeight(),
				animation, hasTransparency ? GL20.GL_SRC_ALPHA : DecalMaterial.NO_BLEND,
				hasTransparency ? GL20.GL_ONE_MINUS_SRC_ALPHA : DecalMaterial.NO_BLEND);
	}

	public static AnimatedDecal newAnimatedDecal(float width, float height,
			Animation animation) {
		return newAnimatedDecal(width, height, animation,
				DecalMaterial.NO_BLEND, DecalMaterial.NO_BLEND);
	}

	public static AnimatedDecal newAnimatedDecal(float width, float height,
			Animation animation, boolean hasTransparency) {
		return newAnimatedDecal(width, height, animation,
				hasTransparency ? GL20.GL_SRC_ALPHA : DecalMaterial.NO_BLEND,
				hasTransparency ? GL20.GL_ONE_MINUS_SRC_ALPHA : DecalMaterial.NO_BLEND);
	}
	
	public static AnimatedDecal newAnimatedDecal(float width, float height,
			Animation anim, int srcBlendFactor, int dstBlendFactor) {
		AnimatedDecal decal = new AnimatedDecal();
		decal.setAnimation(anim);
		decal.setTextureRegion(anim.getKeyFrame(0));
		decal.setBlending(srcBlendFactor, dstBlendFactor);
		decal.setDimensions(width, height);
		decal.setColor(1, 1, 1, 1);
		return decal;
	}
	
}
