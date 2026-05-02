package com.tutorialsninja.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.base.BaseClass;
import com.tutorialsninja.dataprovider.DataProviders;
import com.tutorialsninja.pageobjects.HomePageNew;
import com.tutorialsninja.utility.Log;


public class HomeTestNew extends BaseClass{
	HomePageNew hp;

	@BeforeMethod
	public void setUp() {

		launchApp();
		hp = new HomePageNew();
	};

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	};
	
	
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void ValidateLogin(String username,String password ) {
		Log.info("ValidateLogin Test Started ");
		hp.enterUsername(username);
		hp.enterPassword(password);
		hp.clickLogin();
		//Assert.assertTrue(getDriver().getCurrentUrl().contains("dashboard"));
		
		Log.info("ValidateLogin Test Ended");
		
				
	}
	

	
	
	

}
