package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_004_SearchProductTest extends BaseClass{

	@Test(groups = {"Regression","Master"})
	public void verify_searchProductTest()
	{
		logger.info("**** Starting of Search product test ******");	
		
		// Home page
		try
		{
		HomePage hp = new HomePage(driver);
		
		//hp.enterSearchProduct("iPhone");
		hp.enterSearchProduct("mac");
		hp.clickSearch();
		
		SearchPage sp = new SearchPage(driver);
		
		boolean status = sp.isProductExists("MacBook");
		
		if(status == true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			logger.debug("Debug log");
			Assert.fail();
		}
		
		logger.info("***** Finishing of TC_searchProductTest ******");
	}
	
	
	
}
