package org.ca.webportal.pages;

import org.ca.webportal.base.ProjectSpecificMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CATeamDashboard extends ProjectSpecificMethods 
{
	public CAAddPlayerPage clickOnAddPlayer() throws InterruptedException
	{
		wait = new WebDriverWait (driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/a[text()='Add Player']")));
		driver.findElementByXPath("//button/a[text()='Add Player']").click();
		return new CAAddPlayerPage();
	}

	public CATeamDashboard clickOnAddSchedule()
	{
		driver.findElementByXPath("//button/a[text()='Add Schedule']").click();
		return null;
	}
	
	public CATeamDashboard clickOnAddGaiteKeeper()
	{
		driver.findElementByXPath("//button/a[text()='Add GaiteKeeper']").click();
		return null;
	}
	
	public CATeamDashboard clickOnAddStaff()
	{
		driver.findElementByXPath("//button/a[text()='Add Staff']").click();
		return null;
	}
	
}
