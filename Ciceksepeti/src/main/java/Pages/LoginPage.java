package Pages;

import org.openqa.selenium.WebDriver;

import SampleFunction.SampleFunctionPage;

public class LoginPage extends SampleFunctionPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	public HomePage login(String username , String pass) throws InterruptedException
	{
		setById("EmailLogin", username);
		setById("Password", pass);
		Thread.sleep(3000);
		clickByXpath("//*[@id=\"userLogin\"]//button[contains(text(), 'Giriþ')]");
		Thread.sleep(3000);
		return new HomePage(driver);
		
	}
	

}
