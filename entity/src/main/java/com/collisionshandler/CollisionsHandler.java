package com.collisionshandler;

import com.entity.mobileelements.Diamond;
import com.entity.mobileelements.MobileElements;
import com.entity.mobileelements.Player;
import com.entity.mobileelements.Stone;
import com.entity.motionlesselements.ExitDoor;
import com.entity.motionlesselements.Path;
import com.entity.motionlesselements.Walls;

import entity.Entity;
import entity.Map;

public class CollisionsHandler {

	private Map map;

	public CollisionsHandler(Map map) {

		this.map = map;

	}

	public boolean checkForCollisions(Entity[][] entity, int x, int y) {
		if (entity[x][y] instanceof Stone) {
			return true;
		} else if (entity[x][y] instanceof Walls) {
			return true;
		} else if (entity[x][y] instanceof ExitDoor) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkForDiamonds(Entity[][] playerPosition, int x, int y) {

		if (playerPosition[x][y] instanceof Diamond) {
			return true;
		}
		return false;
	}
	
	public boolean checkForPath(Entity[][] entity, int x, int y) {

		if (entity[x][y] instanceof Path) {
			return false;
		}
		return true;
	}

	public void checkForGravity() {
		
		
		for (int y = this.map.getHeightMap() - 1; y >= 0; y--) {
			for (int x = 0; x < this.map.getWidthMap(); x++) {

				this.basicGravity(x, y);
				this.cascadeGravity(x, y, -1,1);
				this.cascadeGravity(x, y, +1,1);
				this.playerDeathLinkToGravity(x, y);
				this.map.getArrayMap()[x][y].setIsFallen(false);
			}
		}
	
	}	

	public void basicGravity(int x, int y) {
		
		Entity getSpecificEntity = this.map.getArrayMap()[x][y];

		if ((getSpecificEntity instanceof Stone || getSpecificEntity instanceof Diamond)
				&& this.map.getArrayMap()[x][y + 1] instanceof Path) {
			this.map.getArrayMap()[x][y + 1] = getSpecificEntity;
			this.map.getArrayMap()[x][y] = new Path(x, y);
			this.map.getArrayMap()[x][y + 1].setIsFallen(true);
		}
	
	}

	public void cascadeGravity(int x, int y, int sideX, int sideY) {

		if (this.map.getArrayMap()[x][y] instanceof Stone
				&& this.map.getArrayMap()[x][y + sideY] instanceof Stone
				&& this.map.getArrayMap()[x + sideX][y] instanceof Path
				&& this.map.getArrayMap()[x + sideX][y + sideY] instanceof Path) {

			this.map.getArrayMap()[x + sideX][y + sideY] = this.map.getArrayMap()[x][y];
			this.map.getArrayMap()[x][y] = new Path(x, y);
			this.map.getArrayMap()[x][y + 1].setIsFallen(true);

		} 
	}
	
	public void playerDeathLinkToGravity(int x, int y) {
		
		Entity getSpecificEntity = this.map.getArrayMap()[x][y];
		
		if ((getSpecificEntity instanceof Stone || getSpecificEntity instanceof Diamond)
				&& this.map.getArrayMap()[x][y + 1] instanceof Player 
				&& ((Player)this.map.getArrayMap()[x][y + 1]).getUnderPotentialThreat() == 0){
			
			((Player)this.map.getArrayMap()[x][y + 1]).incrementUnderPotentialThreat();
			getSpecificEntity.setIsFallen(false);
			
			
		} else if (getSpecificEntity.getIsFallen() == true 
				 && (getSpecificEntity instanceof Stone || getSpecificEntity instanceof Diamond) 
				 && this.map.getArrayMap()[x][y + 1] instanceof Player
				 && ((Player)this.map.getArrayMap()[x][y + 1]).getUnderPotentialThreat() > 0) {
			 	
			 	((Player)this.map.getArrayMap()[x][y + 1]).setIsAlive(false);
				((MobileElements)this.map.getArrayMap()[x][y+1]).loadImage('X', this.map.getArrayMap()[x][y+1]);
				this.map.getArrayMap()[x][y+1].setIsFallen(false);

		}	
	}	
}