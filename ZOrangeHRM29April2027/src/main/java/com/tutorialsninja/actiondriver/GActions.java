package com.tutorialsninja.actiondriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GActions {

    public static WebDriver driver;
    public static String parentWindow;
    public static void setDriver(WebDriver dr) {
        driver = dr;
    }


    /* =====================================================
       BASIC ELEMENT METHODS
    ===================================================== */

    /* Click an element */
    public static void click(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /* Enter text into textbox */
    public static void type(WebDriver driver, WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    /* Check if element is visible */
    public static boolean isDisplayed(WebDriver driver, WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /* Check if element is selected */
    public static boolean isSelected(WebDriver driver, WebElement element) {
        return element.isSelected();
    }

    /* Check if element is enabled */
    public static boolean isEnabled(WebDriver driver, WebElement element) {
        return element.isEnabled();
    }

    /* Find element present/displayed */
    public static boolean findElement(WebDriver driver, WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /* =====================================================
       SCROLL METHODS
    ===================================================== */

    /* Scroll page until element visible */
    public static void scrollByVisibilityOfElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /* =====================================================
       DROPDOWN METHODS
    ===================================================== */

    /* Select dropdown using sendKeys */
    public static void selectBySendkeys(WebDriver driver, WebElement element, String value) {
        element.sendKeys(value);
    }

    /* Select dropdown by index */
    public static void selectByIndex(WebDriver driver, WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    /* Select dropdown by value */
    public static void selectByValue(WebDriver driver, WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    /* Select dropdown by visible text */
    public static void selectByVisibleText(WebDriver driver, WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    /* =====================================================
       JAVASCRIPT METHODS
    ===================================================== */

    /* Mouse hover using JavaScript */
    public static void mouseHoverByJavaScript(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
            "var evObj = document.createEvent('MouseEvents');" +
            "evObj.initMouseEvent('mouseover',true,false,window,0,0,0,0,0,false,false,false,false,0,null);" +
            "arguments[0].dispatchEvent(evObj);", element);
    }

    /* Click using JavaScript */
    public static void JSClick(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    /* =====================================================
       FRAME METHODS
    ===================================================== */

    /* Switch to frame by index */
    public static void switchToFrameByIndex(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    /* Switch to frame by id */
    public static void switchToFrameById(WebDriver driver, String id) {
        driver.switchTo().frame(id);
    }

    /* Switch to frame by name */
    public static void switchToFrameByName(WebDriver driver, String name) {
        driver.switchTo().frame(name);
    }

    /* Switch back to default frame */
    public static void switchToDefaultFrame(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    /* =====================================================
       MOUSE ACTION METHODS
    ===================================================== */

    /* Hover mouse over element */
    public static void mouseOverElement(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }

    /* Scroll and move to element */
    public static void moveToElement(WebDriver driver, WebElement element) {
        scrollByVisibilityOfElement(driver, element);
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }

    /* Perform mouseover */
    public static void mouseover(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }

    /* Drag element by x and y */
    public static void draggable(WebDriver driver, WebElement element, int x, int y) {
        Actions act = new Actions(driver);
        act.dragAndDropBy(element, x, y).perform();
    }

    /* Drag and drop source to target */
    public static void draganddrop(WebDriver driver, WebElement source, WebElement target) {
        Actions act = new Actions(driver);
        act.dragAndDrop(source, target).perform();
    }

    /* Move slider */
    public static void slider(WebDriver driver, WebElement element, int x) {
        Actions act = new Actions(driver);
        act.dragAndDropBy(element, x, 0).perform();
    }

    /* Right click element */
    public static void rightclick(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.contextClick(element).perform();
    }

    /* =====================================================
       WINDOW METHODS
    ===================================================== */

    /* Switch window by title */
    public static void switchWindowByTitle(WebDriver driver, String title) {
        for (String win : driver.getWindowHandles()) {
            driver.switchTo().window(win);
            if (driver.getTitle().equals(title)) {
                break;
            }
        }
    }

    /* Switch to new window */
    public static void switchToNewWindow(WebDriver driver) {
        String current = driver.getWindowHandle();

        for (String win : driver.getWindowHandles()) {
            if (!win.equals(current)) {
                driver.switchTo().window(win);
                break;
            }
        }
    }

    /* Switch to old window */
    public static void switchToOldWindow(WebDriver driver, String oldWindow) {
        driver.switchTo().window(oldWindow);
    }

    /* =====================================================
       TABLE METHODS
    ===================================================== */

    /* Get column count */
    public static int getColumncount(WebDriver driver, By locator) {
        return driver.findElements(locator).size();
    }

    /* Get row count */
    public static int getRowCount(WebDriver driver, By locator) {
        return driver.findElements(locator).size();
    }

    /* =====================================================
       ALERT METHODS
    ===================================================== */

    /* Accept alert */
    public static void Alert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    /* Check alert exists */
    public static boolean isAlertPresent(WebDriver driver) {
        try {
            driver.switchTo().alert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /* =====================================================
       BROWSER METHODS
    ===================================================== */

    /* Open URL */
    public static void launchUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    /* Get page title */
    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    /* Get current URL */
    public static String getCurrentURL(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    /* =====================================================
       WAIT METHODS
    ===================================================== */

    /* Implicit wait */
    public static void implicitWait(WebDriver driver, int sec) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }

    /* Explicit wait for visible element */
    public static WebElement explicitWait(WebDriver driver, By locator, int sec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /* Page load timeout */
    public static void pageLoadTimeOut(WebDriver driver, int sec) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
    }

    /* =====================================================
       UTILITY METHODS
    ===================================================== */

    /* Capture screenshot */
    public static void screenShot(WebDriver driver, String path) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(path));
    }

    /* Get current date and time */
    public static String getCurrentTime() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    }

}