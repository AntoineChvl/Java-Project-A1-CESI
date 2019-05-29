package com.entity.mobileelements;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.EntityTest;

public class StoneTest extends EntityTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.entity = new Stone(7,7);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStone() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Stone.png";
		final char expectedCharName = 'o';
		final String expectedStrategy = "CascadeFalling";
		assertEquals(expectedCharName, this.entity.getSprite().getConsoleImage());
		assertEquals(expectedSpriteName, this.entity.getSprite().getImageName());
		assertEquals(expectedStrategy, this.entity.getStrategy().returnStrategy());
	}

}
