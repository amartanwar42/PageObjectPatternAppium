package com.appium.pages;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.FoodPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FoodPage extends CommonAppiumTest {

    private FoodPageObject foodPageObject;

    public FoodPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        foodPageObject=new FoodPageObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver),foodPageObject);
    }


    public FoodPage tapOnVoucherAppliedButton()
    {
        try {
            waitForElementToBeClickable(foodPageObject.voucherAppliedButton);

        }
        catch (Exception e){
            Assert.fail("Voucher is not applied or auto apply timed out",e);
        }
        foodPageObject.voucherAppliedButton.click();
        return this;
    }

    public FoodPage tapOnGotItButton()
    {
        waitForElementToBeClickable(foodPageObject.gotItButton);
        foodPageObject.gotItButton.click();
        return this;
    }

    public FoodPage validateVoucherApplied(String amount)
    {
        waitForElementToBeVisible(foodPageObject.voucherApplied);

        Assert.assertEquals(foodPageObject.voucherApplied.getText(),amount);
        return this;

    }
}
