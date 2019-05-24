package entity;

import com.entity.mobileelements.Diamond;
import com.entity.mobileelements.Enemy;
import com.entity.mobileelements.Player;
import com.entity.mobileelements.Stone;
import com.entity.motionlesselements.Dirt;
import com.entity.motionlesselements.ExitDoor;
import com.entity.motionlesselements.Path;
import com.entity.motionlesselements.Walls;

public class Map extends Entity {

	private String contentOfMap;

	/** The id. */
	private int id;

	private Entity[][] mapToChars;

	/**
	 * Instantiates a new hello world.
	 *
	 * @param id      the id
	 * @param key     the key
	 * @param message the message
	 */
	public Map(final int id, final String content) {
		this.setId(id);
		this.setContentOfMap(content);
		this.createMapToChars();

	}

	/**
	 * Instantiates a new hello world.
	 */
	public Map() {
		this(1, "");
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getContentOfMap() {
		return this.contentOfMap;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setContentOfMap(final String content) {
		this.contentOfMap = content;
	}

	public int getHeightMap() {
		String[] mapFirstLength = getContentOfMap().split("\n");
		return mapFirstLength.length;
	}

	public int getWidthMap() {
		String[] mapFirstLength = getContentOfMap().split("\n");
		return mapFirstLength[0].length() - 1;
	}

	public void createMapToChars() {
		
		
		String map = this.getContentOfMap();
		//System.out.println(map);
		//System.out.println(getHeightMap());
		//System.out.println(getWidthMap());
		if (getHeightMap() >= 1 && getWidthMap() >= 1) {
			this.mapToChars = new Entity[this.getWidthMap()][this.getHeightMap()];
			for (int y = 0; y < getHeightMap(); y++) {
				String[] finalMap = map.split("\n");
				for (int x = 0; x < getWidthMap(); x++) {
					switch (finalMap[y].toCharArray()[x]) {
					case 'q':
						mapToChars[x][y] = new Walls(x,y);
						break;
					case 't':
						mapToChars[x][y] = new Dirt(x,y);
						break;
					case 'y':
						mapToChars[x][y] = new Player(x,y);
						break;
					case 'o':
						mapToChars[x][y] = new Stone(x,y);
						break;
					case 'i':
						mapToChars[x][y] = new Enemy(x,y);
						break;
					case 'u':
						mapToChars[x][y] = new Path(x,y);
						break;
					case 'x':
						mapToChars[x][y] = new Diamond(x,y);
						break;
					case 'e':
						mapToChars[x][y] = new ExitDoor(x,y);
						break;
					default:
						break;
					}
				}
			}
		}
	}
	
	public Entity[][] getArrayMap(){
		
		return this.mapToChars;
	}
	
	public Player getPlayer() {
        Entity[][] entity = this.getArrayMap();
        for (int y = 0; y < getHeightMap(); y++) {
            for (int x = 0; x < getWidthMap(); x++) {
                if (entity[x][y] instanceof Player) {
                    return (Player) entity[x][y];
                }
            }
        }
        return null;
    }
	
	public Stone getStone() {
        Entity[][] entity = this.getArrayMap();
        for (int y = 0; y < getHeightMap(); y++) {
            for (int x = 0; x < getWidthMap(); x++) {
                if (entity[x][y] instanceof Stone) {
                    return (Stone) entity[x][y];
                }
            }
        }
        return null;
    }
	
	
	

}
