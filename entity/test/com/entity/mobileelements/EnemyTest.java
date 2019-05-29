package com.entity.mobileelements;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import entity.EntityTest;

public class EnemyTest extends EntityTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.entity = new Enemy(5,5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEnemy() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Enemy.png";
		final char expectedCharName = 'i';
		final String expectedStrategy = "RandonEnemyMove";
		assertEquals(expectedCharName, this.entity.getSprite().getConsoleImage());
		assertEquals(expectedSpriteName, this.entity.getSprite().getImageName());
		assertEquals(expectedStrategy, this.entity.getStrategy().returnStrategy());
	}

}
