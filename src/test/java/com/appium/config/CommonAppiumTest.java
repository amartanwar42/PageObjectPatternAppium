package com.appium.config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class CommonAppiumTest {
    public AppiumDriver driver;
    Logger logger = Logger.getLogger(CommonAppiumTest.class);

    public CommonAppiumTest(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public WebElement waitForElementToBeClickable(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(id));
        return id;
    }

    public WebElement waitForElementToBeClickable(WebElement id, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(id));
        return id;
    }

    public boolean isAndroid(){
        return driver.getPlatformName().equalsIgnoreCase("Android");}

    public void waitForElementToDisAppear(String id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
    }

    public void handleAlertIfPresent(){
        try {
            WebDriverWait alertWait= new WebDriverWait(driver,20);
            alertWait.until(ExpectedConditions.alertIsPresent()).dismiss();
        }catch (Exception e){
            System.out.println("No alert found");
        }
    }
    public void waitForElementsToAppear(List<WebElement> id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElements(id));
    }

    public WebElement waitForElementToBeVisible(WebElement id) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElements(id));
        return id;
    }
    public WebElement waitForElementToBeVisible(WebElement id,int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElements(id));
        return id;
    }

    public WebElement waitForElement(WebElement arg) {
        waitForElementToBeClickable(arg);
        WebElement el = arg;
        return el;
    }

    public void swipeRightUntilLogOutScreen() {
        do {
            swipeRight();
        } while (!isElementPresent(By.id("org.wordpress.android:id/me_login_logout_text_view")));
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public void swipeLeftUntilTextExists(String expected) {
        do {
            swipeLeft();
        } while (!driver.getPageSource().contains(expected));
    }

    public void swipeRight() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.9);
        int endx = (int) (size.width * 0.20);
        int starty = size.height / 2;
        new TouchAction(driver).press(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(endx,starty)).release().perform();
    }

    public void swipeLeft() {
        Dimension size = driver.manage().window().getSize();
        int startx = (int) (size.width * 0.8);
        int endx = (int) (size.width * 0.20);
        int starty = size.height / 2;
        new TouchAction(driver).press(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(endx,starty)).release();
    }

    public void scrollUp() {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        swipe(width / 2, height / 3, width / 2, height * 2 / 3, 1000);
    }

    public void swipe(int startX, int startY, int endX, int endY, int durationInMilliSeconds) {
        new TouchAction(driver)
                .press(point(startX, startY))
                .waitAction(waitOptions(Duration.ofMillis(durationInMilliSeconds)))
                .moveTo(point(endX, endY)).release().perform();
        Reporter.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Swipe done",true);
    }

    /**
     * method to set the context to required view.
     *
     * @param context view to be set
     */
    public void setContext(String context) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        driver.context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1

        logger.info("Current context" + driver.getContext());
    }

    public void hideKeyboard() {
        try {
            driver.hideKeyboard();
        } catch (WebDriverException e) {
            // ignore exception
        }
    }
    public void clickBackButton() {
        driver.navigate().back(); //Closes keyboard
        //driver.navigate().back(); //Comes out of edit mode
    }

    public void scrollDownTo(By byOfElementToBeFound) {
        hideKeyboard();
        for (int i = 0; i < 20; i++) {
            if (driver.findElements(byOfElementToBeFound).size() > 0)

                return;
            scrollDown();
        }
        Assert.fail("Did not find : " + byOfElementToBeFound.toString());
    }

    public void scrollDown() {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        Reporter.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Swipe started",true);
        swipe(width / 2, height * 2 / 3, width / 2, height / 3, 1000);

    }


}
