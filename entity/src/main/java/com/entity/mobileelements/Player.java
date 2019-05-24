package com.entity.mobileelements;

import java.io.IOException;

import com.entity.motionlesselements.Path;

import entity.Sprite;

public class Player extends MobileElements {

	private static final Sprite spriteDown = new Sprite('y',"Rockford.png");
	private static final Sprite spriteTurnLeft = new Sprite('y',"Left_Rockford.png");
	private static final Sprite spriteTurnRight = new Sprite('y',"Right_Rockford.png");
	private static final Sprite spriteUp = new Sprite('y',"Back_Rockford1.png");
	//private int diamondsCounter;
	
	
	static {
		try {
			spriteDown.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Player(int x, int y) {
		super(spriteDown, x, y);
		//this.diamondsCounter = 0;
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getDiamondsCounter() {
		return super.getDiamondsCounter();
	}
	
	
	public Sprite getSpriteDown() {
		return spriteDown;
	}



	public Sprite getSpriteTurnLeft() {
		return spriteTurnLeft;
	}



	public Sprite getSpriteTurnRight() {
		return spriteTurnRight;
	}



	public Sprite getSpriteUp() {
		return spriteUp;
	}

	
	public void movePlayer(char direction) {
		switch(direction) {
		
		case 'Z': 
				super.entityMove(0, -1, direction, this);
			break;
		case 'Q':
				super.entityMove(-1, 0, direction, this);
			break;
		case 'S':
				super.entityMove(0, +1, direction, this);
			break;
		case 'D':
				super.entityMove(+1, 0, direction, this);
			break;
		}
		
	}


}
