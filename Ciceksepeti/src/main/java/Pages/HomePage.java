package Pages;

import org.openqa.selenium.WebDriver;

import SampleFunction.SampleFunctionPage;

public class HomePage extends SampleFunctionPage {
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		driver.get("https://www.ciceksepeti.com/");
	}



}
