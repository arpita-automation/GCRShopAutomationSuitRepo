package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class EnterPasswordPage extends TestBase
{
	
	//PageFactory/OR
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordTxtBox;
	
	@FindBy(xpath = "//span[contains(text(), 'Next')]")
	WebElement nextBtn;
	
	@FindBy(xpath = "//span[contains(text(), 'Forgot password?')]")
	WebElement forgotPwdLink;
	
	@FindBy(xpath = "//div[@class='jXeDnc']//span")
	WebElement usernameLabel;
	
	@FindBy(id="profileIdentifier")
	WebElement userIdentifier;
	
	
	//initialize page factory objects with current class constructor
	public EnterPasswordPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String verifyPasswordPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyUserName()
	{
		return usernameLabel.isDisplayed();
	}
	
	public GmailInboxPage enterPassword(String pwd)
	{
		passwordTxtBox.sendKeys(pwd);
		nextBtn.click();
		return new GmailInboxPage();
	}

	public AccountRecoveryPage clickForgotPwdLink()
	{
		forgotPwdLink.click();
		return new AccountRecoveryPage();
	}
	
}
