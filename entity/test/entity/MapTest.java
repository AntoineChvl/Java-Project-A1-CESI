package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapTest {
	
	Map map;

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
				"qttyuttttttttxtttutqottotttttttutttttttq\r\n" + 
				"qttuutttttttttttuutqottttttotttutttttttq\r\n" + 
				"qttttttttttttttttttqxxtttttttttttttttttq\r\n" + 
				"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq", 10);
		this.map.createMapToChars();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMapFulfilled() {
		assertNotNull(this.map.getPlayer());
	}

}
