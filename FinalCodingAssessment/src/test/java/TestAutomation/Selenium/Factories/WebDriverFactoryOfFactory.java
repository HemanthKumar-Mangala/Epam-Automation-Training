package TestAutomation.Selenium.Factories;

public class WebDriverFactoryOfFactory {


	public static DriverFactory getWebDriverfactory(String platform)
	{
		DriverFactory factory=null;
		if(platform.equalsIgnoreCase("Localwebdriver"))
		{
			factory=new WebDriverFactory();
			return factory;
		}
		else if(platform.equalsIgnoreCase("Griddriver"))
		{
			factory=new WebGridFactory();
			return factory;
		}
		else if(platform.equalsIgnoreCase("Saucedriver"))
		{
			factory=new WebSaucedDriverFactory();
			return factory;
		}
		
		return null;
	}
}
