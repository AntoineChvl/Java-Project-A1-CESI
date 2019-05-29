package com.strategy;

import com.entity.mobileelements.Enemy;
import com.entity.motionlesselements.Walls;

import entity.Entity;

public class LoopEnemyMove  extends Strategy<Enemy> {

	private Enemy me = null;
	
	
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
	
	public void move(int sideX) {
		
		Entity getAsideEntity = me.getMap().getArrayMap()[me.getPositionX() + sideX][me.getPositionY()];
		if(!(getAsideEntity instanceof Walls)) {
			me.entityMove(me.getPositionX(), me.getPositionY(), sideX, 'S');
		}
	}

	@Override
	public String returnStrategy() {
		// TODO Auto-generated method stub
		return "LoopEnemyMove";
	}
}
