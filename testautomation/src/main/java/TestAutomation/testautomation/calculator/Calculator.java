package TestAutomation.testautomation.calculator;

public class Calculator {

	public int add(int number1,int number2)
	{
		return number1+number2;
	}
	
	public int subract(int number1,int number2)
	{
		return number1-number2;
	}
	
	public int multiply(int number1,int number2)
	{
		return number1*number2;
	}
	
	public int divide(int number1,int number2)
	{
		return (number1/number2);
	}
	
	public String  nullMethod()
	{
		return null;
	}
	
	public void  divideException(int b) throws ArithmeticException
	{
		int a = 0;
		try{
			if(a==0)
			{
				throw new ArithmeticException("Divided by zero");
				
			}
			a=b/a;
			
		}
		catch(ArithmeticException e){
			
			throw e;
			}
	
	}
}
