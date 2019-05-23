package com.entity.mobileelements;

import java.io.IOException;

import entity.Sprite;

public class Enemy extends MobileElements {

	private static final Sprite sprite = new Sprite('i',"Enemy.png");
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Enemy(int x, int y) {
		super(sprite, x, y);
		// TODO Auto-generated constructor stub
	}
	
	

}
