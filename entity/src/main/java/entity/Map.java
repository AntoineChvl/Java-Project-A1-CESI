package entity;

import java.util.Arrays;

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
		
		
		int i = 0;
		int j = 0;
	
		if (getWidthMap() > 0 && getHeightMap() >0 ) {
			this.mapToChars = new Entity[getWidthMap()][getHeightMap()];
			for (i = 0; i < getHeightMap(); i++) {
				for (j = 0; j < getWidthMap(); j++) {
					this.mapToChars[j][i] = 'X';
				}
			}
		}
		
		System.out.println(Arrays.deepToString(mapToChars));
	}

}
