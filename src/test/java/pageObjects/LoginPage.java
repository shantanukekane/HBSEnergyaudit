package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public  LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	// locators
	
    @FindBy(xpath="//input[@id='input-email']") 
    WebElement txt_EmailAddress;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement txt_Password;

    @FindBy(xpath="//input[@value='Login']") 
    WebElement btnlogin;
    
   
    public void setEmailAddress(String email)
    {
    	txt_EmailAddress.sendKeys(email);
    }
       

    public void setPassword(String pwd)
    {
    	txt_Password.sendKeys(pwd);
    }

    public void clickLogin()
    {
    	btnlogin.click();
    }





}
