package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g3d.decals.DecalBatch;

public class World {

	public final Player player;
	public final ArrayList<Bullet> bullets;
	public final Track track;
	public final ArrayList<TrackTile> mainTrack;
	
	public World() {
		player = new Player();
		bullets = new ArrayList<Bullet>();
		track = new Track();
		mainTrack = new ArrayList<TrackTile>();
	}
	
	public void step(float dt) {
		
		// move bullets
		for (int i = bullets.size() - 1; i >= 0; i--) {
			bullets.get(i).sprite.translate(0, 50 * dt, 0);
			if (bullets.get(i).sprite.getPosition().y > 30) {
				bullets.remove(i);
			}
		}
		
		// move track
		for (int i = mainTrack.size() - 1; i >= 0; i--) {
			mainTrack.get(i).sprite.translate(0, -15 * dt, 0);
			if (mainTrack.get(i).sprite.getPosition().y < -18) {
				mainTrack.remove(i);
				mainTrack.add(new TrackTile(mainTrack.get(mainTrack.size() - 1).sprite.getPosition().cpy().add(0, mainTrack.get(0).sprite.getHeight(), 0)));
			}
		}
		
	}
	
	public void fillMainTrack() {
		mainTrack.add(new TrackTile(0, 0, -18));
		for (int i = 0; i < 40; i++) {
			//System.out.println("adding track tiles");
			mainTrack.add(new TrackTile(mainTrack.get(mainTrack.size() - 1).sprite.getPosition().cpy().add(0, mainTrack.get(0).sprite.getHeight(), 0)));
		}
	}
	
	
}
