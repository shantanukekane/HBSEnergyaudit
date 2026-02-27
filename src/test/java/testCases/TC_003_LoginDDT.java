package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*
Data is valid - login success - Test Pass - logout
                login failed  - Test fail 

Data is invalid - login success - Test fail - logout
                  login failed - Test fail
 */



public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,groups = "DataDriven") // here pass the data provider class if data provider is outside of class
	public void verify_LoginDDT(String email,String pwd,String exp) // pas excel parameters
	{
		
		logger.info("***** Starting of TC_003_LoginDDT ******");
		
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
		lp.setEmailAddress(email);
		logger.info(" Enter username/Email into email input box  ");

		lp.setPassword(pwd);
		logger.info("Enter Password into password input box ");
		lp.clickLogin();
		logger.info("Click on Login Button");
		
		//MyAccountPage
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetpage = mp.isMyAccountPageExist();
		
		/*
		Data is valid - login success - Test Pass - logout
		                login failed  - Test fail 
		
		Data is invalid - login success - Test fail - logout
		                  login failed - Test fail
		
		 */
		
		if(exp.equalsIgnoreCase("valid"))
		{

			if(targetpage==true)
		    {
				mp.clickLogout();
			    Assert.assertTrue(true);
			    
		    }
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(targetpage==true)
			{
				mp.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("***** Finished TC_003_LoginDDT *****");
	}
	
	
}
