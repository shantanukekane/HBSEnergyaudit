package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegisterPage extends BasePage {

	
	public AccountRegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	// locators
	
@FindBy(xpath="//input[@id='input-firstname']") 
WebElement txt_firstName;
	
@FindBy(xpath="//input[@id='input-lastname']") 
WebElement txt_lastName;

@FindBy(xpath="//input[@id='input-email']") 
WebElement txt_eMail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txt_telephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtpassword;

@FindBy(xpath="//input[@id='input-confirm']") 
WebElement txtpasswordConfirm;

@FindBy(xpath="//label[normalize-space()='Yes']/input")
WebElement btnsubscription;

@FindBy(xpath="//input[@name='agree']") 
WebElement chkpolicy;
	
@FindBy(xpath = "//input[@value='Continue']")
WebElement btncontinue;
	
@FindBy(xpath = "//div[@id = 'content']/h1")
WebElement msgconfirmation;
	
	
     // Action methods

     public void setFirstName(String fname)
     {
    	 txt_firstName.sendKeys(fname);
     }

     public void setLastName(String lname)
     {
    	 txt_lastName.sendKeys(lname);
     }
     
     public void setEmail(String email)
     {
    	 txt_eMail.sendKeys(email);
     }
     
     public void setTelephone(String phone)
     {
    	 txt_telephone.sendKeys(phone);
     }
     
     
     public void setPassword(String pwd)
     {
    	 txtpassword.sendKeys(pwd);
     }

     public void setConfirmPassword(String pwd)
     {
    	 txtpasswordConfirm.sendKeys(pwd);
     }
     
     public void setSubscription()
     {
    	 btnsubscription.click();
     }
     
     
     public void clickcheckPolicy()
     {
    	 chkpolicy.click();
     }

     public void clickContinue()
     {
    	 // sol 1
    	 btncontinue.click();
    	 
    	 // sol 2
    	// btncontinue.submit();
    	 
    	 // sol 3 using actions class
    	 // Actions act = new Actions(driver);
         //act.moveToElement(btncontinue).build().perform();
    	 
    	 
    	 // sol 4 using javascriptExecutor
    	// JavascriptExecutor js = (JavascriptExecutor) driver;
    	 //js.executeScript("arguments[0].click();", btncontinue);
    	 
    	 
    	 // sol 5 using webdriver wait
    	// WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
    	 //mywait.until(ExpectedConditions.elementToBeClickable(btncontinue));
    	 
    	 // sol 6 keyboard action
    	 //btncontinue.sendKeys(Keys.RETURN); 	 
         
     }


     public String checkConfirmation()
     {
    	 try
    	 {
    	    return (msgconfirmation.getText());   // if we got the message it return in the form of String
    	 }
    	 catch(Exception e)
    	 {
    		return (e.getMessage());  // if we got exception then it return What type exception message
    	 }
     }
	
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
	
}
