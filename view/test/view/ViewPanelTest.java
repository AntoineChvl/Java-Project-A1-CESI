package view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ViewPanelTest {
	
	static ViewPanel vp;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		vp = new ViewPanel();
	}

	@After
	public void tearDown() throws Exception {
	}

	 @Test
	    public void test() {
	        try {
	            vp.setCounter(-100);
	            ViewPanel.startTimer();
	            fail("Failed");
	        } catch (IndexOutOfBoundsException anIndexOutOfBoundsException) {
	            assertEquals(anIndexOutOfBoundsException.getMessage(), "Wrong parameters"); // If there is an exception, the assert equals will return true
	        }
	    }
}
