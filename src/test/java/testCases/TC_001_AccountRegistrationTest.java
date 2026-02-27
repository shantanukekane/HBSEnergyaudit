package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups = {"Regression","Master"})
	public void testAccountRegistration()
	{
		logger.info("****** Starting of TC_001 Account Registration Test ******");
	    
		try
		{
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("****** click on MyAccount Link ******");
		hp.clickRegister();
		logger.info("****** click on Register Button ******");

		
		AccountRegisterPage regpage = new AccountRegisterPage(driver);
		
		regpage.setFirstName(randomNames().toLowerCase());
		logger.info("****** Entering Name first name  ******");

		regpage.setLastName(randomNames().toLowerCase());
		logger.info("****** Entering Name Last name  ******");

		regpage.setEmail(randomEmail());
		logger.info("****** Entering Name Email id name  ******");

		regpage.setTelephone(randomNumber());
		logger.info("****** Entering Name Telephone Number  ******");

		// create a variable for passoword
		String password = randomPassword();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		logger.info("****** Passing Valid Password into password and confirm password i/p box ******");

		
		regpage.setSubscription();
		regpage.clickcheckPolicy();
		regpage.clickContinue();
	
		logger.info("****** click on Continue button  ******");

		logger.info("**** validating Expected message *****");
		String confmsg = regpage.checkConfirmation();
		
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{

			logger.error("Test Failed");
			logger.debug("Debug Logs");
			Assert.assertTrue(false);

		}
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!! "); // actual message
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		/*
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
		*/
		
		/*
	
		
		*/
		
		logger.info("****** Ending of TC_001 Account Registration Test *******");
		
	}
	
	
	   
    
}
