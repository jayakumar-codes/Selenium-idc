package org.ca.webportal.pages;

import org.ca.webportal.base.ProjectSpecificMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CAHomePage extends ProjectSpecificMethods{
		
		public CALaunchPage clickLogout()
	{
		driver.findElementByXPath("//div[@id=\"root\"]/div[1]//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeLarge']").click();
		return new CALaunchPage();
	}
	
	public CAHomePage waitforCAHomepagetoload() {
		wait = new WebDriverWait (driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add Activity']")));
		return this;
	}
	
	public CAAddActivityPage clickAddActivity() {
		driver.findElement(By.xpath("//span[text()='Add Activity']")).click();
		return new CAAddActivityPage();
	}

	public CAAddTeamPage clickAddTeamforNewActivity() 
	{
		wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Add a Team']")));
		driver.findElement(By.xpath("//span[text()='Add a Team']")).click();
		return new CAAddTeamPage();
	}

	public CATeamDashboard addNewPlayerforExisitingTeam(String TeamName) throws InterruptedException
	{
		String dashboardteamstartxpath="//h1[text()='";
		String dashboardteamendxpath="']";
		driver.findElement(By.xpath(dashboardteamstartxpath+TeamName+dashboardteamendxpath)).click();
		Thread.sleep(3000);
		return new CATeamDashboard();
	}

	
	
}
