package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBaseGCR;

public class GCRCreateAccountPAge extends TestBaseGCR
{

	@FindBy(name="firstname")
	WebElement firstName;
	
	@FindBy(name="lastname")
	WebElement lastName;
	
	@FindBy(id="dob")
	WebElement dob;
	
	@FindBy(name="email_address")
	WebElement email;

	@FindBy(name="street_address")
	WebElement street;
	
	
	public GCRCreateAccountPAge()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectGender(String option)
	{
		boolean flag= false;
		List <WebElement> gender = driver.findElements(By.name("gender"));
		if(gender.size() != 0)
		{
			for(WebElement g : gender)
			{
				if(g.getAttribute("value").equalsIgnoreCase(option))
				{
					if(!g.isSelected())
					{
					g.click();
					flag=true;
					break;
					}
				}
			}
			if(flag==true)
				System.out.println("Gender Sected: " + option);
		}
		else
			System.out.println("Unable to select gender");
	}
	
	public void createUserAccount(String fname, String lname, String emailAdd, String streetadd)
	{
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		email.sendKeys(emailAdd);
		street.sendKeys(streetadd);
	}
	
	
	/*Select date with JS Executor
	public static void selectDateByJS(String date)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value'," +date+"');", dob);
	}
	
	/*Select date with selenium
	 * public void selectDateOfBirth(String date)
	{
		String[] dateArr = date.split("-");
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		
		Select select = new Select(driver.findElement(By.className("ui-datepicker-month")));
		select.selectByVisibleText(month);
			
		Select select1 = new Select(driver.findElement(By.className("ui-datepicker-year")));
		select1.selectByVisibleText(year);
		
		/html/body/div[6]/table/tbody/tr[1]/td[1]/a
		/html/body/div[6]/table/tbody/tr[1]/td[2]/a
		/html/body/div[6]/table/tbody/tr[2]/td[3]/a
		
		
		String beforeXpath = "/html/body/div[6]/table/tbody/tr[";
		String afterXpath = "]/td[";
		String dateval;
		boolean flag = false;
		for(int row=2; row<=7; row++)
		{
			for(int col=1; col<7; col++)
			{
				try
				{
				dateval = driver.findElement(By.xpath(beforeXpath +row + afterXpath + col +"]/a")).getText();
				}
				catch(NoSuchElementException e)
				{
					System.out.println("Please enter correct date value");
					flag=false;
					break;
				}
				if(date.equals(day))
				{
					driver.findElement(By.xpath(beforeXpath +row + afterXpath + col +"]/a")).click();
					flag = true;
					break;
				}
			}
			if(flag == true)
				break;
		}
		
	}*/
	
}
