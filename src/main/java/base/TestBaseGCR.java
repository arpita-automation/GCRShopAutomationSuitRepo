package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import util.TestUtil;
import util.WebEventListener;

public class TestBaseGCR 
{
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBaseGCR() 	{
		prop = new Properties();
		try 
		{
			FileInputStream is = new FileInputStream("E:\\JavaDemo\\GmailTest2\\src\\main\\java\\config\\configGCR.properties");
			prop.load(is);
		} 
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void initialise()
	{
		String browserName = prop.getProperty("browser");
		

		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:/Arpita/Selenium/ChromeV76/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "E:/Arpita/Selenium/geckoDriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
