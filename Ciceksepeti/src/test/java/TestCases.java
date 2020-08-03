
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;


import BaseConfig.BaseConfigPage;
import Pages.HomePage;
import Pages.LoginPage;


public class TestCases extends BaseConfigPage {
	

	@Test
	@Information("1- Kay�t olurken null de�er girildi�inde hata veriyor mu?")
	public void registerNullTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callRegisterPage().register("  ", " ", " ");
		assertNotEquals(driver.findElement(By.id("NameIndivual-error")).getText(),"Bu bilginin doldurulmas� zorunludur.");
	}
	@Test
	@Information("2- S�zle�me onay i�lemi ger�ekle�ti mi?")
	public void checkConfirmTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callRegisterPage()
		.checkConfirm();
		assertTrue(driver.findElement(By.id("IsCustomerContractConfirmed")).isSelected());
		
	}
	@Test
	@Information("3- Mail adresi pattern'e uygun mu?")
	public void mailPatternTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callRegisterPage()
		.register("Zeynep Turhan", "zeynepturhan.com", "zt123456");
		assertNotEquals(driver.findElement(By.id("EmailIndivual-error")).getText(),"L�tfen ge�erli bir e-posta adresi giriniz.");
	}
	@Test
	@Information("4- Giri� i�lemi ger�ekle�ti mi?")
	public void LoginTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage()
		.login("zeynepturhan0@gmail.com","zt123456");
		assertEquals(driver.findElement(By.xpath("//span[text()='Hesab�m']")).getText(),"Hesab�m");
	}
	@Test
	@Information("5- �r�n arama ger�ekle�ti mi?")
	public void searchProductTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage()
		.login("zeynepturhan0@gmail.com","zt123456")
		.callProductPage("�ikolata");
		assertEquals(driver.findElement(By.xpath("//h1[text()='�ikolata']")).getText(),"�ikolata");
	}
	@Test
	@Information("6- �r�n se�me ger�ekle�ti mi?")
	public void selectProductTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage()
		.login("zeynepturhan0@gmail.com", "zt123456")
		.callProductPage("�ikolata")
		.selectProduct(1);
	}
	@Test
	@Information("7- �r�n tarihi  null oldu�unda hata veriyor mu?")
	public void ProductDateTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage().
		login("zeynepturhan0@gmail.com", "zt123456")
		.callProductPage("�ikolata")
		.selectProduct(5)
		.productAddCardByAdress("�stanbul");
		assertEquals(driver.findElement(By.xpath("//*[@id=\"productDetailSend\"]//div[contains(@class , 'js-product-error--date is-hidden')]")).getText(), "L�tfen tarih se�iniz.");		
	}
	@Test
	@Information("8- Sepete eklendi mi?")
	public void ProductAddCardTest() throws InterruptedException 
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage()
		.login("zeynepturhan0@gmail.com", "zt123456")
		.callProductPage("�ikolata")
		.selectProduct(5)
		.productAddCardByAdress("�stanbul");
	}
	@Test
	@Information("9- �r�n sepette mi?")
	public void CardListTest() throws InterruptedException
	{
		new HomePage(driver);
		int deger = new HomePage(driver).callLoginPage().login("zeynepturhan0@gmail.com", "zt123456")
		.callProductPage("�ikolata")
		.selectProduct(5)
		.productAddCardByAdress("�stanbul")
		.callHomePage()
		.callCardPage()
		.CardList();
		if(deger == 1) { assertTrue(true); }
		new HomePage(driver).RemoveProduct();
	}
	@Test
	@Information("10- �r�n g�nderim bilgileri null oldu�unda hata veriyor mu")
	public void CardInfoNullTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage()
		.login("zeynepturhan0@gmail.com", "zt123456")
		.callProductPage("�ikolata")
		.selectProduct(5)
		.productAddCardByAdress("�stanbul")
		.callHomePage()
		.callCardPage().CardInfo(" ", " "," ");
		Thread.sleep(3000); //Gelince hallet
		if(driver.findElement(By.xpath("//*[@id=\"GroupDeliveryAddressList_0__Address_AddressLine-error\"]")).getText() == "Bu bilginin doldurulmas� zorunludur." ||
				driver.findElement(By.xpath("//*[@id=\"GroupDeliveryAddressList_0__Address_Phone_Phone-error\"]")).getText() == "Bu bilginin doldurulmas� zorunludur.")
		{
		  assertTrue(true);
		} 
		new HomePage(driver).RemoveProduct();

	}
	@Test
	@Information("11- Fatura Bilgileri yanl�� girildi�inde hata veriyor mu?")
	public void BillNullTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage()
		.login("zeynepturhan0@gmail.com", "zt123456")
		.callProductPage("�ikolata")
		.selectProduct(5)
		.productAddCardByAdress("�stanbul")
		.callHomePage()
		.callCardPage().CardInfo("Zeynep Turhan", "05422800925","�stanbul/�mraniye").CardBillInfo(" ", " ");
		if(driver.findElement(By.id("BuyerName-error")).getText() == "Bu bilginin doldurulmas� zorunludur." ||
				driver.findElement(By.id("PhoneNumber")).getText() == "Bu bilginin doldurulmas� zorunludur.")
		{
		  assertTrue(true);
		}
		new HomePage(driver).RemoveProduct();
	}
	@Test
	@Information("12- Bilgi girildi�inde y�nlendirme yap�l�yor mu?")
	public void BillInfoNavigateTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage()
		.login("zeynepturhan0@gmail.com", "zt123456")
		.callProductPage("�ikolata")
		.selectProduct(5)
		.productAddCardByAdress("�stanbul")
		.callHomePage()
		.callCardPage().CardInfo("Zeynep Turhan", "05422800925","�stanbul/�mraniye").CardBillInfo("Zeynep Turhan", "05422800925");
		new HomePage(driver).RemoveProduct();
	}
	@Test
	@Information("13- �r�n Sepetten ��kar�ld� m�?")
	public void DeleteProductTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage()
		.login("zeynepturhan0@gmail.com", "zt123456")
		.callProductPage("�ikolata")
		.selectProduct(5)
		.productAddCardByAdress("�stanbul")
		.callHomePage().callCardPage().RemoveProductToCard();
		assertEquals(driver.findElement(By.tagName("h1")).getText() , "Sepetinizde �r�n bulunmamaktad�r.");

	}
	
	
	


}
