package com.entity.mobileelements;

import java.io.IOException;

import com.strategy.LoopEnemyMove;

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
		this.setStrategy(new LoopEnemyMove(this));
		
	}
	
	
	public Sprite getSpriteDown() {
		return Enemy.spriteDown;
	}


}
