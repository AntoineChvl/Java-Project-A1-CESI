package com.entity.mobileelements;

import java.io.IOException;

import com.entity.motionlesselements.Path;

import entity.Sprite;

public class Player extends MobileElements {

	private static final Sprite spriteDown = new Sprite('y',"Rockford.png");
	private static final Sprite spriteTurnLeft = new Sprite('y',"Left_Rockford.png");
	private static final Sprite spriteTurnRight = new Sprite('y',"Right_Rockford.png");
	private static final Sprite spriteUp = new Sprite('y',"Back_Rockford1.png");
	private int diamondsCounter;
	
	
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
		this.diamondsCounter = 0;
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getDiamondsCounter() {
		return diamondsCounter;
	}


	public void setDiamondsCounter(int diamondsCounter) {
		this.diamondsCounter = diamondsCounter;
	}

	public void incrementDiamondsCounter() {
		this.diamondsCounter++;
	}

	
	
	public static Sprite getSpriteDown() {
		return spriteDown;
	}



	public static Sprite getSpriteTurnLeft() {
		return spriteTurnLeft;
	}



	public static Sprite getSpriteTurnRight() {
		return spriteTurnRight;
	}



	public static Sprite getSpriteUp() {
		return spriteUp;
	}



	public void loadImagesOfPlayer(String direction) {
		
		switch(direction) {
		
		case "up":
			this.setSprite(Player.getSpriteUp());
			try {
				this.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "down":
			this.setSprite(Player.getSpriteDown());
			try {
				this.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "left":
			this.setSprite(Player.getSpriteTurnLeft());
			try {
				this.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "right":
			this.setSprite(Player.getSpriteTurnRight());
			try {
				this.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;		
		}
	}
	
	public void movePlayer(char direction) {
		//Player p = this.map.getPlayer();
		//this.checkForGravity();
		switch(direction) {
		
		case 'Z': 
				this.moveUp();
			break;
		case 'Q':
				this.moveLeft();
			break;
		case 'S':
				this.moveDown();
			break;
		case 'D':
				this.moveRight();
			break;
		}
		
		//this.modelNotify();
	}
	
	public void moveUp() {
		boolean collision = this.getMap().getCollisionsHandler().checkForCollisions(this.getMap().getArrayMap(), getMap().getPlayer().getPositionX(), getMap().getPlayer().getPositionY()-1);
		boolean isDiamond = this.getMap().getCollisionsHandler().checkForDiamonds(this.getMap().getArrayMap(), getMap().getPlayer().getPositionX(), getMap().getPlayer().getPositionY()-1);
		this.getMap().getPlayer().loadImagesOfPlayer("up");
		if(!collision) {

			this.getMap().getArrayMap()[getMap().getPlayer().getPositionX()][getMap().getPlayer().getPositionY()-1] = this.getMap().getArrayMap()[getMap().getPlayer().getPositionX()][getMap().getPlayer().getPositionY()];
			this.getMap().getArrayMap()[getMap().getPlayer().getPositionX()][getMap().getPlayer().getPositionY()] = new Path(getMap().getPlayer().getPositionX(),getMap().getPlayer().getPositionY());
			this.getMap().getPlayer().setPositionY(getMap().getPlayer().getPositionY()-1);

			
			if(isDiamond) {
				this.incrementDiamondsCounter();
			}

		}
	}
	
	public void moveDown() {
		boolean collision = this.getMap().getCollisionsHandler().checkForCollisions(this.getMap().getArrayMap(), getMap().getPlayer().getPositionX(), getMap().getPlayer().getPositionY()+1);
		boolean isDiamond = this.getMap().getCollisionsHandler().checkForDiamonds(this.getMap().getArrayMap(), getMap().getPlayer().getPositionX(), getMap().getPlayer().getPositionY()+1);
		this.getMap().getPlayer().loadImagesOfPlayer("down");
		if(!collision) {

			this.getMap().getArrayMap()[getMap().getPlayer().getPositionX()][getMap().getPlayer().getPositionY()+1] = this.getMap().getArrayMap()[getMap().getPlayer().getPositionX()][getMap().getPlayer().getPositionY()];
			this.getMap().getArrayMap()[getMap().getPlayer().getPositionX()][getMap().getPlayer().getPositionY()] = new Path(getMap().getPlayer().getPositionX(),getMap().getPlayer().getPositionY());
			this.getMap().getPlayer().setPositionY(getMap().getPlayer().getPositionY()+1);

			
			if(isDiamond) {
				this.incrementDiamondsCounter();
			}
			
		}

	}
	
	public void moveLeft() {
		boolean collision = this.getMap().getCollisionsHandler().checkForCollisions(this.getMap().getArrayMap(), getMap().getPlayer().getPositionX()-1, getMap().getPlayer().getPositionY());
		boolean isDiamond = this.getMap().getCollisionsHandler().checkForDiamonds(this.getMap().getArrayMap(), getMap().getPlayer().getPositionX()-1, getMap().getPlayer().getPositionY());
		this.getMap().getPlayer().loadImagesOfPlayer("left");
		if(!collision) {

			this.getMap().getArrayMap()[getMap().getPlayer().getPositionX()-1][getMap().getPlayer().getPositionY()] = this.getMap().getArrayMap()[getMap().getPlayer().getPositionX()][getMap().getPlayer().getPositionY()];
			this.getMap().getArrayMap()[getMap().getPlayer().getPositionX()][getMap().getPlayer().getPositionY()] = new Path(getMap().getPlayer().getPositionX(),getMap().getPlayer().getPositionY());
			this.getMap().getPlayer().setPositionX(getMap().getPlayer().getPositionX()-1);

			
			if(isDiamond) {
				this.incrementDiamondsCounter();
			}
			
		}

	}
	
	public void moveRight() {
		boolean collision = this.getMap().getCollisionsHandler().checkForCollisions(this.getMap().getArrayMap(), getMap().getPlayer().getPositionX()+1, getMap().getPlayer().getPositionY());
		boolean isDiamond = this.getMap().getCollisionsHandler().checkForDiamonds(this.getMap().getArrayMap(), getMap().getPlayer().getPositionX()+1, getMap().getPlayer().getPositionY());
		this.getMap().getPlayer().loadImagesOfPlayer("right");
		if(!collision) {

			this.getMap().getArrayMap()[getMap().getPlayer().getPositionX()+1][getMap().getPlayer().getPositionY()] = this.getMap().getArrayMap()[getMap().getPlayer().getPositionX()][getMap().getPlayer().getPositionY()];
			this.getMap().getArrayMap()[getMap().getPlayer().getPositionX()][getMap().getPlayer().getPositionY()] = new Path(getMap().getPlayer().getPositionX(),getMap().getPlayer().getPositionY());
			this.getMap().getPlayer().setPositionX(getMap().getPlayer().getPositionX()+1);

			
			if(isDiamond) {
				this.incrementDiamondsCounter();
			}
			
		}

	}
	
	
	
	

}
