package com.finallap.testgame;

import com.badlogic.gdx.Gdx;

public class Utils {

	public static final int NUM_LANES = 4;
	public static final float LANE_WIDTH = Gdx.graphics.getWidth() / NUM_LANES;
	public static final float worldVelocity = 10f;
	
	public static float getXOfLaneCenter(int laneNum) {
		float laneWidth = Gdx.graphics.getWidth() / NUM_LANES;
		return (laneWidth * laneNum) + (0.5f * laneWidth);
	}
	
}
