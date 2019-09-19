package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBaseGCR;
import pages.GCRCatalogPage;
import pages.GCRCreateAccountPAge;
import pages.GCRLoginPage;
import util.Log;

public class GCRLoginPageTest extends TestBaseGCR
{
	GCRLoginPage loginPage;
	GCRCatalogPage catalogPage;
	GCRCreateAccountPAge gCRCreateAccountPAge;
	Log log;
		
	public GCRLoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialise();
		loginPage = new GCRLoginPage();
	}
	
	@Test(priority = 1)
	public void validateLoginPageTitleTest()
	{
		log.info("Test case to validate Login Page Title");
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "GCR Shop" , "Login page title not matched");
		
	}
	
	@Test(priority = 2)
	public void loginTest()
	{
		log.info("Test case to validate Login functionality");
		catalogPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=3)
	public void clickContinueBtnTest()
	{
		gCRCreateAccountPAge = loginPage.clickContinueBtn();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
