package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import base.TestBaseGCR;
import pages.CartPage;
import pages.GCRCatalogPage;
import pages.GCRLoginPage;

public class GCRCatalogPageTest extends TestBaseGCR
{
	GCRLoginPage gcrLoginPage;
	GCRCatalogPage gcrCatalogPage;
	CartPage cartpage;

	public GCRCatalogPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialise();
		gcrLoginPage = new GCRLoginPage();
		gcrCatalogPage = gcrLoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void verifyCatalogPageTitleTest()
	{
		String title = gcrCatalogPage.verifyCatalogPageTitle();
		Assert.assertEquals(title, "GCR Shop", "Catalog page Title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserLoggedInTest()
	{
		Assert.assertTrue(gcrCatalogPage.verifyUserLoggedIn());
	}
	
	@Test(priority=3)
	public void clickCartBtnTest()
	{
		cartpage = gcrCatalogPage.clickCartBtn();
	}
	
	@Test(priority=4)
	public void clickShoppingCartLinkTest()
	{
		cartpage = gcrCatalogPage.clickShoppingCartLink();
	}
	
	@Test(priority=5)
	public void clickCheckOutBtnTest()
	{
		gcrLoginPage = gcrCatalogPage.clickCheckOutBtn();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
