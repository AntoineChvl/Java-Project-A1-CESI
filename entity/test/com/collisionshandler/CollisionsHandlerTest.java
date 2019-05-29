package com.collisionshandler;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.entity.mobileelements.Enemy;
import com.entity.mobileelements.Player;
import entity.Map;

public class CollisionsHandlerTest {
	
	Map map;
	int x;
	int y;
	Player p;
	Enemy e;

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
				"qtttxttttttttttttttqtotttoottttttttxtttq\r\n" + 
				"qtttxttttttttttttttqtttttttttttttttttttq\r\n" + 
				"qttttttttoooootttttqttttuuiutttotttttttq\r\n" + 
				"qttttttttttttttttttqtttttttttttoottttttq\r\n" + 
				"qtttttttttuuiutttttqtttttttttttoottttttq\r\n" + 
				"qqqqqqqqttttqqqqqqqqqqqqqqqquuttqqqqqqqq\r\n" + 
				"qttttttttttttttttttqtttttttttttttttttttq\r\n" + 
				"qtttuuuttttttttttttqttttttttuttttttttttq\r\n" + 
				"qttttttttxttottttttqtttttttttttttttotttq\r\n" + 
				"qtootttttttotttttttqtttttutttutttttotttq\r\n" + 
				"qttotttttttttttttttotttttttttxttttotottq\r\n" + 
				"qtttottttutttttttttttttttttttttttttotteq\r\n" + 
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
				"qttyittttttttxtttutqottotttttttutttttttq\r\n" + 
				"qttuutttttttttttuutqottttttotttutttttttq\r\n" + 
				"qttttttttttttttttttqxxtttttttttttttttttq\r\n" + 
				"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", 10);
		this.map.createMapToChars();
		e = new Enemy(x+1,y);
		p = this.map.getPlayer();
		this.x = p.getPositionX();
		this.y = p.getPositionY();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

		final int expectedX = 3;
		final int expectedY = 35;
		
		
		// If collision : no movement.
		p.entityMove(1, 0, 0, 'S');
		assertEquals(expectedX, x);
		assertEquals(expectedY, y);

	}
}