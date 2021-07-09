package org.ca.webportal.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.ca.webportal.base.ProjectSpecificMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CAAddActivityPage extends ProjectSpecificMethods {
	
	public CAAddActivityPage addNewActivity() throws InterruptedException 
	{
		Thread.sleep(2000);
		WebElement dd_selectactivity_arrow = driver.findElement(By.id("mui-component-select-sports_select"));
		dd_selectactivity_arrow.click();
		WebElement dd_selectactivity_value = driver.findElement(By.xpath("//li[text()='Add New Activity']"));
		dd_selectactivity_value.click();
		return this;
	}
	
	public CAAddActivityPage enterActivityName(String ActivityName) 
	{
		wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("sports_name")));
		WebElement activityname = driver.findElement(By.id("sports_name"));
		activityname.sendKeys(ActivityName);
		return this;
	}

	public CAAddActivityPage setOffenseDefenseIndicator(String OffenseDefenseIndicator) throws InterruptedException
	{
		if(OffenseDefenseIndicator.equalsIgnoreCase("Yes"))
		{
			System.out.println("Offense Defense Indicator has been set in Activity");
		}			
		else if(OffenseDefenseIndicator.equalsIgnoreCase("No"))
		{
			driver.findElement(By.name("ofense_Defense_Validator")).click();
		}
					
		return this;
	}
	public CAAddActivityPage enterActivityPositions (String ActivityPositions) throws InterruptedException, AWTException
	{
		WebElement sportsrole = driver.findElement(By.id("sports_roles"));
		
		String[] position=ActivityPositions.split("[,]", 0);
		for(String pos:position)
		{  
			//System.out.println(pos);
			sportsrole.sendKeys(pos);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
		}  
		Thread.sleep(2000);
		return this;
		
	}
		
	public CAHomePage submitAddActivity() throws InterruptedException 
	{
		driver.findElement(By.xpath("//span[text()='Add Activity']")).click();
		Thread.sleep(3000);
		return new CAHomePage();
	}	
		
	}


	


