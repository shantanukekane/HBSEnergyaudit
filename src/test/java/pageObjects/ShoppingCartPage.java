package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	// locators
	@FindBy(xpath="//div[@id='cart']") 
	WebElement btnItem;
	
	@FindBy(xpath="//button[@title='Remove']") 
	WebElement removeItem;
	
	@FindBy(xpath="//strong[normalize-space()='View Cart']") 
	WebElement lnkviewCart;
		
	@FindBy(xpath = "//div[@class='col-sm-4 col-sm-offset-8']//table[@class='table table-bordered']/tbody/tr[4]/td[2]")
	WebElement lblTotalPrice;
	
	@FindBy(xpath = "//div[@class = 'pull-right']/a[text() = 'Checkout']")
    WebElement lnkcheckout;
	
	// Action Method
	
	public void ClickItemsToNavigateCart()
	{
		btnItem.click();
	}
	
	public void ClickOnViewCart()
	{
		lnkviewCart.click();
	}
	
	
	public String getTotalPrice()
	{
		return lblTotalPrice.getText();
	}
	
	
	public void clickcheckout()
	{
		lnkcheckout.click();
	}
	
	
	
}
