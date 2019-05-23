package entity;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity {
	
	
	Sprite sprite;
	int positionX;
	int positionY;
	
	public Entity(final Sprite sprite, int x, int y) {
		this.setSprite(sprite);
		this.positionX = x;
		this.positionY = y;
	}
	
	public Entity() {
		
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
	
	

}

