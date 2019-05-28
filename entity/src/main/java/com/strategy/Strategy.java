package com.strategy;

import com.entity.mobileelements.MobileElements;

import entity.Entity;

public abstract class Strategy<T extends Entity> {
	
	protected MobileElements me = null;
	public abstract void runStrategy();
	
	


}
