package com.tutorialsninja.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.tutorialsninja.base.BaseClass;

public class ScreenshotUtil extends BaseClass{
	public static String captureScreenshot(String testName) {

    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

    String screenshotPath = System.getProperty("user.dir")
            + "/screenshots/" + testName + "_" + timestamp + ".png";

    File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

    File destFile = new File(screenshotPath);

    try {
        FileUtils.copyFile(srcFile, destFile);
    } catch (IOException e) {
        e.printStackTrace();
    }

    return screenshotPath;
}
	
	
	

}
