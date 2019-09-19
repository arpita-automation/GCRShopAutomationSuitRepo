package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBaseGCR;
import pages.GCRCreateAccountPAge;
import pages.GCRLoginPage;

public class GCRCreateNewAccountTest extends TestBaseGCR
{
	GCRLoginPage gcrLoginPage;
	GCRCreateAccountPAge gCRCreateAccountPAge;
	
	public GCRCreateNewAccountTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialise();
		gcrLoginPage = new GCRLoginPage();
		gCRCreateAccountPAge = gcrLoginPage.clickContinueBtn();
	}
	
	@Test
	public void createUserAccountTest()
	{
		gCRCreateAccountPAge.createUserAccount("bbbbbbbb", "bbbbbbbb", "bbbbbbbb@b.com", "bbbbbbbb");
	}
	

}
