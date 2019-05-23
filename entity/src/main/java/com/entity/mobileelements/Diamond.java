package com.entity.mobileelements;

import java.io.IOException;

import entity.Sprite;

public class Diamond extends MobileElements {

	private static final Sprite sprite = new Sprite('x',"Diamond.png");
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Diamond(int x, int y) {
		super(sprite, x, y);
		// TODO Auto-generated constructor stub
	}

}
