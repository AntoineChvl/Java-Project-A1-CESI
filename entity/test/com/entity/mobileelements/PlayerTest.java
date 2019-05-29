package com.entity.mobileelements;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.EntityTest;
import entity.Sprite;

public class PlayerTest extends EntityTest {
	
	private Player pTest;
    private char keyPressed;
 
    private static final Sprite spriteDown = new Sprite('y', "Rockford.png");
    private static final Sprite spriteTurnLeft = new Sprite('y', "Left_Rockford.png");
    private static final Sprite spriteTurnRight = new Sprite('y', "Right_Rockford.png");
    private static final Sprite spriteUp = new Sprite('y', "Back_Rockford1.png");

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
            spriteUp.loadImage();
        } catch (IOException e) {
            System.out.println("An error has occured");
            e.printStackTrace();
        }
        try {
            spriteTurnLeft.loadImage();
        } catch (IOException e) {
            System.out.println("An error has occured");
            e.printStackTrace();
        }
        try {
            spriteTurnRight.loadImage();
        } catch (IOException e) {
            System.out.println("An error has occured");
            e.printStackTrace();
        }
        try {
            spriteDown.loadImage();
        } catch (IOException e) {
            System.out.println("An error has occured");
            e.printStackTrace();
        }
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.entity = new Player(6,6);
		pTest  = new Player(0,0);
		keyPressed  = 'Z';
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPlayer() {
		super.testEntityBasicCharacteristics();
		final String expectedSpriteName = "Rockford.png";
		final char expectedCharName = 'y';
		assertEquals(expectedCharName, this.entity.getSprite().getConsoleImage());
		assertEquals(expectedSpriteName, this.entity.getSprite().getImageName());
		assertNull(this.entity.getStrategy());
	}
	
	
	@Test
    public void testMovePlayer() {
            switch (keyPressed) {
            case 'Z':
                pTest.setSprite(spriteDown);
                break;
            case 'Q':
                pTest.setSprite(spriteTurnLeft);
                break;
            case 'S':
                pTest.setSprite(spriteUp);
                break;
            case 'D':
                pTest.setSprite(spriteTurnRight);
                break;
            }
            assertEquals(spriteDown, pTest.getSprite());
    }
}
