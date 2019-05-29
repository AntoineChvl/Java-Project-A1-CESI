package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EntityTest {
	
	protected Entity entity;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testEntityBasicCharacteristics() {
		assertNotNull(entity.getSprite());
		assertNotNull(entity.getPositionX());
		assertNotNull(entity.getPositionY());
	}
}
