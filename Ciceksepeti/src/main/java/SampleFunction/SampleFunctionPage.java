package SampleFunction;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.CardPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import Pages.RegisterPage;

public class SampleFunctionPage {
	
	public WebDriver driver;
	
	public SampleFunctionPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public HomePage callHomePage()
	{
		driver.get("https://www.ciceksepeti.com/");
		return new HomePage(driver);
	}
	public LoginPage callLoginPage()
	{
		clickByXpath("//a[@href='javascript:void(0);']");
		clickByXpath("//a[@href='/uye-girisi']");
		return new LoginPage(driver);
	}
	public ProductPage callProductPage(String keyword)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setByXpath("//*[@id=\"product-search-2\"]/input",keyword);
		clickByXpath("//*[@id=\"product-search-2\"]/button");	
		return new ProductPage(driver);
	}
	public CardPage callCardPage()
	{
		clickByXpath("//a[@href='/sepetim']");
		return new CardPage(driver);
	}
	public RegisterPage callRegisterPage()
	{
		
		clickByXpath("//a[@href='javascript:void(0);']");
		clickByXpath("//a[@href='/yeni-uyelik']");
		return new RegisterPage(driver);
	}
	public void RemoveProduct()
	{
		clickByXpath("//a[@href='/sepetim']");
		clickByXpath("//*[@id=\"shoppingCartForm\"]//a[contains(@class , 'js-main-product-delete--basket')]");
		clickByXpath("//*[@id=\"modalBox\"]//button[contains(text(),'Evet, sepetimden çýkar')]");
	}
	public void setById(String id, String value)
	{
	   WebElement element = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	   element.clear();
	   element.sendKeys(value);
	}
	public void setByXpath(String xpath, String value)
	{
	   WebElement element = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	   element.clear();
	   element.sendKeys(value);
	}
	public void clickById(String id)
	{
	   WebElement element = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.id(id)));
	   element.click();	  
    }
	public void clickByName(String name)
	{
	   WebElement element = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.name(name)));
	   element.click();	  
    }
	public void clickByClassname(String classname)
	{
        WebElement element = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.className(classname)));
        element.click();
    }
	public void clickByXpath(String xpath)
	{
        WebElement element = new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        element.click();
    }
	
	public List<WebElement> getElementsByXpath(String s) 
	{
	    return new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(s))));
	}
	
	

}
