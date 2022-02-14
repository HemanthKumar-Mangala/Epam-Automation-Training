package TestAutomation.testng;



import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class TestIgnore {

	@Test
	public void testApp1()
	{
		assertTrue(true);
	}
	
	@Test(enabled=false)
	public void testApp2()
	{
		assertTrue(true);
	}
}
