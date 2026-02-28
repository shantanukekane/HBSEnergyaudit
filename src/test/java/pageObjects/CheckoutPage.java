package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver)
	{
		super(driver);
	}
	
// locators
// checkout options
@FindBy(xpath="//input[@id='button-account']") 
WebElement chek_continue;
	
@FindBy(xpath="//input[@id='input-payment-firstname']") 
WebElement txtfirstName;

@FindBy(xpath="//input[@id='input-payment-lastname']") 
WebElement txtlastName;

@FindBy(xpath="//input[@id='input-payment-email']") 
WebElement txtEMail;

@FindBy(xpath="//input[@id='input-payment-telephone']") 
WebElement txttelephone;

@FindBy(xpath="//input[@id='input-payment-password']") 
WebElement txtpassword;

@FindBy(xpath="//input[@id='input-payment-confirm']") 
WebElement txtpasswordConfirm;


@FindBy(xpath="//input[@id='input-payment-company']") 
WebElement txtcompany;

@FindBy(xpath="//input[@id='input-payment-address-1']") 
WebElement txtaddress1;

@FindBy(xpath="//input[@id='input-payment-address-2']") 
WebElement txtaddress2;

@FindBy(xpath="//input[@id='input-payment-city']") 
WebElement txtcity;

@FindBy(xpath="//input[@id='input-payment-postcode']") 
WebElement txtpostCode;

@FindBy(xpath="//select[@id='input-payment-country']") 
WebElement dp_country;

@FindBy(xpath="//select[@id='input-payment-zone']") 
WebElement dp_region_State;
	
@FindBy(xpath="//input[@id='button-payment-address']")
WebElement btncontinueBillingAddress;

@FindBy(xpath="//input[@id='button-shipping-address']")
WebElement btncontinueDeliveryAddress;

@FindBy(xpath="//textarea[@name='comment']")
WebElement txtDeliveryMethod;

@FindBy(xpath="//input[@id='button-shipping-method']")
WebElement btncontinueShippingAddress;


@FindBy(xpath="//input[@name='agree']")
WebElement chkboxTerms;


@FindBy(xpath="//input[@id='button-payment-method']")
WebElement btncontinuePaymentMethod;


@FindBy(xpath="//strong[text()='Total:']//following::td")
WebElement lblTotalPrice;


@FindBy(xpath="//input[@id='button-confirm']")
WebElement btnConfOrder;


@FindBy(xpath="//*[@id='content']/h1")
WebElement lblOrderConMsg;


	
    // Action Methods
    
    public void clickContinuebtn()
    {
    	chek_continue.click();
    }

    public void setFirstName(String fname)
    {
    	txtfirstName.sendKeys(fname);
    }

    public void setLastName(String Lname)
    {
    	txtlastName.sendKeys(Lname);
    }
    
    
    public void setCompany(String cname)
    {
    	txtcompany.sendKeys(cname);
    }

    
    public void setAddress1(String add1)
    {
    	txtaddress1.sendKeys(add1);
    }

    public void setAddress2(String add2)
    {
    	txtaddress2.sendKeys(add2);
    }

    public void setCity(String city)
    {
    	txtcity.sendKeys(city);
    }
    
    
    public void setPostalCode(String pincode)
    {
    	txtpostCode.sendKeys(pincode);
    }
    
    
    public void SetCountry(String country)
    {
    	Select dpcountry = new Select(dp_country);
    	dpcountry.selectByVisibleText(country);
    }

    
    public void SetState(String state)
    {
    	Select dpstate = new Select(dp_region_State);
    	dpstate.selectByVisibleText(state);
    	
    }
    
    public void clickOnContinueAfterBillingAddress()
	{
		btncontinueBillingAddress.click();
	}
	
	public void clickOnContinueAfterDeliveryAddress()
	{
		btncontinueDeliveryAddress.click();
	}
	
	
	public void setDeliveryMethodComment(String deliverymsg)
	{
		txtDeliveryMethod.sendKeys(deliverymsg);
		
	}
	
	public void clickOnContinueAfterDeliveryMethod()
	{
		btncontinueShippingAddress.click();
	}
	
	public void selectTermsAndConditions()
	{
		chkboxTerms.click();
	}
	
	public void clickOnContinueAfterPaymentMethod()
	{
		btncontinuePaymentMethod.click();
	}
	
	public String  getTotalPriceBeforeConfOrder()
	{
		return lblTotalPrice.getText(); 
		
	}
	
	public void clickOnConfirmOrder() {
		btnConfOrder.click();
	}
	
	public boolean isOrderPlaced() throws InterruptedException
	{
		try
		{
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		btnConfOrder.click();
		Thread.sleep(3000);
		if(lblOrderConMsg.getText().equals("Your order has been placed!"))
			return true;
		else
			return false;
		}catch(Exception e)
		{
			return false;
		}
		
	}

    
    
    
}
