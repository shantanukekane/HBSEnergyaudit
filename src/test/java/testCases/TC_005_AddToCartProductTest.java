package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_005_AddToCartProductTest extends BaseClass {

	@Test
	public void Verify_AddToCartProduct()
	{
		logger.info("****** Starting of TC_005_AddToCartProductTest ******");
		
		try
		{
		// HomePage
		HomePage hp = new HomePage(driver);
		hp.enterSearchProduct("iPhone");
		hp.clickSearch();
		
		
		//Search Page
		SearchPage sp = new SearchPage(driver);
		
		if(sp.isProductExists("iPhone"))
		{
			sp.selectProduct("iPhone");
			sp.setQuantity("2");
			sp.clickAddToCart();
		}
		
		Assert.assertEquals(sp.checkConfMsg(), true);
		
		}
		catch(Exception e)
		{
			logger.error("Error logs");
			logger.debug("debug logs");
			Assert.fail();
		}
		
		logger.info("****** Finishing of TC_005_AddToCartProductTest ******");

	}
	
	
	
	
}
