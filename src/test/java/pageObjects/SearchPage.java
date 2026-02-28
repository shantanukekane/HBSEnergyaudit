package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

	
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	// locators
	@FindBy(xpath = "//div[@id='content']/div[3]//img")
	List<WebElement> searchProduct;
	
	@FindBy(xpath="//button[@id='button-cart']") 
	WebElement btnaddToCart;
	
	@FindBy(xpath="//input[@id='input-quantity']") 
	WebElement txtquantity;
	
	@FindBy(xpath = "//div[contains(text(),'Success: You have added')]")
	WebElement confmsg;
	
	
	// Action method
	
	public boolean isProductExists(String ProductName)
	{
		boolean flag = false;
		for(WebElement product:searchProduct)
		{
			if(product.getAttribute("title").equals(ProductName))
			{
				flag = true;
				break;
			}	
		}
		return flag;		

	}
	
	
	public void selectProduct(String ProductName)
	{
		for(WebElement product:searchProduct)
		{
			if(product.getAttribute("title").equals(ProductName))
			{
				product.click();
			}
		}
	}
	
	
	public void setQuantity(String Qty)
	{
		txtquantity.clear();
		txtquantity.sendKeys(Qty);
	}
	
	
	public void clickAddToCart()
	{
		btnaddToCart.click();
	}
	
	
	public boolean checkConfMsg()
	{
		try
		{
		  return (confmsg.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	
	
	
	
	
}
