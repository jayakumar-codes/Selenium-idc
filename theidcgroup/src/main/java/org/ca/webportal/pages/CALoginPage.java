package org.ca.webportal.pages;

import org.ca.webportal.base.ProjectSpecificMethods;
import org.openqa.selenium.By;



public class CALoginPage extends ProjectSpecificMethods 
{
	public CALoginPage enterUserName(String username) throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys(username);
		return this;
	}
	
	
	public CALoginPage enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
		return this;
	}
	
	public CAHomePage clickLogin()
	{
		driver.findElement(By.tagName("button")).click();
		return new CAHomePage();
	}
	

}
