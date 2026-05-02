package com.tutorialsninja.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.actiondriver.GActions;
import com.tutorialsninja.base.BaseClass;

public class HomePageNew extends BaseClass{
	
	
	  // Username Textbox
	@FindBy(name = "username")
	WebElement usernameField;
	
	//Password Textbox
	@FindBy(name = "password")
	WebElement passwordField;
	
	//Login Button
	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	public HomePageNew() {
		PageFactory.initElements(getDriver(), this);

	}
	
	
	public HomePageNew enterUsername(String username) {

		//GActions.type(getDriver(), usernameField, username);
		return new HomePageNew();
	}
	
	
	public HomePageNew enterPassword(String password) {

		GActions.type(getDriver(), usernameField, password);
		return new HomePageNew();
	}
	
	
	
	
	public DashboardPageNew clickLogin() {

		GActions.click(getDriver(), loginButton);
		return new DashboardPageNew();
	}
	
	
	
	
	

	
	
}
	