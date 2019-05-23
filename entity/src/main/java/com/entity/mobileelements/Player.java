package com.entity.mobileelements;

import java.io.IOException;

import entity.Sprite;

public class Player extends MobileElements {

	private static final Sprite sprite = new Sprite('y',"Rockford.png");
	private static final Sprite spriteTurnLeft = new Sprite('y',"Left_Rockford.png");
	private static final Sprite spriteTurnRight = new Sprite('y',"Right_Rockford.png");
	
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Player(int x, int y) {
		super(sprite, x, y);
		// TODO Auto-generated constructor stub
	}
	
	

}
