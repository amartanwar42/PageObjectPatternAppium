package com.appium.pages;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.HomePageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends CommonAppiumTest {

    private HomePageObject homePageObject;

    public HomePage(AppiumDriver driver)  {
        super(driver);
        homePageObject =new HomePageObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver), homePageObject);
    }

    public HomePage tapOnAccountLink()
    {
        waitForElementToBeClickable(homePageObject.searchPlaceHolder,60);
        scrollUp();
        waitForElementToBeClickable(homePageObject.accountLink).click();
        return this;
    }

    public void validateHomePageDeepLink()
    {
        try {
            waitForElementToBeVisible(homePageObject.accountLink);
        }
        catch (Exception e){
            Assert.fail("Home page deep link did not work",e);
        }
    }

}
