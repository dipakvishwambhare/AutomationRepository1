package com.tutorialsninja.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.tutorialsninja.actiondriver.GActions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	/*
	 * This is Base class it is the parent class , classes like Page objects and
	 * action driver extend this class
	 */

	// In this class we are reading config file and added browser initialization

	
	public static Properties prop;
	//public static WebDriver driver;
	
	//Declaring ThreadLocal Driver for parallel execution
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	
	public static WebDriver getDriver() {
		//Get Driver from threadlocalmap
		return driver.get();
	}
	
	

	@BeforeTest
	public void loadConfig() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip); // Reads all data from the file.
			System.out.println("driver: " + driver);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
		
	
	public static void launchApp() {
		WebDriverManager.chromedriver().setup();
		String browserName = prop.getProperty("browser");

		if (browserName.contains("Chrome")) {
			//driver = new ChromeDriver();
			driver.set(new ChromeDriver());
		} else if (browserName.contains("FireFox")) {
			//driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		} else if (browserName.contains("IE")) {
			//driver = new InternetExplorerDriver();
			driver.set(new InternetExplorerDriver());			

		}
		

		
		getDriver().manage().window().maximize();
		GActions.implicitWait(getDriver(), 10);
		GActions.pageLoadTimeOut(getDriver(), 30);
		getDriver().get(prop.getProperty("url"));
		
		
	}

}
