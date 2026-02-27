package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{

	@Test(groups = {"Sanity","Master"})
	public void verify_Login()
	{
		logger.info("***** Starting of TC_002_LoginTest ******");
		try
		{
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info(" click on my Account link ");
		hp.clickLogin();
		logger.info(" click on Login link to navigate to Login Page ");

        //LoginPage		
		LoginPage lp = new LoginPage(driver);
		lp.setEmailAddress(p.getProperty("email"));
		logger.info(" Enter username/Email into email input box  ");

		lp.setPassword(p.getProperty("password"));
		logger.info("Enter Password into password input box ");
		lp.clickLogin();
		logger.info("Click on Login Button");
		
		//MyAccountPage
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetpage = mp.isMyAccountPageExist();
		if(targetpage==true)
        {
		    Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
		
		 //Assert.assertEquals(targetpage, true);
		}
		catch(Exception e) 
		{
			logger.error("Test Failed");
			logger.debug("debug logs");
			Assert.fail();
			
		}
		logger.info("***** Finished of TC_002_LoginTest ******");

	}
	
}
