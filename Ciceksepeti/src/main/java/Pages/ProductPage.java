package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import SampleFunction.SampleFunctionPage;

public class ProductPage extends SampleFunctionPage {

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	public ProductPage selectProduct(Integer index){
		
        getElementsByXpath("//*[contains(@class, 'products__item-link')]").get(index).click();  
        return new ProductPage(driver);

    }
	public void productDate(String adress) throws InterruptedException
	{
		setByXpath("//*[@id=\"productDetailSend\"]//input[contains(@class , 'js-html-tag-replace')]",adress);
		clickByXpath("//*[@id=\"productDetailSend\"]/div/div/div[2]/div[4]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		clickByXpath("//*[@id=\"productDetailSend\"]//button[contains(@class , 'btn-success product__action-button')]/span");
	}
	public ProductPage productAddCardByAdress(String adress) throws InterruptedException
	{
		setByXpath("//*[@id=\"productDetailSend\"]//input[contains(@class , 'js-html-tag-replace')]",adress);
		Thread.sleep(3000);
		clickByXpath("//*[@id=\"productDetailSend\"]/div/div/div[2]/div[4]/div[2]/div[1]/div/div/div[2]/div[1]/div[1]");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		clickByXpath("//*[@id=\"productDetailSend\"]/div/div/div[2]/div[4]/div[2]/div[5]/div[3]/div[1]");
		Thread.sleep(3000);
		clickByName("AddToCartModel.DeliveryHour");
		Thread.sleep(3000);
		clickByXpath("//*[@id=\"productDetailSend\"]//select/option[2]");
		Thread.sleep(3000);
		clickByXpath("//*[@id=\"productDetailSend\"]//button[contains(@class , 'btn-success product__action-button')]/span");
		return new ProductPage(driver);
	}
	
	 
	

}
