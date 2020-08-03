package Pages;

import org.openqa.selenium.WebDriver;

import SampleFunction.SampleFunctionPage;

public class CardPage  extends SampleFunctionPage {

	public CardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public int CardList()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getElementsByXpath("//*[@id=\"shoppingCartForm\"]/div/div/div[1]").size();
	}
	public CardPage CardInfo(String fullname , String phonenumber , String adress) throws InterruptedException
	{
		clickByXpath("//button[contains(text(),'Satýn Al')]");
		setById("GroupDeliveryAddressList_0__Address_AddressName" , fullname);
		setById("GroupDeliveryAddressList_0__Address_Phone_Phone" , phonenumber);
		setById("GroupDeliveryAddressList_0__Address_AddressLine", adress);
		clickByXpath("//button/span[text()='Ýleri']");
		Thread.sleep(3000);
		clickByXpath("//button/span[text()='Ýleri']");
		return new CardPage(driver);

	}
	public CardPage CardBillInfo(String name, String phoneNumber ) throws InterruptedException
	{
		setById("BuyerName",name);
		setById("PhoneNumber",phoneNumber);
		Thread.sleep(3000);
		clickByXpath("//button/span[text()='Ýleri']");
		return new CardPage(driver);
		
	}
	public void RemoveProductToCard()
	{
		clickByXpath("//*[@id=\"shoppingCartForm\"]//a[contains(@class , 'js-main-product-delete--basket')]");
		clickByXpath("//*[@id=\"modalBox\"]//button[contains(text(),'Evet, sepetimden çýkar')]");
		clickByXpath("//a[@href='/sepetim']");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
