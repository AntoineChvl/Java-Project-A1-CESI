package com.collisionshandler;

import com.entity.mobileelements.Diamond;
import com.entity.mobileelements.Stone;
import com.entity.motionlesselements.Path;
import com.entity.motionlesselements.Walls;

import entity.Entity;
import entity.Map;

public class CollisionsHandler {
	
	
	private Map map;
	
	public CollisionsHandler(Map map) {
		
		this.map = map;
		
	}

	public boolean checkForCollisions(Entity[][] playerPosition, int x, int y) {
		if(playerPosition[x][y] instanceof Stone) {
			return true;
		} else if (playerPosition[x][y] instanceof Walls){
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkForDiamonds(Entity[][] playerPosition, int x, int y) {
		
		if(playerPosition[x][y] instanceof Diamond) {
			return true;
		}
		return false;
	}
	
	
	public void checkForGravity() {

        for (int y = this.map.getHeightMap()-1; y >= 0 ; y--) {
            for (int x = 0; x < this.map.getWidthMap(); x++) {
            	
            	if ((this.map.getArrayMap()[x][y] instanceof Stone || this.map.getArrayMap()[x][y] instanceof Diamond) && this.map.getArrayMap()[x][y+1] instanceof Path) {
            		this.map.getArrayMap()[x][y+1] = this.map.getArrayMap()[x][y];
            		this.map.getArrayMap()[x][y] = new Path(x,y);

                } else if (this.map.getArrayMap()[x][y] instanceof Stone && this.map.getArrayMap()[x][y+1] instanceof Stone
                		&& this.map.getArrayMap()[x-1][y] instanceof Path && this.map.getArrayMap()[x-1][y+1] instanceof Path ) {
                	
                	this.map.getArrayMap()[x-1][y+1] = this.map.getArrayMap()[x][y];
            		this.map.getArrayMap()[x][y] = new Path(x,y);
	
                } else if (this.map.getArrayMap()[x][y] instanceof Stone && this.map.getArrayMap()[x][y+1] instanceof Stone
                		&& this.map.getArrayMap()[x+1][y] instanceof Path && this.map.getArrayMap()[x+1][y+1] instanceof Path ) {
                	
                	this.map.getArrayMap()[x+1][y+1] = this.map.getArrayMap()[x][y];
            		this.map.getArrayMap()[x][y] = new Path(x,y);
                }
            }
        }
	}	
}
