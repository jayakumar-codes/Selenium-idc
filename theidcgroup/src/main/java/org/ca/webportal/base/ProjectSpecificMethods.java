package org.ca.webportal.base;

import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.ca.webportal.utils.ExcelDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;


public class ProjectSpecificMethods {
	
	public static ChromeDriver driver;
	public String excelfilename;
	public WebDriverWait wait;
	
	
	@BeforeMethod
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@DataProvider(name ="exceldata")
	public String[][] Senddata() throws IOException {
			ExcelDataProvider data=new ExcelDataProvider();
			String[][] exceldata = data.readExceldata(excelfilename);
			return exceldata;
	}
	
}
