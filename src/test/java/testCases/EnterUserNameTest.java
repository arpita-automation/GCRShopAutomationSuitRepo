package testCases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.EnterPasswordPage;
import pages.GmailInboxPage;
import pages.EnterUsernamePage;
public class EnterUserNameTest extends TestBase
{
	EnterUsernamePage enterUserNamePage;
	EnterPasswordPage enterPasswordPage;
	GmailInboxPage gmailInboxPage;
	
	public EnterUserNameTest() {
		super();//call super class constructor to initialise TestBase class for properties
	}
	
 @BeforeMethod
 public void setup()
 {
	 initialize();
	 enterUserNamePage = new EnterUsernamePage();
	 enterPasswordPage = new EnterPasswordPage();
	 
 }
 
@Test(priority = 1)
public void loginPageValidateTitle()
{
	String title = enterUserNamePage.validateLoginPageTitle();
	Assert.assertEquals(title, "Gmail");
}

@Test(priority = 2)
public void loginPageGoogleLogoTest()
{
	boolean flag = enterUserNamePage.validateGoogleLogo();
	Assert.assertTrue(flag);
}
 
@Test(priority = 3)
public void loginTest()
{
	enterPasswordPage = enterUserNamePage.enterUName(prop.getProperty("username"));
	String passwordPageTitle = enterPasswordPage.verifyPasswordPageTitle();
	System.out.println(passwordPageTitle);
	//Assert.assertEquals(passwordPAgeTitle, "Gmail", "Password page title not matched");
	//Assert.assertTrue(enterPasswordPage.verifyUserName());
	//gmailInboxPage = enterPasswordPage.enterPassword(prop.getProperty("password"));
}
 


 @AfterMethod
 public void tearDown()
 {
	 driver.quit();
 }
	

}
