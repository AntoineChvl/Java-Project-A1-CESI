package model;

import java.sql.SQLException;
import java.util.Observable;

import com.entity.mobileelements.Diamond;
import com.entity.mobileelements.Stone;
import com.entity.motionlesselements.Path;
import com.entity.motionlesselements.Walls;

import contract.IModel;
import entity.Entity;
import entity.Map;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {

	/** The helloWorld. */
	private Map map;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.map = new Map();
	}
	
	

	/**
     * Gets the hello world.
     *
     * @return the hello world
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public Map getMap() {
		return this.map;
	}

	/**
     * Sets the hello world.
     *
     * @param helloWorld
     *            the new hello world
     */
	private void setMap(final Map map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}

	/**
     * Load hello world.
     *
     * @param code
     *            the code
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage(java.lang.String)
	 */
	public void loadMap(final int id) {
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			this.setMap(daoMap.find(id));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}

	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
	
	
	public void movePlayer(char direction) {
		//Player p = this.map.getPlayer();
		
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
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public void moveUp() {
		boolean collision = checkForCollisions(this.map.getArrayMap(), map.getPlayer().getPositionX(), map.getPlayer().getPositionY()-1);
		boolean isDiamond = checkForDiamonds(this.map.getArrayMap(), map.getPlayer().getPositionX(), map.getPlayer().getPositionY()-1);
		if(!collision) {
			this.map.getArrayMap()[map.getPlayer().getPositionX()][map.getPlayer().getPositionY()-1] = this.map.getArrayMap()[map.getPlayer().getPositionX()][map.getPlayer().getPositionY()];
			this.map.getArrayMap()[map.getPlayer().getPositionX()][map.getPlayer().getPositionY()] = new Path(map.getPlayer().getPositionX(),map.getPlayer().getPositionY());
			this.map.getPlayer().setPositionY(map.getPlayer().getPositionY()-1);

			
			if(isDiamond) {
				this.getMap().getPlayer().incrementDiamondsCounter();
			}

		}
	}
	
	public void moveDown() {
		boolean collision = checkForCollisions(this.map.getArrayMap(), map.getPlayer().getPositionX(), map.getPlayer().getPositionY()+1);
		boolean isDiamond = checkForDiamonds(this.map.getArrayMap(), map.getPlayer().getPositionX(), map.getPlayer().getPositionY()+1);
		if(!collision) {
			this.map.getArrayMap()[map.getPlayer().getPositionX()][map.getPlayer().getPositionY()+1] = this.map.getArrayMap()[map.getPlayer().getPositionX()][map.getPlayer().getPositionY()];
			this.map.getArrayMap()[map.getPlayer().getPositionX()][map.getPlayer().getPositionY()] = new Path(map.getPlayer().getPositionX(),map.getPlayer().getPositionY());
			this.map.getPlayer().setPositionY(map.getPlayer().getPositionY()+1);

			
			if(isDiamond) {
				this.getMap().getPlayer().incrementDiamondsCounter();
			}
			
		}

	}
	
	public void moveLeft() {
		boolean collision = checkForCollisions(this.map.getArrayMap(), map.getPlayer().getPositionX()-1, map.getPlayer().getPositionY());
		boolean isDiamond = checkForDiamonds(this.map.getArrayMap(), map.getPlayer().getPositionX()-1, map.getPlayer().getPositionY());
		if(!collision) {
			this.map.getArrayMap()[map.getPlayer().getPositionX()-1][map.getPlayer().getPositionY()] = this.map.getArrayMap()[map.getPlayer().getPositionX()][map.getPlayer().getPositionY()];
			this.map.getArrayMap()[map.getPlayer().getPositionX()][map.getPlayer().getPositionY()] = new Path(map.getPlayer().getPositionX(),map.getPlayer().getPositionY());
			this.map.getPlayer().setPositionX(map.getPlayer().getPositionX()-1);

			
			if(isDiamond) {
				this.getMap().getPlayer().incrementDiamondsCounter();
			}
			
		}

	}
	
	public void moveRight() {
		boolean collision = checkForCollisions(this.map.getArrayMap(), map.getPlayer().getPositionX()+1, map.getPlayer().getPositionY());
		boolean isDiamond = checkForDiamonds(this.map.getArrayMap(), map.getPlayer().getPositionX()+1, map.getPlayer().getPositionY());
		if(!collision) {
			this.map.getArrayMap()[map.getPlayer().getPositionX()+1][map.getPlayer().getPositionY()] = this.map.getArrayMap()[map.getPlayer().getPositionX()][map.getPlayer().getPositionY()];
			this.map.getArrayMap()[map.getPlayer().getPositionX()][map.getPlayer().getPositionY()] = new Path(map.getPlayer().getPositionX(),map.getPlayer().getPositionY());
			this.map.getPlayer().setPositionX(map.getPlayer().getPositionX()+1);

			
			if(isDiamond) {
				this.getMap().getPlayer().incrementDiamondsCounter();
			}
			
		}

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
	
	




}
