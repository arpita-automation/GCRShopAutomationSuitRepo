package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AccountRecoveryPage;
import pages.EnterPasswordPage;
import pages.EnterUsernamePage;
import pages.GmailInboxPage;

public class EnterPasswordTest extends TestBase
{

	EnterUsernamePage enterUserNamePage;
	EnterPasswordPage enterPasswordPage;
	GmailInboxPage gmailInboxPage;
	AccountRecoveryPage accountRecoveryPage;
	
	public EnterPasswordTest() {
		super();//call super class constructor to initialise TestBase class for properties
	}
	
 @BeforeMethod
 public void setup() throws InterruptedException
 {
	 initialize();//chrome url launched
	 enterUserNamePage = new EnterUsernamePage();
	 enterPasswordPage = enterUserNamePage.enterUName(prop.getProperty("username"));
	 Thread.sleep(2000);
 }
 
@Test(priority = 1)
public void verifyPasswordPageTitleTest()
{
	String title = enterPasswordPage.verifyPasswordPageTitle();
	Assert.assertEquals(title, "Gmail", "Password page title not matched");
}

@Test(priority = 2)
public void verifyUserNameTest() throws InterruptedException
{
	Thread.sleep(2000);
	boolean flag = enterPasswordPage.verifyUserName();
	Assert.assertTrue(flag);
}
 
@Test(priority = 4)
public void loginTest()
{
	gmailInboxPage = enterPasswordPage.enterPassword(prop.getProperty("password"));
}
 
@Test(priority = 3)
public void clickForgotPwdLinkTest()
{
	accountRecoveryPage = enterPasswordPage.clickForgotPwdLink();
}

 @AfterMethod
 public void tearDown()
 {
	 driver.quit();
 }
	

	
}
