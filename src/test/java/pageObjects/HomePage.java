package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends BasePage {

	// if we want to invoke parent class constructor 
	// we have to create constructor 
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
		
	
	// locators
	@FindBy(xpath="//span[normalize-space()='My Account']") 
	WebElement lnkmyAccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
    WebElement lnkregister;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnklogin;
	
	@FindBy(xpath="//input[@placeholder='Search']") 
	WebElement txt_searchbox;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement btnsearch;
	
	public void clickMyAccount()
	{
		lnkmyAccount.click();
	}
	
	
	public void clickRegister()
	{
		lnkregister.click();
	}
	
	
	public void clickLogin()
	{
		lnklogin.click();
	}
	
	public void enterSearchProduct(String pname)
	{
		txt_searchbox.sendKeys(pname);
	}
	
	public void clickSearch()
	{
		btnsearch.click();

	}
	
	
	
	
}
