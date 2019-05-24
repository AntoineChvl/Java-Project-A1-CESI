package com.entity.mobileelements;

import java.io.IOException;

import com.entity.motionlesselements.Path;

import entity.Entity;
import entity.Sprite;

public abstract class MobileElements extends Entity {

	public MobileElements(Sprite sprite, int x, int y) {
		super(sprite, x, y);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void entityMove(int x, int y, char direction, Entity e) {
		
		final int xpos = e.getPositionX();
		final int ypos = e.getPositionY();
		
		boolean collision = this.getMap().getCollisionsHandler().checkForCollisions(this.getMap().getArrayMap(),xpos+x,ypos+y);
		boolean isDiamond = this.getMap().getCollisionsHandler().checkForDiamonds(this.getMap().getArrayMap(), xpos, ypos-1);
		
		this.loadImage(direction, e);
		if(!collision) {

			this.getMap().getArrayMap()[xpos+x][ypos+y] = this.getMap().getArrayMap()[xpos][ypos];
			this.getMap().getArrayMap()[xpos][ypos] = new Path(xpos,ypos);
			this.setPositionY(ypos+y);
			this.setPositionX(xpos+x);

		}
		
		if(e instanceof Player && isDiamond == true) {
			e.incrementDiamondsCounter();
		}
		
		
	}

	
	public void loadImage(char direction, Entity entity) {
		
		switch(direction) {
		
		case 'Z':
			this.setSprite(entity.getSpriteUp());
			try {
				this.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'S':
			this.setSprite(entity.getSpriteDown());
			try {
				this.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'Q':
			this.setSprite(entity.getSpriteTurnLeft());
			try {
				this.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'D':
			this.setSprite(entity.getSpriteTurnRight());
			try {
				this.getSprite().loadImage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;		
		}
	}

}
