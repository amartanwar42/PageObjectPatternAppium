package com.appium.pages;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.PointsPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class PointsPage extends CommonAppiumTest {

    private PointsPageObject pointsPageObject;

    public PointsPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        pointsPageObject=new PointsPageObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver),pointsPageObject);
    }


    public PointsPage verifyPointsPage(){
        try{
            waitForElementToBeVisible(pointsPageObject.points);
            return this;
        }
        catch (Exception e)
        {
            org.testng.Assert.fail("Points page is not visible",e);
            return this;
        }

    }


}
