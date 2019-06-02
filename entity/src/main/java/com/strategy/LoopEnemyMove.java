package com.strategy;

import com.entity.mobileelements.Enemy;
import com.entity.motionlesselements.Walls;

import entity.Entity;

/**
 * The LoopEnemyMove class.
 * @author Antoine Chauvel
 * @version 0.1
 *
 */
public class LoopEnemyMove  extends Strategy<Enemy> {

	/** The enemy concerned by the strategy */
	private Enemy me = null;
	
	/**
	 * The LoopEnemyMove strategy constructor.
	 * @param me the enemy concerned
	 */
	public LoopEnemyMove(Enemy me) {
		this.me = me;
	}
	
	@Override
	public void runStrategy() {
		
		double randomDirection = Math.random();
		randomDirection = randomDirection * 2 +1;
		int randomDirInt = (int) randomDirection;
		
		switch(randomDirInt) {
		case 1:
			this.move(1);
			break;
		case 2:
			this.move(-1);
			break;
		}
		
	}
	
	/**
	 * The move method. Called by runStrategy. Unfinished yet.
	 * @param sideX the side on which the enemy is moving (left/right)
	 */
	public void move(int sideX) {
		
		Entity getAsideEntity = me.getMap().getArrayMap()[me.getPositionX() + sideX][me.getPositionY()];
		if(!(getAsideEntity instanceof Walls)) {
			me.entityMove(me.getPositionX(), me.getPositionY(), sideX, 'S');
		}
	}

	@Override
	public String returnStrategy() {
		return "LoopEnemyMove";
	}
}
