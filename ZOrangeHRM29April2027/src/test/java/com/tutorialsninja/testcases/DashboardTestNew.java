package com.tutorialsninja.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.base.BaseClass;
import com.tutorialsninja.pageobjects.DashboardPageNew;

public class DashboardTestNew extends BaseClass{
	
	DashboardPageNew dp;

	@BeforeMethod
	public void setUp() {

		launchApp();
		dp = new DashboardPageNew();
	};

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	};

	@Test
	public void AcceptDashPopup() {		
		dp.clickOkUsingKeyboard();	
		dp.searchLabel();
	}
	
	
}
