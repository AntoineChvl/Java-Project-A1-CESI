package com.entity.mobileelements;

import java.io.IOException;

import com.entity.motionlesselements.ExitDoor;
import com.entity.motionlesselements.Path;

import entity.Sprite;

/**
 * The Class Player.
 *
 * @author Exia CESI - Saint-Nazaire - Group 5
 */

public class Player extends MobileElements {

	private static final Sprite spriteDown = new Sprite('y', "Rockford.png");
	private static final Sprite spriteTurnLeft = new Sprite('y', "Left_Rockford.png");
	private static final Sprite spriteTurnRight = new Sprite('y', "Right_Rockford.png");
	private static final Sprite spriteUp = new Sprite('y', "Back_Rockford1.png");
	private static final Sprite spriteDeath = new Sprite('y', "Death.png");
	private boolean isAlive;
	private int underPotentialThreat;
	private boolean isWin;
	private int thresholdToWin;

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
		this.isAlive = true;
		this.underPotentialThreat = 0;
		this.isWin = false;

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
	
	public Sprite getSpriteDeath() {
		return spriteDeath;
	}

	public void movePlayer(char direction) {

		if(this.getIsAlive()) {
			switch (direction) {

			case 'Z':
				super.entityMove(0, -1, 0, direction, this);
				break;
			case 'Q':
				super.entityMove(-1, 0, -1, direction, this);
				break;
			case 'S':
				super.entityMove(0, +1, 0, direction, this);
				break;
			case 'D':
				super.entityMove(+1, 0, 1, direction, this);
				break;
			}
		} else {
			
		}
	}
	

	public boolean getIsAlive() {
		return this.isAlive;
	}

	public void setIsAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public int getUnderPotentialThreat() {
		return underPotentialThreat;
	}

	public void setUnderPotentialThreat(int underPotentialThreat) {
		this.underPotentialThreat = underPotentialThreat;
	}
	
	public void incrementUnderPotentialThreat() {
		this.underPotentialThreat++;
	}

	
	public boolean getIsWin() {
		return isWin;
	}

	public void setIsWin(boolean isWin) {
		this.isWin = isWin;
	}


	public void playerDeathLinkToEnemy() {
		
		int x = this.getPositionX();
		int y = this.getPositionY();
		
		if(this.getMap().getArrayMap()[x+1][y] instanceof Enemy ||
				this.getMap().getArrayMap()[x-1][y] instanceof Enemy ||
				this.getMap().getArrayMap()[x][y+1] instanceof Enemy ||
				this.getMap().getArrayMap()[x][y-1] instanceof Enemy) {
			this.setIsAlive(false);
			this.loadImage('X', this);
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public void didPlayerWin() {
		
		this.goToExit(0, 1);
		this.goToExit(0, -1);
		this.goToExit(1, 0);
		this.goToExit(-1, 0);
		
	}
	
	public void goToExit(int sideX, int sideY) {
		
		int x = this.getPositionX();
		int y = this.getPositionY();
		thresholdToWin = 1;

		if(this.getMap().getArrayMap()[x+sideX][y+sideY] instanceof ExitDoor && this.getDiamondsCounter() >= thresholdToWin) {
			this.getMap().getArrayMap()[x+sideX][y+sideY] = this.getMap().getArrayMap()[x][y];
			this.getMap().getArrayMap()[x][y] = new Path(x,y);
			this.setIsWin(true);
		}
	}
	
	
}



