package com.entity.mobileelements;

import java.io.IOException;

import com.fallingstrategy.CascadeFalling;

import entity.Map;
import entity.Sprite;

public class Stone extends MobileElements {

	private static final Sprite sprite = new Sprite('o',"Stone.png");
	private Map map;
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Stone(int x, int y, Map map) {
		
		super(sprite, x, y);
		this.setStrategy(new CascadeFalling(this));
		this.map = map;
	}


	public Map getMap() {
		return map;
	}


	public void setMap(Map map) {
		this.map = map;
	}

	

}
