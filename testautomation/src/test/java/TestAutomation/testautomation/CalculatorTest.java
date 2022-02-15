package TestAutomation.testautomation;


import TestAutomation.testautomation.calculator.*;
import junit.framework.TestCase;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Unit test for simple App.
 */
public class CalculatorTest extends TestCase 
{
	Calculator c;
	
	protected void setUp() throws Exception
	{
		super.setUp();
		c=new Calculator();
	}
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void testStringEquality()
    {
    	assertEquals("Hello Team","Hello Team");
    }
    
    public void testStringEquality1()
    {
    	App app=new App();
    	String greeting= app.sendGreetingMessage();
    	assertEquals(greeting,"Hello Team");
    }
    
    @Test
    public void testAdditionpositiveNumbers()
    {
    	
    	int result=c.add(1,2);
    	assertEquals(3,result);
    }
    
    @Test
    public void testAdditionNegativeNumbers()
    {
    	
    	int result=c.add(-1,-2);
    	assertEquals(-3,result);
    }
    
    
    
    @Test
    public void testSubractPositiveNumbers()
    {
    	
    	int result=c.subract(1,2);
    	assertEquals(-1,result);
    }
    
    @Test
    public void testSubractNegativeNumbers()
    {
    	
    	int result=c.subract(-1,-2);
    	assertEquals(1,result);
    }
    
    
    @Test
    public void testMultiplyPositiveNumbers()
    {
    	
    	int result=c.multiply(1,2);
    	assertEquals(2,result);
    }
    
    @Test
    public void testMultiplyNegativeNumbers()
    {
    
    	int result=c.multiply(-1,-2);
    	assertEquals(2,result);
    }
    
    
    
	@Test
    public void testDividePositiveNummbers()
    {
    	
    	int result=c.divide(1,2);
    	assertEquals(result,0);
    }
	
	@Test
    public void testDivideNegativeNumbers()
    {
    	
    	int result=c.divide(-10,-2);
    	assertEquals(result,5);
    }
	
	@Test
	public void testnull()
	{
		
    	String result=c.nullMethod();
		assertNull(result);
	}
	
//	
//	@Rule
//	public ExpectedException exception = ExpectedException.none();
	//
	
	
	@Test
	public void testdivideEception()
	{
//		exception.expect(ArithmeticException.class);
//		exception.expectMessage("Divided by zero");
		try {
		    c.divideException(10);
		    fail();
		}
		catch(ArithmeticException e)
		{
			assertEquals("Divided by zero",e.getMessage());
		}
		
	}
	
	@Test
	public void testdivideEceptionassertthrows()
	{
//		exception.expect(ArithmeticException.class);
//		exception.expectMessage("Divided by zero");
		
			assertThrows(ArithmeticException.class,()->c.divideException(10));
		
		
	}
	
	@Test
	public void doubletest()
	{
		double a=3.14;
		assertEquals(3.14,a);
	}
	
}



