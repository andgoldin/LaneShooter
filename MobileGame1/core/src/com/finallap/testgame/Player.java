package com.finallap.testgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class Player {
	
	public Rectangle hitbox;
	public int currentLane;
	
	public Player(int lane) {
		hitbox = new Rectangle();
		hitbox.setWidth(0.5f * Utils.LANE_WIDTH);
		hitbox.setHeight(hitbox.width);
		hitbox.setX(Utils.getXOfLaneCenter(lane) - 0.5f * hitbox.width);
		hitbox.setY(100f);
		currentLane = lane;
	}
	
	public float getX() {
		return hitbox.x + 0.5f * hitbox.width;
	}
	
	public void setLane(int laneNum) {
		currentLane = laneNum;
		hitbox.setX(Utils.getXOfLaneCenter(currentLane) - 0.5f * hitbox.width);
	}
}
