package TestAutomation.testautomation;
import TestAutomation.testautomation.calculator.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
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
    	Calculator c=new Calculator();
    	int result=c.add(1,2);
    	assertEquals(3,result);
    }
    
    @Test
    public void testAdditionNegativeNumbers()
    {
    	Calculator c=new Calculator();
    	int result=c.add(-1,-2);
    	assertEquals(-3,result);
    }
    
    
    
    @Test
    public void testSubractPositiveNumbers()
    {
    	Calculator c=new Calculator();
    	int result=c.subract(1,2);
    	assertEquals(-1,result);
    }
    
    @Test
    public void testSubractNegativeNumbers()
    {
    	Calculator c=new Calculator();
    	int result=c.subract(-1,-2);
    	assertEquals(1,result);
    }
    
    
    @Test
    public void testMultiplyPositiveNumbers()
    {
    	Calculator c=new Calculator();
    	int result=c.multiply(1,2);
    	assertEquals(2,result);
    }
    
    @Test
    public void testMultiplyNegativeNumbers()
    {
    	Calculator c=new Calculator();
    	int result=c.multiply(-1,-2);
    	assertEquals(2,result);
    }
    
    
    
	@Test
    public void testDividePositiveNummbers()
    {
    	Calculator c=new Calculator();
    	int result=c.divide(1,2);
    	assertEquals(result,0);
    }
	
	@Test
    public void testDivideNegativeNumbers()
    {
    	Calculator c=new Calculator();
    	int result=c.divide(-10,-2);
    	assertEquals(result,5);
    }
	
	@Test
	public void testnull()
	{
		Calculator c=new Calculator();
    	String result=c.nullMethod();
		assertNull(result);
	}
}
