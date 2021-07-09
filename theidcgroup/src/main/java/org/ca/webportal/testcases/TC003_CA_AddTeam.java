package org.ca.webportal.testcases;

import java.awt.AWTException;

import org.ca.webportal.base.ProjectSpecificMethods;
import org.ca.webportal.pages.CALaunchPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC003_CA_AddTeam extends ProjectSpecificMethods
{

	@BeforeTest
	public void SetData() {
		excelfilename="Login";
	}
	
	@Test(dataProvider="exceldata")
	public void addActivity(
			String url,
			String username,
			String password,
			String ActivityName,
			String OffenseDefenseIndicator,
			String ActivityPositions,
			String TeamName,
			String TeamLogoFilepath,
			String Venue) throws InterruptedException, AWTException 
	{
		new CALaunchPage().
		passtheURL(url).
		clickSignIN().
		enterUserName(username).
		enterPassword(password).
		clickLogin().
		waitforCAHomepagetoload().
		clickAddActivity().		
		addNewActivity().
		enterActivityName(ActivityName).
		setOffenseDefenseIndicator(OffenseDefenseIndicator).
		enterActivityPositions(ActivityPositions).
		submitAddActivity().
		clickAddTeamforNewActivity().
		addNewTeam(TeamName).
		uploadAnImageForTeamLogo(TeamLogoFilepath).
		addaVenue(Venue).
		selectSportsInDropdown(ActivityName).
		submitAddTeam();
				
	}	
}
