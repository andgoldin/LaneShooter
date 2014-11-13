package com.mygdx.game;

import aurelienribon.tweenengine.TweenAccessor;

public class GameObjectTweenAccessor implements TweenAccessor<GameObject> {

	public static final int POSITION = 0;
	
	@Override
	public int getValues(GameObject object, int tweenType, float[] returnValues) {
		switch(tweenType) {
		case POSITION:
			returnValues[0] = object.sprite.getX();
			returnValues[1] = object.sprite.getY();
			returnValues[2] = object.sprite.getZ();
			return 3;
		default:
			assert false;	
			return -1;
		}
	}

	@Override
	public void setValues(GameObject object, int tweenType, float[] newValues) {
		switch(tweenType) {
		case POSITION:
			object.sprite.setPosition(newValues[0], newValues[1], newValues[2]);
			break;
		default:
			assert false;
		}
		
	}



}
