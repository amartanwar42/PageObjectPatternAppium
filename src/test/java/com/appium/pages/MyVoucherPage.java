package com.appium.pages;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.MyVouchersPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class MyVoucherPage extends CommonAppiumTest {

    private MyVouchersPageObject myVouchersPageObject;

    public MyVoucherPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        myVouchersPageObject=new MyVouchersPageObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver),myVouchersPageObject);
    }

    public MyVoucherPage verifyMyVoucherPage(){
        try{
            waitForElementToBeVisible(myVouchersPageObject.myVouchersTitle);
            return this;
        }

        catch (Exception e){
            Assert.fail("either deeplink is incorrect or waitForElementToBeVisible is timed out",e);
            return this;
        }

    }

    public MyVoucherPage tapOnVoucherBatch()
    {

        waitForElementToBeVisible(myVouchersPageObject.myVouchersTitle);
        Reporter.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Before Scroll start",true);
        scrollDownTo(By.xpath("//android.widget.TextView[@text='[Mobile-Automation][MyVoucher1]']"));
        myVouchersPageObject.voucherTitlte.click();
        return this;
    }

    public MyVoucherPage tapOnUseButton()
    {
        waitForElementToBeVisible(myVouchersPageObject.myVouchersTitle);
        scrollDownTo(By.xpath("//android.widget.TextView[@text='[Mobile-Automation][MyVoucher1]']"));
        waitForElementToBeClickable(myVouchersPageObject.voucherUseButton);
        myVouchersPageObject.voucherUseButton.click();
        return this;
    }

    public MyVoucherPage tapOnVoucherDetailsUsebtn(){
        waitForElementToBeClickable(myVouchersPageObject.voucherDetailsUsebtn);
        myVouchersPageObject.voucherDetailsUsebtn.click();
        return this;
    }
}
