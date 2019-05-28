package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.databaseconnection.DAOMap;
import com.databaseconnection.DBConnection;

public class DAOMapTest {
	
	private static DAOMap daoMap;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daoMap = new DAOMap(DBConnection.getInstance().getConnection());
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
	public void testGetMapFromDatabase() {
		
		
		assertNotNull(DAOMapTest.daoMap.find(1));
		assertNotNull(DAOMapTest.daoMap.find(2));
		assertNotNull(DAOMapTest.daoMap.find(3));
		assertNotNull(DAOMapTest.daoMap.find(4));
		assertNotNull(DAOMapTest.daoMap.find(5));

	}

}
