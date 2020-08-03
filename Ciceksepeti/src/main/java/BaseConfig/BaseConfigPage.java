package BaseConfig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseConfigPage {
	
	protected WebDriver driver;
	
	@Before
	public void Prepare()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\selenium-java-3.141.59\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	@After
	public void Finish() throws InterruptedException
	{
		Thread.sleep(2000);
        driver.quit();
	}
	

}
