package com.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tutorialsninja.utility.ScreenshotUtil;

public class TestListener implements ITestListener{


    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getName();

        String screenshotPath = ScreenshotUtil.captureScreenshot(testName);

        System.out.println("Test Failed: " + testName);
        System.out.println("Screenshot saved at: " + screenshotPath);
    }

}
