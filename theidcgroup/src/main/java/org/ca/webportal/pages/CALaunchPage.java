package org.ca.webportal.pages;

import java.util.concurrent.TimeUnit;

import org.ca.webportal.base.ProjectSpecificMethods;
import org.openqa.selenium.By;

public class CALaunchPage extends ProjectSpecificMethods {
	
	
	public CALaunchPage passtheURL(String url) {
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return this;
	}
	
	
	public CALoginPage clickSignIN() throws InterruptedException 
	{
		driver.findElement(By.xpath("//span[text()='Signin']")).click();
		Thread.sleep(1000);
		
		return new CALoginPage();
		
	}

}
