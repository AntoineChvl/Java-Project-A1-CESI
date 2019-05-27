package com.strategy;

import com.entity.mobileelements.Enemy;
import com.entity.mobileelements.MobileElements;
import com.entity.mobileelements.Player;
import com.entity.mobileelements.Stone;
import com.entity.motionlesselements.Path;

import entity.Entity;

public class CascadeFalling extends Strategy<MobileElements> {

	private MobileElements me = null;
	
	public CascadeFalling(MobileElements me) {
		this.me = me;
	}

	@Override
	public void runStrategy() {
		
		Entity getNextEntity = me.getMap().getArrayMap()[me.getPositionX()][me.getPositionY()+1];
		Entity getLeftEntity = me.getMap().getArrayMap()[me.getPositionX() - 1][me.getPositionY()];
		Entity getLeftBottomEntity = me.getMap().getArrayMap()[me.getPositionX() - 1][me.getPositionY() +1];
		Entity getRightEntity = me.getMap().getArrayMap()[me.getPositionX() + 1][me.getPositionY()];
		Entity getRightBottomEntity = me.getMap().getArrayMap()[me.getPositionX() + 1][me.getPositionY() +1];
		final int bonusEnemyKilled = 4;
		
		if (getNextEntity instanceof Path) {
			this.cascadeFalling(0, 1);
		} else if (getNextEntity instanceof Player && me.getIsFallen()){
			((Player)getNextEntity).setIsAlive(false);
			
		} else if(getNextEntity instanceof Enemy && me.getIsFallen()) {
			((Enemy)getNextEntity).setIsAlive(false);
			me.getMap().getArrayMap()[me.getPositionX()][me.getPositionY()+1] = new Path(me.getPositionX(), me.getPositionY());
			me.getMap().getPlayer().increaseDiamondsCounter(bonusEnemyKilled);
		} else if(getNextEntity instanceof Stone && getLeftEntity instanceof Path && getLeftBottomEntity instanceof Path) {	
			this.cascadeFalling(-1, 1);
		 
		} else if(getNextEntity instanceof Stone && getRightEntity instanceof Path && getRightBottomEntity instanceof Path) {	
			this.cascadeFalling(1, 1);
		} else {
			me.setIsFallen(false);
		}
	}
	
	
	
	public void cascadeFalling(int sideX, int sideY) {
		
		me.getMap().getArrayMap()[me.getPositionX() + sideX][me.getPositionY() + sideY] = me;
		me.getMap().getArrayMap()[me.getPositionX()][me.getPositionY()] = new Path(me.getPositionX(), me.getPositionY());
		me.setIsFallen(true);
		me.setPositionX(me.getPositionX()+ sideX);
		me.setPositionY(me.getPositionY()+ sideY);
		
	}
	

}
