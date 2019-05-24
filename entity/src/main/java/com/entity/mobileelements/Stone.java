package com.entity.mobileelements;

import java.io.IOException;

import entity.Sprite;

public class Stone extends MobileElements {

	private static final Sprite sprite = new Sprite('o',"Stone.png");
	
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public Stone(int x, int y) {
		super(sprite, x, y);
		// TODO Auto-generated constructor stub
	}
	
	

}