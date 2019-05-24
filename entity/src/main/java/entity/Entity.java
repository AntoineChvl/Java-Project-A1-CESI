package entity;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity {
	
	
	private Sprite sprite;
	private int positionX;
	private int positionY;
	private Map map;
	private int diamondsCounter;
	
	public Entity(final Sprite sprite, int x, int y) {
		this.setSprite(sprite);
		this.positionX = x;
		this.positionY = y;
		this.diamondsCounter = 0;
	}
	
	public Entity() {
		
	}
	
	public void setMap(Map map) {
		this.map = map;
	}
	
	public Map getMap() {
		return this.map;
	}
	
	
	public final void setSprite(final Sprite sprite) {
        this.sprite = sprite;
    }
	
	public final Sprite getSprite() {
        return this.sprite;
    }
	
	public void setPositionX(int x) {
		this.positionX = x;
	}
	
	public int getPositionX() {
		return this.positionX;
	}
	
	public int getPositionY() {
		return this.positionY;
	}
	
	public void setPositionY(int y) {
		this.positionY = y;
	}

	public Sprite getSpriteUp() {
		return null;
	}
	public  Sprite getSpriteDown() {
		return null;
	}
	public  Sprite getSpriteTurnLeft() {
		return null;
	}
	public Sprite getSpriteTurnRight() {
		return null;
	}

	public void incrementDiamondsCounter() {
		this.diamondsCounter++;
	}
	
	public int getDiamondsCounter() {
		return this.diamondsCounter;
	}
	
	

}

