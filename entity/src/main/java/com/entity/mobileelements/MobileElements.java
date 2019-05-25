package com.entity.mobileelements;

import java.io.IOException;

import com.entity.motionlesselements.Path;

import entity.Entity;
import entity.Sprite;

public abstract class MobileElements extends Entity {

	private int diamondsCounter;
	
	public MobileElements(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}

	public void entityMove(int x, int y, char direction, MobileElements e) {

		final int xpos = e.getPositionX();
		final int ypos = e.getPositionY();
		boolean collision = false;
		boolean isDiamond = false;
		
			if(e instanceof Player) {
				collision = this.getMap().getCollisionsHandler().checkForCollisions(this.getMap().getArrayMap(),xpos + x, ypos + y);
				isDiamond = this.getMap().getCollisionsHandler().checkForDiamonds(this.getMap().getArrayMap(), xpos + x,ypos + y);
			}else {
				collision = this.getMap().getCollisionsHandler().checkForPath(this.getMap().getArrayMap(),xpos + x, ypos + y);
			}
				

			this.loadImage(direction, e);
			
			if (!collision) {

				this.getMap().getArrayMap()[xpos + x][ypos + y] = this.getMap().getArrayMap()[xpos][ypos];
				this.getMap().getArrayMap()[xpos][ypos] = new Path(xpos, ypos);
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
