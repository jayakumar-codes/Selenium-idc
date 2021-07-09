package org.ca.webportal.pages;

import java.util.List;

import org.ca.webportal.base.ProjectSpecificMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CAAddTeamPage extends ProjectSpecificMethods
{
	public CAAddTeamPage addNewTeam(String TeamName) 
	{
		WebElement teamname = driver.findElement(By.id("team_name"));
		teamname.sendKeys(TeamName);
		String tname = driver.findElement(By.id("team_name")).getAttribute("Value");
		System.out.println(tname);
		return this;
	}
	
	public CAAddTeamPage uploadAnImageForTeamLogo(String TeamLogoFilepath) 
	{
		WebElement logoupload = driver.findElementByXPath("//*[@id=\"contained-button-file\"]");
		logoupload.sendKeys(TeamLogoFilepath);
		return this;
	}
	
	public CAAddTeamPage addaVenue(String Venue) 
	{
		driver.findElement(By.id("stadium_name")).sendKeys(Venue);
		return this;
	}
	
	public CAAddTeamPage selectSportsInDropdown(String ActivityName) 
	{
		driver.findElement(By.id("mui-component-select-sports_associated")).click();
		List<WebElement> sportselectioninteamddlist = driver.findElementsByXPath("//*[@id='menu-sports_associated']/div/ul/li");
		int sporstlistofvalueindd = sportselectioninteamddlist.size();
		
		for(int j=0;j<sporstlistofvalueindd;j++)
		{
			if(sportselectioninteamddlist.get(j).getText().equals(ActivityName))
			{
				sportselectioninteamddlist.get(j).click();
				break;
			}
		}
		return this;
	}
	
	public CATeamDashboard submitAddTeam() 
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		wait = new WebDriverWait (driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/a[text()='Add Player']")));
		return new CATeamDashboard();
	} 
}
