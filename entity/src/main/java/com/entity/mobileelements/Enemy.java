package com.entity.mobileelements;

import java.io.IOException;


import entity.Sprite;

public class Enemy extends MobileElements implements Runnable {

	private static final Sprite spriteDown = new Sprite('i',"Enemy.png");
	static {
		try {
			spriteDown.loadImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Enemy(int x, int y) {
		super(spriteDown, x, y);
		
	}
	
	public void randomMove() {

			double randomDirection = Math.random();
			randomDirection = randomDirection * 4 +1;
			int randomDirInt = (int) randomDirection;
			switch(randomDirInt) {
			case 1:
				super.entityMove(0, -1, 'S', this);
				break;
			case 2:
				super.entityMove(-1, 0, 'S', this);
				break;
			case 3:
				super.entityMove(0, 1, 'S', this);
				break;
			case 4:
				super.entityMove(+1, 0, 'S', this);
				break;
			}
			
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	@Override
	public void run() {
		while(true) {
			this.randomMove();
		}
	}
	
	public Sprite getSpriteDown() {
		return Enemy.spriteDown;
	}


}
