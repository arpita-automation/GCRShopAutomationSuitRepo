package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBaseGCR;

public class GCRCatalogPage extends TestBaseGCR
{

	@FindBy(xpath = "//div[@class='contentText']//span")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//a[@id='tdb1']//span[2]")
	WebElement cartbtn;
	
	@FindBy(xpath="//a[contains(text(),'Shopping Cart')]")
	WebElement shoppingCartLink;
	
	@FindBy(xpath="//span[contains(text(),'aaaaaaaa')]")
	WebElement checkOutBtn;
	
	
	public GCRCatalogPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyCatalogPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyUserLoggedIn()
	{
		return userNameLabel.isDisplayed();
	}
	
	public CartPage clickCartBtn()
	{
		cartbtn.click();
		return new CartPage();
	}
	
	public GCRLoginPage clickCheckOutBtn()
	{
		checkOutBtn.click();
		return new GCRLoginPage();
	}
	
	public CartPage clickShoppingCartLink()
	{
		shoppingCartLink.click();
		return new CartPage();
	}
	
}
