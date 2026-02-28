package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.AccountRegisterPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_006_EndToEnd_Ecom_Test extends BaseClass {

	@Test(groups = {"Master"})
	public void Verify_EndToEndWorkFlow() throws InterruptedException
	{
		System.out.print("Creating the account register..........");
		
		//softassert
		SoftAssert myassert = new SoftAssert();
		
		// Homepage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		// Account Registration Page
		AccountRegisterPage regpage = new AccountRegisterPage(driver);
		regpage.setFirstName(randomNames().toLowerCase());
		regpage.setLastName(randomNames().toLowerCase());
		regpage.setEmail(randomEmail());
		
		String password = randomPassword();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setTelephone(randomNumber());
		regpage.setSubscription();
		regpage.clickcheckPolicy();
		regpage.clickContinue();
		
        String confmsg = regpage.checkConfirmation();
		
		Assert.assertEquals(confmsg,"Your Account Has Been Created!"); // validation
		
		// myAccount page
		MyAccountPage mc = new MyAccountPage(driver);
		mc.clickLogout();
		
		
		System.out.println("Login to application...............");
		hp.clickMyAccount();
		hp.clickLogin();

		LoginPage lp = new LoginPage(driver);
		lp.setEmailAddress(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		
		lp.clickLogin();
		
		System.out.print("Going to my Account Page: "+mc.isMyAccountPageExist());
		
		Assert.assertEquals(mc.isMyAccountPageExist(),true); // validation;
		
		System.out.print("Searching and add the product ..........");
		hp.enterSearchProduct(p.getProperty("searchProductName"));
		hp.clickSearch();
		
		SearchPage sp = new SearchPage(driver);
		
		if(sp.isProductExists(p.getProperty("searchProductName")))
		{
			sp.selectProduct(p.getProperty("searchProductName"));
			sp.setQuantity(p.getProperty("quantity"));
			sp.clickAddToCart();
		}
			
		
		System.out.print("Added Product or not: "+sp.checkConfMsg());
		Assert.assertEquals(sp.checkConfMsg(), true);		 // validation
		
		System.out.print("Shopping cart...........");
		
		ShoppingCartPage shoppage = new ShoppingCartPage(driver);
		shoppage.ClickItemsToNavigateCart();
		shoppage.ClickOnViewCart();
		
		String totalprice = shoppage.getTotalPrice();
		Assert.assertEquals(totalprice,"$1,204.00"); // validation
		
		shoppage.clickcheckout();
		
		// checkout product
		
		CheckoutPage ch = new CheckoutPage(driver);
		
		ch.setFirstName(randomNames().toUpperCase());
		Thread.sleep(1000);
		ch.setLastName(randomNames().toUpperCase());
		Thread.sleep(1000);
		ch.setCompany("techno");
		ch.setAddress1("address1");
		Thread.sleep(1000);
		ch.setAddress2("address2");
		Thread.sleep(1000);
		ch.setCity("Delhi");
		Thread.sleep(1000);
		ch.setPostalCode("500070");
		Thread.sleep(1000);
		ch.SetCountry("India");
		Thread.sleep(1000);
		ch.SetState("Delhi");
		Thread.sleep(1000);
		ch.clickOnContinueAfterBillingAddress();
		Thread.sleep(1000);
		ch.clickOnContinueAfterDeliveryAddress();
		Thread.sleep(1000);
		ch.setDeliveryMethodComment("testing...");
		Thread.sleep(1000);
		ch.clickOnContinueAfterDeliveryMethod();
		Thread.sleep(1000);
		ch.selectTermsAndConditions();
		Thread.sleep(1000);
		ch.clickOnContinueAfterPaymentMethod();
		Thread.sleep(2000);
		
		String total_price_inOrderPage=ch.getTotalPriceBeforeConfOrder();
		System.out.println("total price in confirmed order page:"+total_price_inOrderPage);
		myassert.assertEquals(total_price_inOrderPage, "$602.00"); //validation
		
		//Below code works only if you configure SMTP for emails 
		/*ch.clickOnConfirmOrder();
		Thread.sleep(3000);
			
		boolean orderconf=ch.isOrderPlaced();
		System.out.println("Is Order Placed? "+orderconf);
		myassert.assertEquals(ch.isOrderPlaced(),true);*/
			
		myassert.assertAll(); //conclusion

		
		
		
		

	}
	
	
}
