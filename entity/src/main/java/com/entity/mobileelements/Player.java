package com.entity.mobileelements;

import java.io.IOException;

import entity.Sprite;

public class Player extends MobileElements {

	private static final Sprite spriteDown = new Sprite('y', "Rockford.png");
	private static final Sprite spriteTurnLeft = new Sprite('y', "Left_Rockford.png");
	private static final Sprite spriteTurnRight = new Sprite('y', "Right_Rockford.png");
	private static final Sprite spriteUp = new Sprite('y', "Back_Rockford1.png");
	private static final Sprite spriteDeath = new Sprite('y', "Death.png");
	private boolean isAlive;
	private int underPotentialThreat;

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
		} else {
			
			System.out.println("Perdu !");
		}
	}
	

	public boolean getIsAlive() {
		return isAlive;
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
	
	public void playerDeathLinkToEnemy() {
		
		int x = this.getPositionX();
		int y = this.getPositionY();
		
		if(this.getMap().getArrayMap()[x+1][y] instanceof Enemy ||
				this.getMap().getArrayMap()[x-1][y] instanceof Enemy ||
				this.getMap().getArrayMap()[x][y+1] instanceof Enemy ||
				this.getMap().getArrayMap()[x][y-1] instanceof Enemy) {
			this.setIsAlive(false);
			this.loadImage('X', this);
		}
		
		
	}
	


}
