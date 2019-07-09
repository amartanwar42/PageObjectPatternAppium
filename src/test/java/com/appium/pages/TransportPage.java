package com.appium.pages;

import com.appium.config.CommonAppiumTest;
import com.appium.page.objects.TransportPageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TransportPage extends CommonAppiumTest {

    private TransportPageObject transportPageObject;

    public TransportPage(AppiumDriver<MobileElement> driver) {
        super(driver);
        transportPageObject=new TransportPageObject();
        PageFactory.initElements(new AppiumFieldDecorator(driver),transportPageObject);
    }

    public TransportPage enterDestination()
    {
        waitForElementToBeClickable(transportPageObject.destination,60);
        transportPageObject.destination.click();
        transportPageObject.destination.sendKeys("Johar Baru");

        waitForElementToBeClickable(transportPageObject.location,30);
        transportPageObject.location.click();
        return this;
    }

    public TransportPage validateSerivceIsRide(String serviceType)
    {
        try{
            waitForElementToBeVisible(transportPageObject.rideServiceType,30);
        }
        catch (Exception e){
            e.printStackTrace();
            Assert.assertEquals(transportPageObject.rideServiceType.getText(),serviceType);
        }

        return this;
    }


    public TransportPage validatePromoCodeIsAutosApplied(String amount){

        try{
            waitForElementToBeVisible(transportPageObject.promoCode,30);
            Assert.assertEquals(transportPageObject.promoCode.getText(),amount);
        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail("Voucher is not applied");
        }
        return this;

    }

    public TransportPage tapOnPickUpButton(){
        waitForElementToBeClickable(transportPageObject.setPickupButton,30);
        transportPageObject.setPickupButton.click();
        return this;
    }

    public TransportPage selectPaymentType(){
        waitForElementToBeClickable(transportPageObject.paymentType,30);
        transportPageObject.paymentType.click();

        waitForElementToBeClickable(transportPageObject.cashPayment,30);
        transportPageObject.cashPayment.click();
        return this;

    }



}
