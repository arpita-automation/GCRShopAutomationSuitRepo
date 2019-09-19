package util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.reporters.Files;

import base.TestBaseGCR;

public class TestUtil extends TestBaseGCR
{
	public static long PAGE_LOAD_TIMEOUT = 20;
	
	/*public static String SHEET_PATH= "E:\\Arpita\\userData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	public static Object[][] getTestData(String sheetName)
	{
		FileInputStream file = null;
		
		file = new FileInputStream(SHEET_PATH);
		//book = WorkbookFact
		
	}*/
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		//Files.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	
	
	
}
