package com.entity.mobileelements;

import java.io.IOException;


import entity.Sprite;
/**
 * The Class Enemy.
 *
 * @author Exia CESI - Saint-Nazaire - Group 5
 */
public class Enemy extends MobileElements {

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
				this.entityMove(0, -1, 0, 'S');
				break;
			case 2:
				this.entityMove(-1, 0, 0, 'S');
				break;
			case 3:
				this.entityMove(0, 1, 0, 'S');
				break;
			case 4:
				this.entityMove(+1, 0, 0, 'S');
				break;
			}
			
//			try {
//				Thread.sleep(25);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	}

	
	public Sprite getSpriteDown() {
		return Enemy.spriteDown;
	}


}
