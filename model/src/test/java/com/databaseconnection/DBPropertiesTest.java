package com.databaseconnection;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DBPropertiesTest {
	
	static DBProperties dpProperties;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		dpProperties = new DBProperties();
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
	public void test() {
		
		final String url = "jdbc:mysql://localhost/jpublankproject?autoReconnect=true&useSSL=false";
		final String login = "root";
		final String password = "";
		
		assertEquals(url, dpProperties.getUrl());
		assertEquals(login, dpProperties.getLogin());
		assertEquals(password, dpProperties.getPassword());
	}

}
