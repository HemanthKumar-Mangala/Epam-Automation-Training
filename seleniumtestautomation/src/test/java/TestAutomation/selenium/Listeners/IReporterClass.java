package TestAutomation.selenium.Listeners;

import java.util.List;

import java.util.Collection;

import java.util.Date;

import java.util.List;

import java.util.Map;

import java.util.Set;

import org.testng.IReporter;

import org.testng.IResultMap;

import org.testng.ISuite;

import org.testng.ISuiteResult;

import org.testng.ITestContext;

import org.testng.ITestNGMethod;

import org.testng.xml.XmlSuite;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.reporters.IReporterConfig;
import org.testng.xml.XmlSuite;

public class IReporterClass implements IReporter{

	
	
		// TODO Auto-generated method stub
		//IReporter.super.generateReport(xmlSuites, suites, outputDirectory);
		
		@Override

	    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> Suites,

	            String outputDirectory) {

	      

	        for (ISuite iSuite : Suites) {
	        	

	            Map<String,ISuiteResult> results =    iSuite.getResults();

	            Set<String> keys = results.keySet();


	            for (String key : keys) {

	            

	            ITestContext context = results.get(key).getTestContext();
                  System.out.println("Value At key "+key +" is"+results.get(key));

	             System.out.println("Suite Name->"+context.getName());

 
	             IResultMap passedMap=context.getPassedTests();
	             
	             
	             Collection<ITestNGMethod> passedMethods=passedMap.getAllMethods();
	             
	             System.out.println("--------Passed TEST CASES---------");
	             
	             for (ITestNGMethod iTestNGMethod : passedMethods) {

		                //Print failed test cases detail

		                System.out.println("TESTCASE NAME :"+iTestNGMethod.getMethodName() +" Passed");

		                        

		                

		            }
	             

	             //Get Map for only failed test cases

	            IResultMap resultMap = context.getFailedTests();

	            //Get method detail of failed test cases

	            Collection<ITestNGMethod> failedMethods = resultMap.getAllMethods();

	            //Loop one by one in all failed methods

	            System.out.println("--------FAILED TEST CASES---------");

	            for (ITestNGMethod iTestNGMethod : failedMethods) {

	                //Print failed test cases detail

	                System.out.println("TESTCASE NAME->"+iTestNGMethod.getMethodName()+ " Test failed");

	                       
	                

	            }

	        }

	        }

	        

	    }

	

	@Override
	public IReporterConfig getConfig() {
		// TODO Auto-generated method stub
		return IReporter.super.getConfig();
	}
	

}
