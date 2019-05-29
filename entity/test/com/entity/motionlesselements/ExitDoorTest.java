package com.entity.motionlesselements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.EntityTest;

public class ExitDoorTest extends EntityTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.entity = new ExitDoor(3,3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExitDoor() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Door.png";
		final char expectedCharName = 'e';
		assertEquals(expectedCharName, this.entity.getSprite().getConsoleImage());
		assertEquals(expectedSpriteName, this.entity.getSprite().getImageName());
		assertNull(this.entity.getStrategy());
	}

}
