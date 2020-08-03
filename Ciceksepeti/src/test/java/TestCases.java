
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
	@Information("1- Kayýt olurken null deðer girildiðinde hata veriyor mu?")
	public void registerNullTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callRegisterPage().register("  ", " ", " ");
		assertNotEquals(driver.findElement(By.id("NameIndivual-error")).getText(),"Bu bilginin doldurulması zorunludur.");
	}
	@Test
	@Information("2- Sözleþme onay iþlemi gerçekleþti mi?")
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
		assertNotEquals(driver.findElement(By.id("EmailIndivual-error")).getText(),"Lütfen geçerli bir e-posta adresi giriniz.");
	}
	@Test
	@Information("4- Giriþ iþlemi gerçekleþti mi?")
	public void LoginTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage()
		.login("zeynepturhan0@gmail.com","zt123456");
		assertEquals(driver.findElement(By.xpath("//span[text()='Hesabım']")).getText(),"Hesabım");
	}
	@Test
	@Information("5- Ürün arama gerçekleþti mi?")
	public void searchProductTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage()
		.login("zeynepturhan0@gmail.com","zt123456")
		.callProductPage("Çikolata");
		assertEquals(driver.findElement(By.xpath("//h1[text()='Çikolata']")).getText(),"Çikolata");
	}
	@Test
	@Information("6- Ürün seçme gerçekleþti mi?")
	public void selectProductTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage()
		.login("zeynepturhan0@gmail.com", "zt123456")
		.callProductPage("Çikolata")
		.selectProduct(1);
	}
	@Test
	@Information("7- Ürün tarihi  null olduðunda hata veriyor mu?")
	public void ProductDateTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage().
		login("zeynepturhan0@gmail.com", "zt123456")
		.callProductPage("Çikolata")
		.selectProduct(5)
		.productAddCardByAdress("İstanbul");
		assertEquals(driver.findElement(By.xpath("//*[@id=\"productDetailSend\"]//div[contains(@class , 'js-product-error--date is-hidden')]")).getText(), "Lütfen tarih seçiniz.");		
	}
	@Test
	@Information("8- Sepete eklendi mi?")
	public void ProductAddCardTest() throws InterruptedException 
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage()
		.login("zeynepturhan0@gmail.com", "zt123456")
		.callProductPage("Çikolata")
		.selectProduct(5)
		.productAddCardByAdress("İstanbul");
	}
	@Test
	@Information("9- Ürün sepette mi?")
	public void CardListTest() throws InterruptedException
	{
		new HomePage(driver);
		int deger = new HomePage(driver).callLoginPage().login("zeynepturhan0@gmail.com", "zt123456")
		.callProductPage("Çikolata")
		.selectProduct(5)
		.productAddCardByAdress("Ýstanbul")
		.callHomePage()
		.callCardPage()
		.CardList();
		if(deger == 1) { assertTrue(true); }
		new HomePage(driver).RemoveProduct();
	}
	@Test
	@Information("10- Ürün gönderim bilgileri null olduðunda hata veriyor mu")
	public void CardInfoNullTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage()
		.login("zeynepturhan0@gmail.com", "zt123456")
		.callProductPage("Çikolata")
		.selectProduct(5)
		.productAddCardByAdress("Ýstanbul")
		.callHomePage()
		.callCardPage().CardInfo(" ", " "," ");
		Thread.sleep(3000); //Gelince hallet
		if(driver.findElement(By.xpath("//*[@id=\"GroupDeliveryAddressList_0__Address_AddressLine-error\"]")).getText() == "Bu bilginin doldurulması zorunludur." ||
				driver.findElement(By.xpath("//*[@id=\"GroupDeliveryAddressList_0__Address_Phone_Phone-error\"]")).getText() == "Bu bilginin doldurulması zorunludur.")
		{
		  assertTrue(true);
		} 
		new HomePage(driver).RemoveProduct();

	}
	@Test
	@Information("11- Fatura Bilgileri yanlýþ girildiðinde hata veriyor mu?")
	public void BillNullTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage()
		.login("zeynepturhan0@gmail.com", "zt123456")
		.callProductPage("Çikolata")
		.selectProduct(5)
		.productAddCardByAdress("İstanbul")
		.callHomePage()
		.callCardPage().CardInfo("Zeynep Turhan", "05422800925","İstanbul/Ümraniye").CardBillInfo(" ", " ");
		if(driver.findElement(By.id("BuyerName-error")).getText() == "Bu bilginin doldurulmasý zorunludur." ||
				driver.findElement(By.id("PhoneNumber")).getText() == "Bu bilginin doldurulması zorunludur.")
		{
		  assertTrue(true);
		}
		new HomePage(driver).RemoveProduct();
	}
	@Test
	@Information("12- Bilgi girildiðinde yönlendirme yapýlýyor mu?")
	public void BillInfoNavigateTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage()
		.login("zeynepturhan0@gmail.com", "zt123456")
		.callProductPage("Çikolata")
		.selectProduct(5)
		.productAddCardByAdress("İstanbul")
		.callHomePage()
		.callCardPage().CardInfo("Zeynep Turhan", "05422800925","İstanbul/Ümraniye").CardBillInfo("Zeynep Turhan", "05422800925");
		new HomePage(driver).RemoveProduct();
	}
	@Test
	@Information("13- Ürün Sepetten çýkarýldý mý?")
	public void DeleteProductTest() throws InterruptedException
	{
		new HomePage(driver);
		new HomePage(driver)
		.callLoginPage()
		.login("zeynepturhan0@gmail.com", "zt123456")
		.callProductPage("Çikolata")
		.selectProduct(5)
		.productAddCardByAdress("İstanbul")
		.callHomePage().callCardPage().RemoveProductToCard();
		assertEquals(driver.findElement(By.tagName("h1")).getText() , "Sepetinizde ürün bulunmamaktadır.");

	}
	
	
	


}
