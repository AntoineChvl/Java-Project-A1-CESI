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
 * The PathTest class.
 * @author Antoine Chauvel
 * @version 1.0
 *
 */
public class PathTest extends EntityTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Instantiates a new path.
	 */
	@Before
	public void setUp() throws Exception {
		this.entity = new Path(6,6);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * The testPath method.
	 * Checks the basic sprite name, character and strategy of the path.
	 */
	@Test
	public void testPath() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Background.png";
		final char expectedCharName = 'u';
		assertEquals(expectedCharName, this.entity.getSprite().getConsoleImage());
		assertEquals(expectedSpriteName, this.entity.getSprite().getImageName());
		assertNull(this.entity.getStrategy());
	}

}
