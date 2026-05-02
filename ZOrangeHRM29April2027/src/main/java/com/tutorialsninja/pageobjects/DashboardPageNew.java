package com.tutorialsninja.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.actiondriver.GActions;
import com.tutorialsninja.base.BaseClass;

public class DashboardPageNew extends BaseClass {
	
	@FindBy(xpath=("//input[@placeholder='Search']"))
	WebElement Searchbox;
	
	
	public DashboardPageNew() {
		PageFactory.initElements(getDriver(), this);

	}
	
	// Method to handle Chrome popup using keyboard
    public void clickOkUsingKeyboard() {
    	getDriver().switchTo().activeElement().sendKeys(Keys.ENTER);
    }
    
    public void searchLabel() {
    	
    	GActions.type(getDriver(), Searchbox, "Admin");
    	
    	
    }
    
	
    
	

}
