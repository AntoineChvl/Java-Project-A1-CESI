package com.collisionshandler;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.entity.mobileelements.Enemy;
import com.entity.mobileelements.Player;
import com.entity.mobileelements.Stone;

import entity.Map;

public class CollisionsHandlerTest {
	
	private Map map;
	private int x;
	private int y;
	private Player p;
	@SuppressWarnings("unused")
	private Enemy e;
	private Stone s;
	private Stone sForMove;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.map = new Map(1 , "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq\r\n" + 
				"qtttootttttttttttttqtttttttttttttttttttq\r\n" + 
				"qtttuttttttttttttttqtotttoottttttttxtttq\r\n" + 
				"qtttuuuttttttttttttqtttttttttttttttttttq\r\n" + 
				"qttttttttoooootttttqttttuuiutttotttttttq\r\n" + 
				"qttttttttutttttttttqtttttttttttoottttttq\r\n" + 
				"qttttttttuuuiutttttqtttttttttttoottttttq\r\n" + 
				"qqqqqqqqttttqqqqqqqqqqqqqqqquuttqqqqqqqq\r\n" + 
				"qttttttttttttttttttqtttttttttttttttttttq\r\n" + 
				"qtttuuuttttttttttttqttttttttuttttttttttq\r\n" + 
				"qttttttttxttottttttqtttttttttttttttotttq\r\n" + 
				"qtootttttttouttttttqtttttutttutttttotttq\r\n" + 
				"qttottttttttuttttttotttttttttxttttotottq\r\n" + 
				"qtttottttuttuttttttttttttttttttttttotteq\r\n" + 
				"qttxxttttuuttttotttutttttttttttttttttttq\r\n" + 
				"qttttttttttttttotttqttttottttttttttttttq\r\n" + 
				"qttttttttttttttotttqttttootttttuuttttttq\r\n" + 
				"qtttuuutttttttootttqttttotttttttottttttq\r\n" + 
				"qttttttttttttttttttqtttoootttttttttttttq\r\n" + 
				"qqqqqqqqttttqqqqqqqqqqqqqqqqttxtqqqqqqqq\r\n" + 
				"qtttttottttttttttutqtttttttttttttutttttq\r\n" + 
				"qttttxotttttttttuttqttxttttttttttitttttq\r\n" + 
				"qttttttttttttttttttqtttttttttttttutttttq\r\n" + 
				"qtttttttttutttottttqtttttttttttttttttotq\r\n" + 
				"qttuttttttttttotttuoutttttttttttttttttoq\r\n" + 
				"qtttttttttttttottttotttttttttotttttttxtq\r\n" + 
				"qtttttxuutttttttttttttttttttootttttttttq\r\n" + 
				"qttttttttttttttttttqttttttttootttttttttq\r\n" + 
				"qtttttttttutttttottqtuiutttttttttttttttq\r\n" + 
				"qtttttttttuttttttotqttxttttttttttttttttq\r\n" + 
				"qttttttttttttttttttqtttttttttttttttttttq\r\n" + 
				"qqqqqqqqttooqqqqqqqqqqqqqqqqttttqqqqqqqq\r\n" + 
				"qttttttttttttttttttqtttttttttttotttttttq\r\n" + 
				"qttttttuotttttootttqttttttttttttttottttq\r\n" + 
				"qttutttttttttttttttqutttttuttttutttotttq\r\n" + 
				"qttyouuttttttxtttutqottotttttttutttttttq\r\n" + 
				"qttuutttttttttttuutqottttttotttutttttttq\r\n" + 
				"qttttttttttttttttttqxxtttttttttttttttttq\r\n" + 
				"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", 10);
		this.map.createMapToChars();
		e = new Enemy(x+1,y);
		p = this.map.getPlayer();
		this.x = p.getPositionX();
		this.y = p.getPositionY();
		s = (Stone) map.getArrayMap()[4][1];
		sForMove = (Stone)map.getArrayMap()[4][35];
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCollision() {

		final int expectedX = 3;
		final int expectedY = 35;
		
		
		// If collision : no movement.
		p.entityMove(1, 0, 0, 'S');
		assertEquals(expectedX, x);
		assertEquals(expectedY, y);

	}
	
	@Test
	public void testGravity() {
		
		final int expectedYAfterGravity = 3;
		
		
		for (int i=0;i<3;i++) {
            map.runStrategies();
        }
		assertEquals(expectedYAfterGravity, s.getPositionY());

	}
	
	@Test
	public void testMoveStone() {
		
		p.entityMove(1, 0, 1, 'S');
		
		final int expectedStoneXAfterMove = 5;
		
		assertEquals(expectedStoneXAfterMove, sForMove.getPositionX());

	}
	
	
	
	
}