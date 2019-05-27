package com.strategy;

import com.entity.mobileelements.MobileElements;
import com.entity.mobileelements.Player;
import com.entity.motionlesselements.Path;

import entity.Entity;


public class BasicFalling extends Strategy<MobileElements> {

	private MobileElements me = null;
	
	public BasicFalling(MobileElements me) {
		this.me = me;
		
	}
	
	
	@Override
	public void runStrategy() {
		
		Entity getNextEntity = me.getMap().getArrayMap()[me.getPositionX()][me.getPositionY()+1];
		
		if (getNextEntity instanceof Path) {
			me.getMap().getArrayMap()[me.getPositionX()][me.getPositionY()+1] = me;
			me.getMap().getArrayMap()[me.getPositionX()][me.getPositionY()] = new Path(me.getPositionX(), me.getPositionY());
			me.setIsFallen(true);
			me.setPositionY(me.getPositionY()+1);
		} else if (getNextEntity instanceof Player && me.getIsFallen()){
			((Player)getNextEntity).setIsAlive(false);
		} else {
			me.setIsFallen(false);
		}
	}

}
