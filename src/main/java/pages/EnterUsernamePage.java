package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class EnterUsernamePage extends TestBase
{
	//Page Factory ==> OR
	@FindBy(id="identifierId")
	WebElement username;
	
	@FindBy(xpath = "//span[@class='CwaK9']")
	WebElement nextBtn;
	
	@FindBy(xpath = "//div[@class='OIPlvf']//span/span")
	WebElement createAccountLink;
	
	@FindBy(id="logo")
	WebElement googleLogo;
	
	//initialize page factory objects with current class constructor
	public EnterUsernamePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle(); 
	}
	
	public boolean validateGoogleLogo()
	{
		return googleLogo.isDisplayed();
	}
	
	public EnterPasswordPage enterUName(String uname)
	{
		username.sendKeys(uname);
		nextBtn.click();
		return new EnterPasswordPage();
	}
	
	
}
