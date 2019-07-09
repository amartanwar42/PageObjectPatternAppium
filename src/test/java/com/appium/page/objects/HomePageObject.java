package com.appium.page.objects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE,iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Account')]")
    @iOSXCUITFindBy(accessibility = "//XCUIElementTypeButton[@name='My Account']")
    public MobileElement accountLink;

    @AndroidFindBy(id="com.gojek.app.staging:id/toolbar_container")
    public WebElement searchPlaceHolder;
}
