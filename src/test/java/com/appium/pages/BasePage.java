package com.appium.pages;

import clients.driverApp.ActiveBookingClient;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import utils.TestHelper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class BasePage {
    protected AppiumDriver driver;
    private WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
    }

    public boolean isAndroid(){
        return driver.getPlatformName().equalsIgnoreCase("Android");}

    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    public WebElement waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementToBeClickable(By by, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public void waitForElementToBeClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForElementToBeRefreshed(WebElement element) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
    }

    public void waitForElementToBeRefreshed(By by) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
    }

    public WebElement waitForPresenceOfElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForPresenceOfAllElements(By by) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    protected boolean waitForTextToBePresentInElement(By by, String text) {
        try {
            return wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean waitForTextToBePresentInElement(WebElement element, String text) {
        try {
            return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean waitForTextToBeNonEmpty(final By by) {
        (new WebDriverWait(driver, 30)).until((ExpectedCondition<Boolean>) d -> d.findElement(by).getText().length() != 0);
        return false;
    }

    protected boolean waitForTextToBeNonEmpty(final WebElement webElement) {
        return waitForTextToBeNonEmpty(webElement, 30);
    }

    protected boolean waitForTextToBeNonEmpty(WebElement webElement, int timeOutInSeconds) {
        (new WebDriverWait(driver, timeOutInSeconds)).until((ExpectedCondition<Boolean>) d -> webElement.getText().length() != 0);
        return false;
    }

    protected boolean waitForTextToContain(WebElement webElement, String text, int timeOutInSeconds) {
        (new WebDriverWait(driver, timeOutInSeconds)).until((ExpectedCondition<Boolean>) d -> webElement.getText().contains(text));
        return false;
    }

    protected boolean waitForTextToContain(WebElement webElement, String text) {
        return waitForTextToContain(webElement, text, 30);
    }

    public void waitForElementToBeInvisible(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitForElementSizeNotToBe(By by, int size) {
        wait.until(ExpectedConditions.not(ExpectedConditions.numberOfElementsToBe(by, size)));
    }

    public void sendKeys(WebElement elem, String text) {
        waitForElementToBeClickable(elem);
        elem.click();
        if (text != null) {
            if (!elem.getText().isEmpty()) {
                elem.clear();
            }
            elem.sendKeys(text);
        } else {
            Assert.assertNotNull(elem.getText());
        }
        driver.getKeyboard();
        hideKeyboard();
    }

    public void hideKeyboard() {
        try {
            driver.hideKeyboard();
        } catch (WebDriverException e) {
            // ignore exception
        }
    }

    public void scrollDownToText(String text) {
        String xpathExpression = String.format("//*[@text='%s']", text);
        scrollDownTo(By.xpath(xpathExpression));
    }

    public void scrollDownTo(String text) {
        scrollDownTo(By.xpath("//*[@text=\"" + text + "\"]"));
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

    public void scrollUpTo(By byOfElementToBeFound) {
        hideKeyboard();
        for (int i = 0; i < 20; i++) {
            if (driver.findElements(byOfElementToBeFound).size() > 0)
                return;

            scrollUp();
        }
        Assert.fail("Did not find : " + byOfElementToBeFound.toString());
    }

    public void scrollDown() {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        Reporter.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Swipe started",true);
        swipe(width / 2, height * 2 / 3, width / 2, height / 3, 1000);


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

    protected void swipeFromTo(WebElement startElement, WebElement stopElement) {
        swipeFromTo(startElement, stopElement, 1000);
    }

    protected void swipeFromTo(WebElement startElement, WebElement stopElement, int durationInMilliSeconds) {
        swipe(startElement.getLocation().getX(), startElement.getLocation().getY(), stopElement.getLocation().getX(), stopElement.getLocation().getY(), durationInMilliSeconds);
    }

    protected void swipeFromLeftToRight(WebElement webElement) {
        waitForElementToBeClickable(webElement);
        int xAxisStartPoint = webElement.getLocation().getX();
        int xAxisEndPoint = xAxisStartPoint + webElement.getSize().getWidth();
        int yAxis = webElement.getLocation().getY() + webElement.getSize().getHeight() / 2;
        swipe(xAxisStartPoint, yAxis, xAxisEndPoint, yAxis, 1000);
    }

    protected void swipeFromRightToLeft(WebElement webElement) {
        swipeFromRightToLeft(webElement, 1000);
    }

    protected void swipeFromRightToLeft(WebElement webElement, int durationInMilliSeconds) {
        waitForElementToBeClickable(webElement);
        int xAxisEndPoint = webElement.getLocation().getX();
        int xAxisStartPoint = xAxisEndPoint + webElement.getSize().getWidth();
        int yAxis = webElement.getLocation().getY() + webElement.getSize().getHeight() / 2;
        swipe(xAxisStartPoint, yAxis, xAxisEndPoint, yAxis, durationInMilliSeconds);
    }

    public void relaunchApp(int seconds) {
        try {
            driver.runAppInBackground(Duration.ofSeconds(seconds));
        } catch (Exception ignored) {

        }
    }

    public boolean verifyActivity(String activityName) {
        String currentActivity = ((AndroidDriver) driver).currentActivity();
        Reporter.log("Current activity :" + currentActivity);
        if (activityName.equals(currentActivity)) {
            return true;
        } else {
            return false;
        }
    }

    public void tap(int fingers, int x, int y, int duration) {
        new TouchAction(driver)
                .press(point(x, y))
                .waitAction(waitOptions(Duration.ofSeconds(duration)))
                .release().perform();
    }

    public void tapOnText(String text) {
        waitForElementToBeClickable(By.xpath(String.format("//*[@text = '%s']", text)));
        driver.findElement(By.xpath(String.format("//*[@text = '%s']", text))).click();
    }

    //TODO - Need to place this method in proper place
    public void closeActiveBookingIfAny(String accessToken, String driverId) {
        int status;
        int count = 0;
        do {
            try {
                Runtime.getRuntime().exec(String.format("redis-cli -h 10.120.15.223 -p 6379 DEL driver-active-booking-%s", driverId));
            } catch (IOException e) {
                e.printStackTrace();
            }
            status = new ActiveBookingClient().activeBookingClientCommon(accessToken, driverId);
            count++;
            TestHelper.wait(1000);
        } while (status == 200 && count < 10);
    }

    public void waitForActivityToAppear(String activityName) throws InterruptedException {
        int i = 0;
        while (i < 30) {
            String currentActivity = ((AndroidDriver) driver).currentActivity();
            System.out.println("Current activity :" + currentActivity);
            if (currentActivity.equals(activityName)) {
                break;
            } else {
                Thread.sleep(1000);
                if (i == 29) {
                    Assert.fail("Did not load : " + activityName);
                }
                i++;
            }
        }
    }

    public void waitForActivitiesToAppear(List<String> activityName) throws InterruptedException {
        for (int i = 0; i < 30; i++) {
            String currentActivity = ((AndroidDriver) driver).currentActivity();
            if (activityName.contains(currentActivity))
                return;
            Thread.sleep(1000);
        }
        Assert.fail("Did not load : " + activityName);
    }

    public boolean verifyElementPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

    protected void tapOnElementWithByIfElementNotShown(By byOfButtonToBeTappedOn, WebElement elementToBeShown) {
        try {
            waitForTextToBeNonEmpty(elementToBeShown, 60);
        } catch (TimeoutException te) {
            waitForElementToBeClickable(byOfButtonToBeTappedOn,60);
            List<WebElement> elements = driver.findElements(byOfButtonToBeTappedOn);
            WebElement elementToTapOn = elements.stream().filter(WebElement::isEnabled).collect(Collectors.toList()).get(elements.size() - 1);
            elementToTapOn.click();
            waitForTextToBeNonEmpty(elementToBeShown);
        }
    }

    public void pressBack() {
        pressKeyEvent(AndroidKey.BACK);
    }

    protected void pressKeyEvent(AndroidKey androidKey) {
        ((AndroidDriver) driver).pressKey(new KeyEvent(androidKey));
    }

    public void pressHome() {
        pressKeyEvent(AndroidKey.HOME);
    }

    public void openNotificationTray() {
        ((AndroidDriver) driver).openNotifications();
    }

    public void dismissOnboarding() throws InterruptedException {
        Thread.sleep(4000);
        int x = driver.manage().window().getSize().getWidth() / 2;
        int y = driver.manage().window().getSize().getHeight() / 2;
        for (int i = 0; i < 2; i++) {
            Thread.sleep(2000);
            tap(1, x, y, 1);
        }

    }

    public void dragAndDrop(MobileElement src, MobileElement trgt){
        Point source = src.getCenter();
        Point target = trgt.getCenter();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence dragNDrop = new Sequence(finger, 0);
        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0),
                PointerInput.Origin.viewport(), source.x, source.y));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        //need to add pause for iOS, otherwise it will fail
        dragNDrop.addAction(new Pause(finger,Duration.ofMillis(600)));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(1),
                PointerInput.Origin.viewport(),target.x, target.y));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        driver.perform(Arrays.asList(dragNDrop));

    }

    public void handleAlertIfPresent(){
        try {
            WebDriverWait alertWait= new WebDriverWait(driver,20);
            alertWait.until(ExpectedConditions.alertIsPresent()).dismiss();
        }catch (Exception e){
            System.out.println("No alert found");
        }
    }

    public void  captureScreenshot(ITestResult result){
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        StringBuffer completeFileName = new StringBuffer();
        completeFileName.append(result.getTestClass().getRealClass().getSimpleName());
        completeFileName.append("_");
        completeFileName.append(result.getName());

        Object[] parameters = result.getParameters();
        for(Object parameter : parameters) {
            completeFileName.append("_");
            completeFileName.append(parameter);
        }
        completeFileName.toString().replace(":", "-");


        try {
            FileUtils.copyFile(srcFile,new File("./build/screenshot/"+completeFileName+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

