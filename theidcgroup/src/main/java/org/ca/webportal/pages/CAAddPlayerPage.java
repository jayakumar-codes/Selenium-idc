package org.ca.webportal.pages;

import org.ca.webportal.base.ProjectSpecificMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
	
	public class CAAddPlayerPage extends ProjectSpecificMethods 
	{
		
		public CAAddPlayerPage enterPlayerName(String PlayerName)
		{
			driver.findElement(By.id("player_name")).sendKeys(PlayerName);
			return this;
		}
		
		public CAAddPlayerPage enterPlayerJerseyNumber(String PlayerJerseyNumber)
		{
			driver.findElement(By.id("player_jersey_number")).sendKeys(PlayerJerseyNumber);
			return this;
		}
		
		public CAAddPlayerPage enterPlayerInviteMail(String PlayerInviteMail)
		{
			driver.findElement(By.id("player_mail")).sendKeys(PlayerInviteMail);
			return this;
		}
		
		public CAAddPlayerPage selectCountryCode(String EnterCoutryIndiaOrUS,String PhoneNumber)
		{
			WebElement phonenumber = driver.findElement(By.id("phone_number"));
			if(EnterCoutryIndiaOrUS.equalsIgnoreCase("US"))
			{
				phonenumber.click();
				phonenumber.sendKeys(PhoneNumber);
			}
			else if(EnterCoutryIndiaOrUS.equalsIgnoreCase("India"))
			{
				driver.findElement(By.xpath("//div[@class='flag us']")).click();
				driver.findElement(By.xpath("//span[text()='India']")).click();
				phonenumber.sendKeys(PhoneNumber);
			}
			return this;
		}
		
		public CAAddPlayerPage uploadPlayerImage(String PlayerImageFilePath)
		{
			WebElement playerupload = driver.findElementByXPath("//*[@id=\"contained-button-file\"]");
			playerupload.sendKeys(PlayerImageFilePath);
			return this;
		}
		
		public CAAddPlayerPage OffenseDefencePositionType(String PlayerPositionOffenseORDefense) throws InterruptedException
		{
			WebElement offensetype = driver.findElementByXPath("//span[text()='Offense']");
			WebElement Defensetype = driver.findElementByXPath("//span[text()='Defense']");
		if(offensetype.isDisplayed())
		{
			if(PlayerPositionOffenseORDefense.equalsIgnoreCase("Offense"))
				{
					offensetype.click();
				}	
				else if(PlayerPositionOffenseORDefense.equalsIgnoreCase("Defense"))
				{
					Defensetype.click();
				}	
			
		}
		
			return this;
		}
		
		public CAAddPlayerPage selectPlayerRole(String PlayerRole)
		{
			driver.findElement(By.xpath("//div/div/div/div[@id='mui-component-select-player_position']")).click();
			
			try {
				driver.findElement(By.xpath("//li[text()='"+PlayerRole+"']")).click();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Please check the Player role in the activity positions.If not available, Please add it and try again ");
			}
			
			return this;
		}
		
		public CAAddPlayerPage selectPlayerStatus(String PlayerStatusReadyOrOnRehab)
		{
			driver.findElement(By.xpath("//div/div/div/div[@id='mui-component-select-player_status']")).click();
			
			WebElement statusReady = driver.findElement(By.xpath("//li[text()='Ready']"));
			WebElement statusOnRehab = driver.findElement(By.xpath("//li[text()='On Rehab']"));
			
			if(PlayerStatusReadyOrOnRehab.equalsIgnoreCase("Ready"))
			{
				statusReady.click();
			}
			else if(PlayerStatusReadyOrOnRehab.contains("Rehab"))
			{
				statusOnRehab.click();
			}
			return this;
		}
		
		public CATeamDashboard  submitAddPlayer() throws InterruptedException
		{
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			wait = new WebDriverWait (driver, 15);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button/a[text()='Add Player']")));
			return new CATeamDashboard();
		}
		
		
	}


