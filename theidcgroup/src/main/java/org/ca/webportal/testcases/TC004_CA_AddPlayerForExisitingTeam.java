package org.ca.webportal.testcases;

import java.awt.AWTException;

import org.ca.webportal.base.ProjectSpecificMethods;
import org.ca.webportal.pages.CALaunchPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC004_CA_AddPlayerForExisitingTeam extends ProjectSpecificMethods
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
			String Venue,
			String PlayerName,
			String PlayerJerseyNumber,
			String PlayerInviteMail,
			String EnterCoutryIndiaOrUS,
			String PhoneNumber,
			String PlayerImageFilePath,
			String PlayerPositionOffenseORDefense,
			String PlayerRole,
			String PlayerStatusReadyOrOnRehab) throws InterruptedException, AWTException 
	{
		new CALaunchPage().
		passtheURL(url).
		clickSignIN().
		enterUserName(username).
		enterPassword(password).
		clickLogin().
		waitforCAHomepagetoload().
		addNewPlayerforExisitingTeam(TeamName).
		clickOnAddPlayer().
		enterPlayerName(PlayerName).
		enterPlayerJerseyNumber(PlayerJerseyNumber).
		enterPlayerInviteMail(PlayerInviteMail).
		selectCountryCode(EnterCoutryIndiaOrUS,PhoneNumber).
		uploadPlayerImage(PlayerImageFilePath).
		OffenseDefencePositionType(PlayerPositionOffenseORDefense).
		selectPlayerRole(PlayerRole).
		selectPlayerStatus(PlayerStatusReadyOrOnRehab).
		submitAddPlayer();
		
	}
	
}
