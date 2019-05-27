package com.strategy;

import com.entity.mobileelements.Enemy;
import com.entity.motionlesselements.Dirt;
import com.entity.motionlesselements.Path;

import entity.Entity;

public class LoopEnemyMove  extends Strategy<Enemy> {

	private Enemy me = null;
	private boolean isBlocked = false;
	
	
	public LoopEnemyMove(Enemy me) {
		this.me = me;
	}
	
	@Override
	public void runStrategy() {
		
//		Entity getAsideEntity = me.getMap().getArrayMap()[me.getPositionX() - 1][me.getPositionY()];
//		Entity getOtherSideEntity = me.getMap().getArrayMap()[me.getPositionX() + 1][me.getPositionY()];
//		
//			if(getAsideEntity instanceof Path) {
//				me.getMap().getArrayMap()[me.getPositionX() - 1][me.getPositionY()] = me;
//				me.getMap().getArrayMap()[me.getPositionX()][me.getPositionY()] = new Path(me.getPositionX(), me.getPositionY());
//				me.setPositionX(me.getPositionX()-1);
//				this.isBlocked = true;
//			} else if (this.isBlocked == true && getOtherSideEntity instanceof Path) {
//	
//				me.getMap().getArrayMap()[me.getPositionX() + 2][me.getPositionY()] = me;
//				me.getMap().getArrayMap()[me.getPositionX()][me.getPositionY()] = new Path(me.getPositionX(), me.getPositionY());
//				me.setPositionX(me.getPositionX()+2);
//				this.isBlocked = false;
//				
//			}
		


	}
	
	

}
