package com.entity.motionlesselements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.EntityTest;

/**
 * The WallsTest class.
 * @author Antoine Chauvel
 * @version 1.0
 *
 */
public class WallsTest extends EntityTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new wall.
	 */
	@Before
	public void setUp() throws Exception {
		this.entity = new Walls(7,7);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The testWalls method.
	 * Checks the basic sprite name, character and strategy of walls.
	 */
	@Test
	public void testWalls() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Wall.png";
		final char expectedCharName = 'q';
		assertEquals(expectedCharName, this.entity.getSprite().getConsoleImage());
		assertEquals(expectedSpriteName, this.entity.getSprite().getImageName());
		assertNull(this.entity.getStrategy());
	}

}
