package org.ca.webportal.testcases;

import org.ca.webportal.base.ProjectSpecificMethods;
import org.ca.webportal.pages.CALaunchPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC001_CA_LoginLogout extends ProjectSpecificMethods
{
	@BeforeTest
	public void SetData() {
		excelfilename="Login";
	}
	
	@Test(dataProvider="exceldata")
	public void loginLogout(String url,String username,String password,String ActivityName,String OffenseDefenseIndicator,String ActivityPositions) throws InterruptedException 
	{
		new CALaunchPage().
		passtheURL(url).
		clickSignIN().
		enterUserName(username).
		enterPassword(password).
		clickLogin().
		waitforCAHomepagetoload().
		clickLogout();
			
	}
	

}
