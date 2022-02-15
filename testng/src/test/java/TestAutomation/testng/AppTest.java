package TestAutomation.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;





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
    
    @BeforeMethod
    public void beforeMethod()
    {
       System.out.println("Before Method");
    }
    
    @AfterMethod
    public void afterMethod()
    {
       System.out.println("After Method");
    }
    
    @BeforeSuite
    public void beforeSuite()
    {
    	System.out.println("Before Suite");
    }
    
    @AfterSuite
    public void afterSuite()
    {
    	System.out.println("After Suite");
    }
    
    @AfterTest
    public void aftertest()
    {
    	System.out.println("After Test");
    }
    
    @BeforeTest
    public void beforetest()
    {
    	System.out.println("Before Test");
    }
    
    @Test
    public void test1()
    {
    	System.out.println("Test1");
    }
    
    @Test
    public void test2()
    {
    	System.out.println("Test2");
    }
}
