package com.entity.motionlesselements;

import java.io.IOException;

import entity.Sprite;

public class Dirt extends MotionlessElements {

	private static final Sprite sprite = new Sprite('t',"Dirt.png");
	static {
		try {
			sprite.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public Dirt(int x, int y) {
		super(sprite, x, y);
		// TODO Auto-generated constructor stub
	}
	
	

}
