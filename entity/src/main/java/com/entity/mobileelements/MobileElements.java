package com.entity.mobileelements;

import java.io.IOException;

import com.collisionshandler.CollisionsHandler;
import com.entity.motionlesselements.Path;

import entity.Entity;
import entity.Sprite;

public abstract class MobileElements extends Entity {

	private int diamondsCounter;
	
	public MobileElements(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}

	public void entityMove(int x, int y, int sideX, char direction, MobileElements e) {

		final int xpos = e.getPositionX();
		final int ypos = e.getPositionY();
		final Entity[][] loadArrayMap = this.getMap().getArrayMap();
		final CollisionsHandler getCollisionHandler = this.getMap().getCollisionsHandler();
		boolean collision = false;
		boolean isDiamond = false;
		boolean moveStone = false;
		
			if(e instanceof Player) {
				collision = getCollisionHandler.checkForCollisions(loadArrayMap,xpos + x, ypos + y);
				isDiamond = getCollisionHandler.checkForDiamonds(loadArrayMap, xpos + x,ypos + y);
				moveStone = getCollisionHandler.checkForStoneToMove(loadArrayMap, xpos + x, ypos + y, sideX);
			}else {
				collision = getCollisionHandler.checkForPath(loadArrayMap,xpos + x, ypos + y);
			}
				

			this.loadImage(direction, e);
			
			if(moveStone) {
				loadArrayMap[xpos + x + sideX][ypos + y] = loadArrayMap[xpos + x][ypos + y];
				loadArrayMap[xpos + x][ypos + y] = loadArrayMap[xpos][ypos];
				loadArrayMap[xpos][ypos] = new Path(xpos, ypos);
				this.setPositionY(ypos + y);
				this.setPositionX(xpos + x);
			}
			
			if (!collision) {

				loadArrayMap[xpos + x][ypos + y] = loadArrayMap[xpos][ypos];
				loadArrayMap[xpos][ypos] = new Path(xpos, ypos);
				this.setPositionY(ypos + y);
				this.setPositionX(xpos + x);
			}

			if (isDiamond == true) {
				e.incrementDiamondsCounter();
			}
		

	}

	public void loadImage(char direction, Entity entity) {

		switch (direction) {

		case 'Z':
			entity.setSprite(entity.getSpriteUp());
			try {
				entity.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'S':
			entity.setSprite(entity.getSpriteDown());
			try {
				entity.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'Q':
			entity.setSprite(entity.getSpriteTurnLeft());
			try {
				entity.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'D':
			entity.setSprite(entity.getSpriteTurnRight());
			try {
				entity.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'X':
			entity.setSprite(entity.getSpriteDeath());
			try {
				entity.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	public void incrementDiamondsCounter() {
		this.diamondsCounter++;
	}

	public int getDiamondsCounter() {
		return this.diamondsCounter;
	}

	

}
