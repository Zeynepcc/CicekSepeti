package Pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import SampleFunction.SampleFunctionPage;


public class RegisterPage extends SampleFunctionPage {
	
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    public void register(String fullname ,String mail , String password) throws InterruptedException
    {
    	setById("NameIndivual", fullname);
    	setById("EmailIndivual", mail);
    	setById("PasswordIndivual",password);
    	clickByXpath("//a[contains(text(), 'Üyelik Sözleþmesi')]");
    	Thread.sleep(2000);
    	clickByXpath("//button[contains(text(),'Okudum, Kabul Ediyorum')]");
    	Thread.sleep(2000);
    	clickByXpath("//button[contains(text(),'Üye Ol')]");    	
    	
    }
    public void checkConfirm() throws InterruptedException
    {
    	clickByXpath("//a[contains(text(), 'Üyelik Sözleþmesi')]");
    	Thread.sleep(2000);
    	clickByXpath("//button[contains(text(),'Okudum, Kabul Ediyorum')]");
    }

    
}
